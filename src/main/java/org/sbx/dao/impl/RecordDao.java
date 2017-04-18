package org.sbx.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sbx.dao.Dao;
import org.sbx.dao.util.SQLStatement;
import org.sbx.dao.util.ConnectionFactory;
import org.sbx.model.impl.Record;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class RecordDao implements Dao<Record> {

    private static final Logger LOGGER = LogManager.getLogger(RecordDao.class);

    private static final String RECORD_SUCCESSFULLY_ADDED_INFO_LOG_MESSAGE = "Record has been successfully added.";
    private static final String RECORDS_SUCCESSFULLY_ADDED_INFO_LOG_MESSAGE = "{} records have been successfully added.";
    private static final String RECORD_IS_LOADED_INFO_LOG_MESSAGE = "Record is loaded";
    private static final String RECORS_ARE_LOADED_INFO_LOG_MESSAGE = "{} records are loaded";
    private static final String RECORD_SUCCESSFULLY_ADDED_DEBUG_LOG_MESSAGE = "Record has been successfully added: {}";
    private static final String RECORD_IS_LOADED_DEBUG_LOG_MESSAGE = "Record is loaded: {}";

    private ConnectionFactory connectionFactory;

    public RecordDao(){
        connectionFactory = new ConnectionFactory();
    }

    public boolean addObjectToDB(Record record) throws SQLException {

        boolean success = false;

        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement preparedStatement = getAddPreparedStatement(connection, record)) {

            if (preparedStatement.executeUpdate() > 0){
                success = true;
                connection.commit();
                LOGGER.info(RECORD_SUCCESSFULLY_ADDED_INFO_LOG_MESSAGE);
                LOGGER.debug(RECORD_SUCCESSFULLY_ADDED_DEBUG_LOG_MESSAGE, record);
            }
        }

        return success;
    }

    public int addListToDB(List<Record> records) throws SQLException {

        int n = 0;

        try (Connection connection = connectionFactory.getConnection()) {

            for (Record record: records){
                try (PreparedStatement preparedStatement = getAddPreparedStatement(connection, record)) {
                    if (preparedStatement.executeUpdate() > 0){
                        n++;
                        LOGGER.debug(RECORD_SUCCESSFULLY_ADDED_DEBUG_LOG_MESSAGE, record);
                    }
                }
            }

            connection.commit();

            LOGGER.info(RECORDS_SUCCESSFULLY_ADDED_INFO_LOG_MESSAGE, n);
        }

        return n;
    }

    public Record getById(int id) throws SQLException {

        Record record = new Record();

        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement preparedStatement = getSelectSinglePreparedStatement(connection, id);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()){
                record = getRecord(resultSet);
                LOGGER.info(RECORD_IS_LOADED_INFO_LOG_MESSAGE);
                LOGGER.debug(RECORD_IS_LOADED_DEBUG_LOG_MESSAGE, record);
            }
        }

        return record;

    }

    public List<Record> getByDateRange(LocalDateTime firstDate, LocalDateTime lastDate) throws SQLException {

        List<Record> records;

        java.sql.Date firstSqlDate = new Date(Date.from(firstDate.atZone(ZoneId.systemDefault()).toInstant()).getTime());
        java.sql.Date lastSqlDate = new Date(Date.from(lastDate.atZone(ZoneId.systemDefault()).toInstant()).getTime());

        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement preparedStatement = getSelectDateRangePreparedStatement(connection, firstSqlDate, lastSqlDate);
             ResultSet resultSet = preparedStatement.executeQuery()){

            records = getRecordList(resultSet);
        }

        return records;
    }

    public List<Record> getByTitle(String title) throws SQLException {

        List<Record> records;

        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement preparedStatement = getSelectSinglePreparedStatement(connection, title);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            records = getRecordList(resultSet);
        }

        return records;
    }

    public List<Record> getAllRecords() throws SQLException {

        List<Record> records;

        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQLStatement.SELECT_ALL_STATEMENT);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            records = getRecordList(resultSet);
        }

        return records;
    }

    private Record getRecord(ResultSet resultSet) throws SQLException{
        Record record = new Record();

        return record.newBuilder()
                .setId(resultSet.getInt("rec_id"))
                .setTitle(resultSet.getString("rec_title"))
                .setAuthor(resultSet.getString("rec_author"))
                .setDate(resultSet.getDate("rec_date"))
                .setBody(resultSet.getString("rec_body")).build();
    }

    private List<Record> getRecordList(ResultSet resultSet) throws SQLException {

        List<Record> records = new ArrayList<>();

        while (resultSet.next()){
            Record record = getRecord(resultSet);
            records.add(record);
            LOGGER.debug(RECORD_IS_LOADED_DEBUG_LOG_MESSAGE, record);
        }

        LOGGER.info(RECORS_ARE_LOADED_INFO_LOG_MESSAGE, records.size());

        return records;
    }

    private PreparedStatement getAddPreparedStatement(Connection connection, Record record) throws SQLException{

        PreparedStatement preparedStatement = connection.prepareStatement(SQLStatement.ADD_SINGLE_RECORD_STATEMENT);

        preparedStatement.setString(1, record.getTitle());
        preparedStatement.setString(2, record.getAuthor());
        preparedStatement.setDate(3, new java.sql.Date(record.getDate().getTime()));
        preparedStatement.setString(4, record.getBody());

        return preparedStatement;

    }

    private PreparedStatement getSelectSinglePreparedStatement(Connection connection, int id) throws SQLException{

        PreparedStatement preparedStatement = connection.prepareStatement(SQLStatement.SELECT_SINGLE_RECORD_BY_ID);

        preparedStatement.setInt(1, id);

        return preparedStatement;

    }

    private PreparedStatement getSelectSinglePreparedStatement(Connection connection, String name) throws SQLException{

        PreparedStatement preparedStatement = connection.prepareStatement(SQLStatement.SELECT_SINGLE_RECORD_BY_TITLE);

        preparedStatement.setString(1, name);

        return preparedStatement;

    }

    private PreparedStatement getSelectDateRangePreparedStatement(Connection connection, java.sql.Date fromDate, java.sql.Date toDate) throws SQLException{

        PreparedStatement preparedStatement = connection.prepareStatement(SQLStatement.SELECT_RECORDS_RANGE);

        preparedStatement.setDate(1, fromDate);
        preparedStatement.setDate(2, toDate);

        return preparedStatement;
    }
}

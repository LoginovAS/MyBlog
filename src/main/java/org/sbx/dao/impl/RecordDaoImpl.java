package org.sbx.dao.impl;

import org.sbx.dao.RecordDao;
import org.sbx.dao.enums.SQLStatement;
import org.sbx.dao.util.ConnectionFactory;
import org.sbx.model.Record;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by isilme on 4/14/17.
 */
public class RecordDaoImpl implements RecordDao {

    private Connection connection;
    private ConnectionFactory connectionFactory;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    private Record record;
    private List<Record> records;

    public RecordDaoImpl(){
        connectionFactory = new ConnectionFactory();
    }

    public boolean addRecord(Record record) {

        boolean success = false;

        try {
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(SQLStatement.ADD_SINGLE_RECORD_STATEMENT.toString());

            setAddPreparedStatement(record);

            if (preparedStatement.executeUpdate() > 0){
                success = true;
                connection.commit();
            }

        } catch (SQLException ex) {

            try {
                if (connection != null)
                    connection.rollback();
            } catch (SQLException e) {
                System.out.println(e);
            }

            System.out.println(ex);
        } finally {
            close();
        }
        return success;
    }

    public boolean addRecords(List<Record> records){

        boolean success = false;

        try {
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(SQLStatement.ADD_SINGLE_RECORD_STATEMENT.toString());

            for (Record record: records){
                setAddPreparedStatement(record);

                if (preparedStatement.executeUpdate() > 0){
                    success = true;
                    connection.commit();
                }
            }
        } catch (SQLException ex) {
            try {
                if (connection != null)
                    connection.rollback();
            } catch (SQLException e) {
                System.out.println(e);
            }

            System.out.println(ex);

        } finally {
            close();
        }

        return success;
    }

    public Record getById(int id) {

        try {
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(SQLStatement.ADD_SINGLE_RECORD_STATEMENT.toString());

            setSelectSinglePreparedStatement(id);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                record = new Record();
                record.setId(resultSet.getInt("rec_id"));
                record.setAuthor(resultSet.getString("rec_author"));
                record.setDate(resultSet.getDate("rec_date"));
                record.setBody(resultSet.getString("rec_body"));
            }
        } catch (SQLException ex) {

            System.out.println(ex);

        } finally {
            close();
        }

        return record;
    }

    public List<Record> getByDateRange(java.sql.Date firstDate, java.sql.Date lastDate) {
        records = new ArrayList<Record>();

        try {
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(SQLStatement.SELECT_RECORDS_RANGE.toString());

            setSelectDateRangePreparedStatement(firstDate, lastDate);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                record = new Record();
                record.setId(resultSet.getInt("rec_id"));
                record.setTitle(resultSet.getString("rec_title"));
                record.setAuthor(resultSet.getString("rec_author"));
                record.setDate(resultSet.getDate("rec_date"));
                record.setBody(resultSet.getString("rec_body"));

                records.add(record);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            close();
        }

        return records;
    }

    public List<Record> getByTitle(String title) {

        records = new ArrayList<Record>();

        try {
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(SQLStatement.ADD_SINGLE_RECORD_STATEMENT.toString());

            setSelectSinglePreparedStatement(title);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                record = new Record();
                record.setId(resultSet.getInt("rec_id"));
                record.setTitle(resultSet.getString("rec_title"));
                record.setAuthor(resultSet.getString("rec_author"));
                record.setDate(resultSet.getDate("rec_date"));
                record.setBody(resultSet.getString("rec_body"));

                records.add(record);
            }
        } catch (SQLException ex){
            System.out.println(ex);
        } finally {
            close();
        }

        return records;
    }

    public List<Record> getAllRecords(){

        records = new ArrayList<Record>();

        try {
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(SQLStatement.SELECT_ALL_STATEMENT.toString());

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                record = new Record();
                record.setId(resultSet.getInt("rec_id"));
                record.setTitle(resultSet.getString("rec_title"));
                record.setAuthor(resultSet.getString("rec_author"));
                record.setDate(resultSet.getDate("rec_date"));
                record.setBody(resultSet.getString("rec_body"));

                records.add(record);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            close();
        }

        return records;
    }

    private void setAddPreparedStatement(Record record) throws SQLException{

        preparedStatement.clearParameters();

        preparedStatement.setString(1, record.getTitle());
        preparedStatement.setString(2, record.getAuthor());
        preparedStatement.setDate(3, record.getDate());
        preparedStatement.setString(4, record.getBody());

    }

    private void setSelectSinglePreparedStatement(int id) throws SQLException{

        preparedStatement.clearParameters();

        preparedStatement.setInt(1, id);

    }

    private void setSelectSinglePreparedStatement(String name) throws SQLException{

        preparedStatement.clearParameters();

        preparedStatement.setString(1, name);

    }

    private void setSelectDateRangePreparedStatement(java.sql.Date fromDate, java.sql.Date toDate) throws SQLException{
        preparedStatement.clearParameters();

        preparedStatement.setDate(1, fromDate);
        preparedStatement.setDate(2, toDate);
    }

    private void close(){
        try {
            if (resultSet != null)
                resultSet.close();

            if (preparedStatement != null)
                preparedStatement.closeOnCompletion();

            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}

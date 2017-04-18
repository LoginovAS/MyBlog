package org.sbx.services.impl;

import org.sbx.dao.Dao;
import org.sbx.dao.impl.RecordDao;
import org.sbx.model.impl.Record;
import org.sbx.services.RecordService;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RecordServiceImpl implements RecordService {

    private Dao<Record> recordDao;

    public RecordServiceImpl(){
        recordDao = new RecordDao();
    }

    public boolean addRecord(Record record) {

        boolean success = false;

        try {
            success = recordDao.addObjectToDB(record);
        } catch (SQLException ex){
            System.err.println(ex.getMessage());
        }

        return success;
    }

    public int addRecords(List<Record> records) {

        int success = 0;

        try {
            success = recordDao.addListToDB(records);
        } catch (SQLException ex){
            System.err.println(ex.getMessage());
        }

        return success;
    }

    public Record getById(int id) {

        Record record = new Record();

        try {
            record = recordDao.getById(id);
        } catch (SQLException ex){
            System.err.println(ex.getMessage());
        }

        return record;
    }

    public List<Record> getByDateRange(LocalDateTime firstDate, LocalDateTime lastDate) {

        List<Record> list = new ArrayList<>();

        try {
            list = recordDao.getByDateRange(firstDate, lastDate);
        } catch (SQLException ex){
            System.err.println(ex.getMessage());
        }

        return list;

    }

    public List<Record> getByTitle(String title) {

        List<Record> list = new ArrayList<>();

        try {
            list = recordDao.getByTitle(title);
        } catch (SQLException ex){
            System.err.println(ex.getMessage());
        }

        return list;
    }

    public List<Record> getAllRecords() {

        List<Record> list = new ArrayList<>();

        try {
            list = recordDao.getAllRecords();
        } catch (SQLException ex){
            System.err.println(ex.getMessage());
        }

        return list;
    }
}

package org.sbx.services.impl;

import org.sbx.dao.RecordDao;
import org.sbx.dao.impl.RecordDaoImpl;
import org.sbx.model.Record;
import org.sbx.services.RecordService;

import java.sql.Date;
import java.util.List;

/**
 * Created by isilme on 4/14/17.
 */
public class RecordServiceImpl implements RecordService {

    private RecordDao recordDao;

    public RecordServiceImpl(){
        recordDao = new RecordDaoImpl();
    }

    public boolean addRecord(Record record) {

        boolean success = recordDao.addRecord(record);

        if (success){
            System.out.println("New record has been added.");
        } else {
            System.out.println("Cannot add new record.");
        }

        return success;
    }

    public boolean addRecords(List<Record> records) {

        boolean success = recordDao.addRecords(records);

        if (recordDao.addRecords(records)){
            System.out.println("New records have been added.");
        } else {
            System.out.println("Cannot add new records.");
        }

        return success;
    }

    public Record getById(int id) {
        return recordDao.getById(id);
    }

    public List<Record> getByDateRange(Date firstDate, Date lastDate) {

        return recordDao.getByDateRange(firstDate, lastDate);

    }

    public List<Record> getByTitle(String title) {
        return recordDao.getByTitle(title);
    }

    public List<Record> getAllRecords() {
        return recordDao.getAllRecords();
    }
}

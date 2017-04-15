package org.sbx.dao;

import org.sbx.model.Record;

import java.util.Date;
import java.util.List;

/**
 * Created by isilme on 4/14/17.
 */
public interface RecordDao {

    boolean addRecord(Record record);

    boolean addRecords(List<Record> list);

    Record getById(int id);

    List<Record> getByDateRange(java.sql.Date firstDate, java.sql.Date lastDate);

    List<Record> getByTitle(String title);

    List<Record> getAllRecords();
}

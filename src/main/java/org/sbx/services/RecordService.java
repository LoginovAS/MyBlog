package org.sbx.services;

import org.sbx.model.Record;

import java.sql.Date;
import java.util.List;

/**
 * Created by isilme on 4/14/17.
 */
public interface RecordService {

    boolean addRecord(Record record);

    boolean addRecords(List<Record> records);

    Record getById(int id);

    List<Record> getByDateRange(Date firstDate, Date lastDate);

    List<Record> getByTitle(String title);

    List<Record> getAllRecords();

}

package org.sbx.services;

import org.sbx.model.impl.Record;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

public interface RecordService {

    boolean addRecord(Record record);

    int addRecords(List<Record> records);

    Record getById(int id);

    List<Record> getByDateRange(LocalDateTime firstDate, LocalDateTime lastDate);

    List<Record> getByTitle(String title);

    List<Record> getAllRecords();

}

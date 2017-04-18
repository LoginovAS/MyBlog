package org.sbx.dao;

import org.sbx.model.DBObject;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public interface Dao<T extends DBObject> {
    boolean addObjectToDB(T record) throws SQLException;

    int addListToDB(List<T> list) throws SQLException;

    T getById(int id) throws SQLException;

    List<T> getByDateRange(LocalDateTime firstDate, LocalDateTime lastDate) throws SQLException;

    List<T> getByTitle(String title) throws SQLException;

    List<T> getAllRecords() throws SQLException;
}

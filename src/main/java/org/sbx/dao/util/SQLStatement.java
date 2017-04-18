package org.sbx.dao.util;

public class SQLStatement {

    public static final String ADD_SINGLE_RECORD_STATEMENT = "INSERT INTO records (rec_title, rec_author, rec_date, rec_body) VALUES (?, ?, ?, ?)";
    public static final String SELECT_ALL_STATEMENT = "SELECT * FROM records";
    public static final String SELECT_SINGLE_RECORD_BY_ID = "SELECT * FROM records WHERE rec_id = ?";
    public static final String SELECT_SINGLE_RECORD_BY_TITLE = "SELECT * FROM records WHERE rec_title = ?";
    public static final String SELECT_RECORDS_RANGE = "SELECT * FROM records WHERE rec_date BETWEEN ? AND ?";

}

package org.sbx.dao.enums;

/**
 * Created by isilme on 4/14/17.
 */
public enum SQLStatement {

    ADD_SINGLE_RECORD_STATEMENT("INSERT INTO records (rec_title, rec_author, rec_date, rec_body) VALUES (?, ?, ?, ?)"),
    SELECT_ALL_STATEMENT("SELECT * FROM records"),
    SELECT_SINGLE_RECORD_BY_ID("SELECT * FROM records WHERE rec_id = ?"),
    SELECT_RECORDS_RANGE("SELECT * FROM records WHERE rec_date BETWEEN ? AND ?");

    private String statement;

    SQLStatement(String statement){
        this.statement = statement;
    }

    @Override
    public String toString() {
        return statement;
    }
}

package org.sbx.dao.enums;

/**
 * Created by isilme on 4/14/17.
 */
public enum ConnectionProperty {
    DRIVER("com.jdbc.mysql.Driver"),
    URL("jdbc:mysql://localhost:3306/blog"),
    NAME("root"),
    PASSWORD("root");

    private String property;

    ConnectionProperty(String property){
        this.property = property;
    }

    @Override
    public String toString() {
        return property;
    }
}

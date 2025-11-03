package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private String dbName;
    private String dbURL;
    private String user;
    private String password;
    public java.sql.Connection con;

    public DBConnection(String dbName , String user , String password) {
        this.dbName = dbName;
        this.user = user;
        this.password = password;
        this.dbURL = "jdbc:mysql://localhost:3306/" + dbName;
    }

    public Connection mySQLConnection(){
        con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(dbURL, user, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return con;
    }
}

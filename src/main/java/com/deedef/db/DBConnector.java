package com.deedef.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by S2D on 7/24/15.
 */
public class DBConnector {

    String db;
    String dbUsername;
    String dbPassword;

    public DBConnector(String db, String dbUsername, String dbPassword) {
        this.db = db;
        this.dbPassword = dbPassword;
        this.dbUsername = dbUsername;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getDbUsername() {
        return dbUsername;
    }

    public void setDbUsername(String dbUsername) {
        this.dbUsername = dbUsername;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public Connection connect(){
        Connection connection = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(db, dbUsername, dbPassword);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return connection;
    }

}

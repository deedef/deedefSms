package com.deedef.db;

import org.json.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by S2D on 7/25/15.
 */
public class Updater {

    DBConnector dbConnector;

    public Updater(DBConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    public boolean putColumnsInTable(String table, JSONObject keysandValues, JSONObject where) throws Exception{
        Connection connection = null;
        PreparedStatement query;

        String setStatement = "";
        String whereStatement = "";
        List setList = new ArrayList();
        List whereList = new ArrayList();
        for(String key : keysandValues.keySet()){
            setStatement += String.format("%s=?,", key);
            setList.add(keysandValues.get(key));
        }
        setStatement = setStatement.substring(0, setStatement.length() - 1);
        for(String key : where.keySet()){
            whereStatement += String.format("%s=? AND ", key);
            whereList.add(where.get(key));
        }
        whereStatement = whereStatement.substring(0, whereStatement.length() - 5);

        boolean b = true;
        try{
            connection = dbConnector.connect();
            String queryString = String.format("UPDATE %s SET %s WHERE %s;", table, setStatement, whereStatement);
            query = connection.prepareStatement(queryString);
            int index = 1;
            for(int i = 0; i < keysandValues.length(); i++){
                query.setObject(index, setList.get(i));
                index++;
            }
            for(int i = 0; i < where.length(); i++){
                query.setObject(index, whereList.get(i));
                index++;
            }
            b = query.executeUpdate() != 0;

            query.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            if(connection != null)
                connection.close();
        }

        return b;
    }
}

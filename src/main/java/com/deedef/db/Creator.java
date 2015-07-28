package com.deedef.db;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by S2D on 7/25/15.
 */
public class Creator {

    DBConnector dbConnector;

    public Creator(DBConnector dbConnector){
        this.dbConnector = dbConnector;
    }

    public boolean postRecordToTable(String table, JSONObject keysandValues) throws Exception{
        Connection connection = null;
        PreparedStatement query;

        String keys = "";
        String values = "";
        int length = keysandValues.length();
        List list = new ArrayList();
        for(String key : keysandValues.keySet()){
            keys += key + ",";
            values += "?,";
            list.add(keysandValues.get(key));
        }
        keys = keys.substring(0, keys.length() - 1);
        values = values.substring(0, values.length() - 1);

        boolean b = true;
        try{
            connection = dbConnector.connect();
            String queryString = String.format("INSERT INTO %s (%s) VALUES(%s);", table, keys, values);
            query = connection.prepareStatement(queryString);
            for(int i = 1; i <= length; i++){
                query.setObject(i,list.get(i-1));
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

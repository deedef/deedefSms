package com.deedef.db;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by S2D on 7/25/15.
 */
public class Retriever {

    DBConnector dbConnector;

    public Retriever(DBConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    public JSONArray getColumnFromTableById(String cols, String table, String idColumnName, int id) throws Exception{
        Connection connection = null;
        PreparedStatement query;
        ResultSetConverter converter = new ResultSetConverter();
        JSONArray array = new JSONArray();

        try{
            connection = dbConnector.connect();
            String queryString = String.format("SELECT %s FROM %s WHERE %s=?;", cols, table, idColumnName);
            query = connection.prepareStatement(queryString);
            query.setInt(1, id);
            ResultSet rs = query.executeQuery();
            array = converter.toJSONArray(rs);

            query.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            if(connection != null)
                connection.close();
        }

        return array;
    }

    public JSONArray getRecordFromTableById(String table, String idColumnName, int id) throws Exception{
        Connection connection = null;
        PreparedStatement query;
        ResultSetConverter converter = new ResultSetConverter();
        JSONArray array = new JSONArray();

        try{
            connection = dbConnector.connect();
            String queryString = String.format("SELECT * FROM %s WHERE %s=?;", table, idColumnName);
            query = connection.prepareStatement(queryString);
            query.setInt(1, id);
            ResultSet rs = query.executeQuery();
            array = converter.toJSONArray(rs);

            query.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            if(connection != null)
                connection.close();
        }

        return array;
    }

}

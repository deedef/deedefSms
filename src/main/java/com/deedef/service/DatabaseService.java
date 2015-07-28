package com.deedef.service;

import com.deedef.bean.Status;
import com.deedef.db.Creator;
import com.deedef.db.DBConnector;
import com.deedef.db.Retriever;
import com.deedef.db.Updater;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by S2D on 7/25/15.
 */

@Path("/db")
public class DatabaseService {

    @GET
    @Path("/retriever")
    public Response retrieve() {
        DBConnector dbConnector = new DBConnector("jdbc:mysql://localhost/deedefsmsdb", "root", "pass");
        Retriever retriever = new Retriever(dbConnector);

        try{
            JSONArray jsonArray = retriever.getRecordFromTableById("testtable", "idutilisateur", 1);
            return Response.status(200).entity(jsonArray.toString()).build();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return  Response.status(500).entity(new Status("Erreur",500)).build();
    }

     @GET
     @Path("/retriever/name")
     public Response retrieveName() {
        DBConnector dbConnector = new DBConnector("jdbc:mysql://localhost/deedefsmsdb", "root", "pass");
        Retriever retriever = new Retriever(dbConnector);

        try{
            JSONArray jsonArray = retriever.getColumnFromTableById("first,last", "testtable", "idutilisateur", 1);
            return Response.status(200).entity(jsonArray.toString()).build();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return  Response.status(500).entity(new Status("Erreur",500)).build();
    }

    @POST
    @Path("/creator")
    public Response create(){
        DBConnector dbConnector = new DBConnector("jdbc:mysql://localhost/deedefsmsdb", "root", "pass");
        Creator creator = new Creator(dbConnector);

        try{
            JSONObject o = new JSONObject();
            o.put("first","quelqun");
            o.put("last","dautre");
            o.put("comment","klk chose");
            boolean created = creator.postRecordToTable("testtable", o);
            if(created)
                return Response.status(200).entity("Created " + o.toString()).build();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return  Response.status(500).entity(new Status("Erreur",500)).build();
    }

    @PUT
    @Path("/updater")
    public Response update(){
        DBConnector dbConnector = new DBConnector("jdbc:mysql://localhost/deedefsmsdb", "root", "pass");
        Updater updater = new Updater(dbConnector);

        try{
            JSONObject set = new JSONObject();
            set.put("first","yahia");
            set.put("last","diop");
            set.put("comment","yekini");
            JSONObject where = new JSONObject();
            //where.put("first","Zale");
            //where.put("last","diould");
            where.put("idutilisateur","1");
            boolean updated = updater.putColumnsInTable("testtable", set, where);
            if(updated)
                return Response.status(200).entity("Updated!").build();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return  Response.status(500).entity(new Status("Erreur",500)).build();
    }

}

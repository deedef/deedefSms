package com.deedef.service;

import com.deedef.bean.Profil;
import com.deedef.bean.Status;
import com.deedef.dao.IProfileMgr;
import com.deedef.dao.Impl.ProfileMgrImpl;
import com.sun.jersey.spi.inject.Inject;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.math.BigInteger;

/**
 * Created by Saliou on 04/08/2015.
 */
@Path("/profil")
@Produces("application/json")
@Consumes("application/json")
public class ProfilService {
    @Inject
    public ProfileMgrImpl profilMgr;

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getProfil(@PathParam("id") BigInteger id) {

        // String result = smsMgr.save();
        Profil profil = profilMgr.get(id);
        if (profil == null) {
            Response.status(400).entity(new Status("Aucun profil trouv�", 400)).build();
        }
        return Response.status(200).entity(profil).build();

    }

    @GET
    @Path("login/{login}")
    @Produces("application/json")
    public Response getProfil(@PathParam("login") String login) {

        Profil profil = profilMgr.getByLogin(login);
        if (profil == null) {
            Response.status(400).entity(new Status("Aucun profil trouv�", 400)).build();
        }
        return Response.status(200).entity(profil).build();

    }

    @POST
    @Path("/create")
    @Produces("application/json")
    @Transactional(propagation = Propagation.REQUIRED)
    public Response saveProfil(Profil profil) {

        // String result = smsMgr.save();
        profilMgr.save(profil);
        return Response.status(201).entity(new Status("Profil cree avec succ�s", 201)).build();

    }


}

package com.deedef.service;

import com.deedef.bean.Contact;
import com.deedef.bean.Profil;
import com.deedef.bean.Status;
import com.deedef.dao.Impl.ContactMgrImpl;
import com.sun.jersey.spi.inject.Inject;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by Saliou on 04/08/2015.
 */
@Path("/contact")
@Produces("application/json")
@Consumes("application/json")
public class ContactService {
    @Inject
    public ContactMgrImpl contactMgr ;

    @GET
    @Path("/{id}/{email}")
    @Produces("application/json")
    public Response getContactFromUser(@PathParam("id") BigInteger userId, @PathParam("email") String email) {

        Contact contact = contactMgr.getContactByEmailFromUser(userId, email);
        if (contact == null) {
            Response.status(400).entity(new Status("Aucun contact trouv?", 400)).build();
        }
        return Response.status(200).entity(contact).build();

    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getContactFromUser(@PathParam("id") BigInteger userId) {

        List<Contact> contacts = contactMgr.getAllContactsFromUser(userId);
        if (contacts == null || contacts.isEmpty()) {
            Response.status(400).entity(new Status("Aucun contact trouv?", 400)).build();
        }
        return Response.status(200).entity(contacts).build();

    }

    @POST
    @Path("/create")
    @Produces("application/json")
    @Transactional(propagation = Propagation.REQUIRED)
    public Response saveContact(Contact contact) {
        System.out.println(contact.getEmailContact());
        System.out.println(contact.getId());
        System.out.println(contact.getNomContact());
        contactMgr.save(contact);
        return Response.status(201).entity(new Status("Contact cree avec succ?s", 201)).build();

    }
}

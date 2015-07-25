package com.deedef.sms;

import com.deedef.bean.*;
import com.deedef.dao.ISmsMgr;
import com.deedef.exception.ServiceException;
import com.deedef.service.ISendSmsService;
import com.deedef.service.impl.SendSmsServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Bamba on 27/11/2014.
 */

@Component
@Path("/sms")
public class SmsServices {


    @Autowired
    ISmsMgr smsMgr;
    /** The Constant log. */
    private final Logger logger = Logger.getLogger(getClass().getName());
    @GET
    @Path("/send")
    public Response savePayment() {

        String result = smsMgr.save();

        return Response.status(200).entity(result).build();

    }


    @GET
    @Path("/test")
    @Produces("application/xml")
    public Response test() {

       // String result = smsMgr.save();

        return Response.status(200).entity(new Status("Hello",200)).build();

    }

    @GET
    @Path("/secure")
    @Produces("application/xml")
    public Response testSecure() {

        // String result = smsMgr.save();

        return Response.status(200).entity(new Status("Service securise",200)).build();

    }
    private ISendSmsService sendSmsService = new SendSmsServiceImpl();




    @POST
    @Path("/SendMultiSms")

    public Response sendSms (@HeaderParam("username")String username, @HeaderParam("password") String password,RecipientsXmlBean listContact){


        return null;

    }
    @POST
    @Path("/send/{num}")
    public Response sendSms (@HeaderParam("username")String username, @HeaderParam("password") String password,@PathParam("num") String number, String content) throws ServiceException {


        SmsXmlBean retour = null;
        //v?rification sur le format du num?ro de t?l?phone
        if(number==null || number.length()!=11 || !number.startsWith("33"))
        {
            throw new ServiceException("Le format du num?ro de t?l?phone du destinataire du SMS est invalide ("+number+") le format est le suivant : 33621533749");
        }
        //authentification aupr?s du partenaire
        AuthentificationXmlBean authentification = new AuthentificationXmlBean(username, password);
        //contenu du message ? envoyer
        MessageXmlBean message = new MessageXmlBean("TestDeedef",content);
        //destinataire du sms
        List<GsmXmlBean> listGSM = new ArrayList<GsmXmlBean>();

        listGSM.add(new GsmXmlBean(number, 1));
        RecipientsXmlBean recipients = new RecipientsXmlBean(listGSM);

        //cr?ation du bean de retour
        retour = new SmsXmlBean(authentification, message,
                recipients);
        logger.debug("in createSmsXmlBean : "+retour);

        return Response.ok().entity(retour).build();
//        try {
//            sendSmsService.envoiSMS(number,content);
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        }
//        return null;

    }

    @POST
    @Path("/sendTest/{num}")
    public Response sendSingleSms (@HeaderParam("username")String username, @HeaderParam("password") String password,@PathParam("num") String number, String content) throws ServiceException {
       try {
           sendSmsService.envoiSMS(number, "TEST UNITAIRE (testEnvoiSMSEntreeValide)");
       }catch (Exception e){
           Response.status(Response.Status.BAD_REQUEST);
       }
        return Response.ok().build();
    }


    @POST
    @Path("/deedef/send/{numeros}")
    public Response sendMessage(@HeaderParam("username")String username, @HeaderParam("password") String password,@PathParam("numeros")String numeros,@QueryParam("content")String content){

        try {
            sendSmsService.envoiSMS(numeros, content);
        }catch (Exception e){
           return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();

    }



    }
package com.deedef.service;

import com.deedef.Constante.ConstantStatus;
import com.deedef.Constante.InitialisationDeedefKey;
import com.deedef.bean.Status;
import com.deedef.dao.Impl.ProfileMgrImpl;
import com.deedef.exception.ServiceException;
import com.deedef.security.DbToken;
import com.deedef.security.Payload;
import com.sun.jersey.spi.inject.Inject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.SessionFactory;
import org.jose4j.lang.JoseException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by birame ndiaye on 25/05/2015.
 */
@Path("/")
@Produces("application/json")
public class SecurityService {

    @Inject
    public static ProfileMgrImpl profilMgr;
    @Inject
    public static SessionFactory session;
    private
    @Context
    HttpServletRequest request;

    @POST
    @Path("authenticate")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response authenticate(JSONObject data) throws ServiceException, JSONException {
        // public Response authenticate(@FormParam("username") String username, @FormParam("password") String password, @FormParam("rememberMe") String rememberMe) throws ServiceException {
        String username = data.getString("username");
        String password = data.getString("password");
        DbToken token = new DbToken(username.trim(), password);
        token.setType("dbToken");
        String ipAdress = request.getHeader("X-FORWARDED-FOR");
        if (ipAdress == null) {
            ipAdress = request.getRemoteAddr();
        }
        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.login(token);
        } catch (AuthenticationException e) {
            return Response.status(401).build();
        }
        if (currentUser.isAuthenticated()) {
            //TODO FIXME : create here the payload object
            String now = new SimpleDateFormat("yyyyMMdd").format(new Date());
            Payload p = new Payload();
            p.setDateCreation(new Date());
            p.setExpiration(now);
            p.setUsername(username);
            p.setSalt(new Sha256Hash(ConstantStatus.SALT + "|" + now + username).toString());
            p.setIpAdresse(ipAdress);
            // TODO FIXME:  recuperer toutes les infos utiles � la constitution de la 1 ere page : Ex profil, role, permission, nombre de credit restant ...
            try {
                p.setSessionId(com.deedef.security.SecurityUtils.getSessionIdByPayload(p, InitialisationDeedefKey.DEEDEF_KEY_AES));
            } catch (JoseException e) {
                return Response.status(500).entity(new Status("Impossible de crypter la sessionId", 500)).build();
            }

            return Response.ok().entity(p).build();
        }

        return Response.status(401).build();
    }
}
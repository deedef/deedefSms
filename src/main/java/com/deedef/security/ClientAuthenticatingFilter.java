package com.deedef.security;

import com.deedef.Constante.ConstantStatus;
import com.deedef.Constante.InitialisationDeedefKey;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.util.WebUtils;
import org.jose4j.lang.JoseException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by birame ndiaye on 18/05/2015.
 */
public class ClientAuthenticatingFilter extends AuthenticatingFilter{

    protected static final String AUTHENTICATE_HEADER="WWW-Authenticate";
    @Override
    protected AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletRequest htpp= (HttpServletRequest) servletRequest;
        String sessionId= htpp.getHeader("X-deedef-auth");
       // if(org.apache.commons.lang.StringUtils.isNotBlank(sessionId))
        if(sessionId!=null){
            return getClientTokenBySessionId(sessionId);
        }

        return null;
    }
@Override
protected boolean  executeLogin(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
    ClientToken token= (ClientToken) createToken(servletRequest,servletResponse);
    if (token != null) {
        Subject currentUser= SecurityUtils.getSubject();
        try{
            currentUser.login(token);
        }catch(AuthenticationException au){
            throw new AuthenticationException(" Authentification failed");

        }
    }
    return true;
}

    public ClientToken getClientTokenBySessionId(String sessionId){
                          ClientToken token= new ClientToken();
        if(sessionId!=null){
            try{
                Payload payload= com.deedef.security.SecurityUtils.getPayloadBySessionId(sessionId, InitialisationDeedefKey.DEEDEF_KEY_AES);
                String now = new SimpleDateFormat("yyyyMMdd").format(new Date());
                if(now.equals(payload.getExpiration())){
                    token=new ClientToken(payload.getUsername(),payload.getSalt());
                }else{
                    throw new RuntimeException("La sessionId est expirée");
                }
            } catch (JoseException e) {
                e.printStackTrace();
            }
        }
        return token;
    }
    @Override
    protected String getName(){
        return "ClientAuthenticating";
    }
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        executeLogin(servletRequest,servletResponse);
        Subject currentUser= SecurityUtils.getSubject();
        if(!currentUser.isAuthenticated()){
            HttpServletResponse response= WebUtils.toHttp(servletResponse);
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            String authcHeader=HttpServletRequest.BASIC_AUTH+" realm\""+getName() +"\"";
            response.setHeader(AUTHENTICATE_HEADER,authcHeader);
            return false;


        }
        return true;
    }
}

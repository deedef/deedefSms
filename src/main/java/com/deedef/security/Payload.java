package com.deedef.security;

import com.deedef.bean.Profil;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.ObjectMapper;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by birame ndiaye on 28/05/2015.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "payload")
public class Payload {
    private String username;
    private String ipAdresse;
    private String sessionId;
    private Profil profil;
    private String expiration;
    private Date dateCreation;
    private List<String> permissions;
    private List<String> roles;
    private String salt;


    public Payload(){}
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIpAdresse() {
        return ipAdresse;
    }

    public void setIpAdresse(String ipAdresse) {
        this.ipAdresse = ipAdresse;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }


    @JsonIgnore
    public Payload getAsObject(String json){
        ObjectMapper mapper= new ObjectMapper();
        Payload p=null;
        try{
            p=mapper.readValue(json, Payload.class);
        }catch(IOException e){
            e.printStackTrace();
        }
        return p;
    }

    @JsonIgnore
    public String getAsJson(Payload p){
        ObjectMapper mapper=new ObjectMapper();
        String payload=null;
        try {
             payload=mapper.writeValueAsString(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return payload;
    }
}

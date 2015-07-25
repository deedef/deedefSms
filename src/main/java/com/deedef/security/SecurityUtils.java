package com.deedef.security;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.ObjectMapper;
import org.jose4j.jwe.ContentEncryptionAlgorithmIdentifiers;
import org.jose4j.jwe.JsonWebEncryption;
import org.jose4j.jwe.KeyManagementAlgorithmIdentifiers;
import org.jose4j.keys.AesKey;
import org.jose4j.lang.ByteUtil;
import org.jose4j.lang.JoseException;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.io.IOException;
import java.security.Key;

/**
 * Created by birame ndiaye on 18/05/2015.
 */
public class SecurityUtils {


    public static  String encrypt(String password){
        return new Sha256Hash(password).toString();
    }
    static  void main(String args []) throws JoseException {
        Key key = new AesKey(ByteUtil.randomBytes(16));
        JsonWebEncryption jwe = new JsonWebEncryption();
        jwe.setPayload("Hello World!");
        jwe.setAlgorithmHeaderValue(KeyManagementAlgorithmIdentifiers.A128KW);
        jwe.setEncryptionMethodHeaderParameter(ContentEncryptionAlgorithmIdentifiers.AES_128_CBC_HMAC_SHA_256);
        jwe.setKey(key);
        String serializedJwe = jwe.getCompactSerialization();
        System.out.println("Serialized Encrypted JWE: " + serializedJwe);
        jwe = new JsonWebEncryption();
        jwe.setKey(key);
        jwe.setCompactSerialization(serializedJwe);
        System.out.println("Payload: " + jwe.getPayload());
    }


    public static Payload getAsObject(String json){
        ObjectMapper mapper= new ObjectMapper();
        Payload p=null;
        try{
            p=mapper.readValue(json, Payload.class);
        }catch(IOException e){
            e.printStackTrace();
        }
        return p;
    }

    public static Payload getPayloadBySessionId(String sessionId,Key key) throws JoseException {

        JsonWebEncryption  jwe = new JsonWebEncryption();
        jwe.setKey(key);
        jwe.setCompactSerialization(sessionId);
        System.out.println("Payload: " + jwe.getPayload());
        return getAsObject(jwe.getPayload()) ;
    }


    public static String getAsJson(Payload p){
        ObjectMapper mapper=new ObjectMapper();
        String payload=null;
        try {
            payload=mapper.writeValueAsString(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return payload;
    }
    public static String getSessionIdByPayload(Payload payload,Key key) throws JoseException {
        //Key key = new AesKey(ByteUtil.randomBytes(16));
        JsonWebEncryption jwe = new JsonWebEncryption();
        jwe.setPayload(getAsJson(payload));
        jwe.setAlgorithmHeaderValue(KeyManagementAlgorithmIdentifiers.A128KW);
        jwe.setEncryptionMethodHeaderParameter(ContentEncryptionAlgorithmIdentifiers.AES_128_CBC_HMAC_SHA_256);
        jwe.setKey(key);
        String serializedJwe = jwe.getCompactSerialization();
        System.out.println("Seesion crypte :"+serializedJwe);
        return serializedJwe;
    }


}

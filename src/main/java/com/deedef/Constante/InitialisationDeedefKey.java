package com.deedef.Constante;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.Key;
import java.util.Properties;

/**
 * Cette classe permet de charger la key de l'application au demarrage  de ce fait elle sera initialisée une seule fois
 * Created by birame ndiaye on 18/05/2015.
 */
public class InitialisationDeedefKey {

    public static Key DEEDEF_KEY_AES = null;
    private static String KEYSTORE = null;
    private static String STOREPASS = null;
    private static String ALIAS = null;
    private static String KEYPASS = null;
    private static String PROPERTIES_FILE = "deedefProperties";

    public static void init() {
        initParamKeystore();
        DEEDEF_KEY_AES = KeystoreUtil.getKeyFromKeyStore(KEYSTORE, STOREPASS, ALIAS, KEYPASS);
    }

    public static void initParamKeystore() {
        Properties props = new Properties();
        try {
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(PROPERTIES_FILE);
            if (null == is) {
                throw new FileNotFoundException("No" + PROPERTIES_FILE + " found in classpath");
            }
            props.load(is);
            STOREPASS =props.getProperty("deedef.storepass");
            KEYPASS =props.getProperty("deedef.keypass");
            ALIAS=props.getProperty("deedef.alias");
            KEYSTORE=props.getProperty("deedef.keystore");
            props.clone();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

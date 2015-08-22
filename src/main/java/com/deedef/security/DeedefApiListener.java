package com.deedef.security;

import com.deedef.Constante.InitialisationDeedefKey;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.ws.rs.ext.Provider;

/**
 * Created by birame ndiaye on 18/05/2015.
 */
@Provider
public class DeedefApiListener    implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("ServletContextListener destroyed");
    }

    //Run this before web application is started
    @Override
    public void contextInitialized(ServletContextEvent arg0)
    {
        System.out.println("loading keyStore ");
        InitialisationDeedefKey.init();

    }
}

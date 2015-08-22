package com.deedef.security;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * Created by Saliou on 14/08/2015.
 */

public class CrossDomainRequestFilter implements ContainerRequestFilter {


    @Override
    public ContainerRequest filter(ContainerRequest containerRequest) {
        //GET, POST, PUT, DELETE, ...
        String method = containerRequest.getMethod();
        // myresource/get/56bCA for example
        String path = containerRequest.getPath(true);

        if(method.equals("OPTIONS")) {
            throw new WebApplicationException(Response.Status.OK);
        }
//        //Get the authentification passed in HTTP headers parameters
//        String auth = containerRequest.getHeaderValue("X-deedef-auth");
//
//        //If the user does not have the right (does not provide any HTTP Basic Auth)
//        if(auth == null){
//            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
//        }
        return containerRequest;
    }


}

package com.web.gwc.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.glassfish.jersey.server.mvc.Viewable;

@Path("/")
public class HomeController {
    @GET
    public Viewable index(){
        return new Viewable("/layout/base");
    }
}

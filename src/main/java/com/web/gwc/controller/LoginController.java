package com.web.gwc.controller;

import com.web.gwc.dto.AuthDTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.glassfish.jersey.server.mvc.Viewable;

@Path("/login")
public class LoginController {

    @GET
    public Viewable index(){
        return new Viewable("/frontend/auth/login");
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response loginAction(AuthDTO authDTO){

        System.out.println(authDTO.getEmail());
        return Response.ok().build();
    }
}

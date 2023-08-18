package com.web.gwc.controller;

import com.web.gwc.dto.RegisterDTO;
import com.web.gwc.entity.User;
import com.web.gwc.service.UserService;
import com.web.gwc.util.Encryption;
import com.web.gwc.util.HibernateUtil;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.hibernate.Session;

import java.util.UUID;

@Path("/register")
public class RegisterController {
@POST
@Consumes(MediaType.APPLICATION_JSON)
public Response register(RegisterDTO registerDTO){
    UserService userService = new UserService();
    User byEmail =userService.getByEmail(registerDTO.getEmail());
    if (byEmail !=null){
       return Response.status(Response.Status.BAD_REQUEST).entity("Email already exists.").build();
    }else {
     User user = new User();
     //user.setName(registerDTO.getName());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(Encryption.encrypt(registerDTO.getPassword()));
        String verificationCode = UUID.randomUUID().toString();
        user.setVerification_code(verificationCode);
        userService.save(user);
        return Response.ok().entity("Register Success...").build();
    }
}
}

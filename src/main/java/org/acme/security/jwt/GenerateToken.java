package org.acme.security.jwt;

import java.util.Arrays;
import java.util.HashSet;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.smallrye.jwt.build.Jwt;
import org.acme.security.UserLoginBean;
import org.eclipse.microprofile.jwt.Claims;

@Path("/authen")
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class GenerateToken {
    /**
     * Generate JWT token
     */
    public static void main(String[] args) {
        String token =
           Jwt.issuer("https://felixtsang.com/issuer") 
             .upn("felix@linux.com")
        //     .preferredUserName("felix")
             .groups(new HashSet<>(Arrays.asList("User", "Admin"))) 
             .claim(Claims.birthdate.name(), "2001-07-13") 
            // .claim(Claims.exp.name(), "2022-07-13") 
           .sign();
        System.out.println(token);
    }

    public static String getJwtToken() {
      String token =
         Jwt.issuer("https://felixtsang.com/issuer") 
           .upn("felix@linux.com") 
           .preferredUserName("felix")
           .claim("name", "nathan")
           .groups(new HashSet<>(Arrays.asList("User", "Admin"))) 
           .claim(Claims.birthdate.name(), "2001-07-13")
           .claim("userid", "123")
         .sign();
      return token;
  }

    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("login")
    public UserLoginBean login( ) {
      
      UserLoginBean userLoginBean = new UserLoginBean();
      userLoginBean.setJwtToken(getJwtToken());
     
    return userLoginBean;
      //  return getJwtToken();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("logindemo")
    public UserLoginBean loginDemo( ) {
      
      UserLoginBean userLoginBean = new UserLoginBean();
      userLoginBean.setJwtToken(getJwtToken());
      userLoginBean.setUserId("1");
      userLoginBean.setUserName("Felix");;
     
    return userLoginBean;
      //  return getJwtToken();
    }
}

package edu.mum.security;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;


public class AuthenticateUser {
 
  public  void authenticate(AuthenticationManager authenticationManager) throws Exception {
  
	  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    while(true) {
      System.out.print("Please enter your username: ");
      String name = in.readLine();
      System.out.print("Please enter your password: ");
      String password = in.readLine();
      try {
        Authentication request = new UsernamePasswordAuthenticationToken(name, password);
        Authentication result = authenticationManager.authenticate(request);
        SecurityContextHolder.getContext().setAuthentication(result);
        break;
      } catch(AuthenticationException e) {
  		   System.out.println( );
       System.out.println("Authentication failed: " + e.getMessage());
      }
    }
	   System.out.println( );
       System.out.println("Successfully authenticated. Security context contains: " +
              SecurityContextHolder.getContext().getAuthentication());
  }
  
  public void logout() {
 
	  // Clears the context for the current user/thread
	  SecurityContextHolder.clearContext();
 }
}

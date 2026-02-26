package com.test;

import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class HelloService {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/text")
	public String simplePlainTextResponse()
	{
		return "This is simple restful web service plain test response"; 
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/html/{debit}")
	public String htmlTextResponse(@PathParam("debit") String card) {
		return"<html><body> <h1> Simple RestAPI HTML Response card no:"+card+"</h1> </body></html>";
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String greetUserResponse(@QueryParam("msg") String msg) {
		return msg;
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserDetails> listAllUsersData(){
		
		UserDetails u1=new UserDetails(1,"Sam","shetty","abc@gmail.com",6865962);
		UserDetails u2=new UserDetails(2,"San","rtrw","xyz@gmail.com",6066829);
		UserDetails u3=new UserDetails(3,"jkdg","fggw","ghi@gmail.com",3540915);
		return List.of(u1,u2,u3);
	}
}

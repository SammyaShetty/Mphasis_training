package com.test;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns = "/AsyncServelt" ,asyncSupported = true)
public class AsyncServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final long startTime=System.nanoTime();
		final AsyncContext asynContext=request.startAsync(request,response);
		
		new Thread()
		{
			@Override
			public void run() {
				try {
					ServletResponse response = asynContext.getResponse();
					response.setContentType("text/plain");
					
					PrintWriter out=response.getWriter();
					Thread.sleep(3500);
					out.println("work completed time elapsed: "+(System.nanoTime()-startTime));
					out.flush();
					asynContext.complete();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

}

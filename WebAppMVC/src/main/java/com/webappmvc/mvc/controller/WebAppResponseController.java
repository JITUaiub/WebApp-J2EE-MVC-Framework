package com.webappmvc.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Takes {@link HttpServletRequest} and {@link HttpServletResponse} objects from {@link WebAppController} and dispatch it to {@link Controller#doProcess(HttpServletRequest, HttpServletResponse)} for further work.
 * 
 * @author Md. Nashid Kamal
 * @version 1.0
 */
public class WebAppResponseController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	/**
	 * provided by Tomcat server Java Servlet API, from {@link javax.servlet.http.HttpServlet.doGet()}
	 * 
	 * @param req - an HttpServletRequest object that contains the request the client has made of the servlet
	 * @param resp  - an HttpServletResponse object that contains the response the servlet sends to the client
	 * 
	 * @throws ServletException if the request for the GET could not be handled
	 * @throws IOException if an input or output error is detected when the servlet handles the GET request
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processResponse(request, response);
	}
	 /**
		 * Process request and response objects and dispatch to views along with model.
		 * 
		 * @param request - an HttpServletRequest object that contains the request the client has made of the servlet
		 * @param response  - an HttpServletResponse object that contains the response the servlet sends to the client
		 * 
		 * @throws ServletException if the request for the GET or POST could not be handled
		 * @throws IOException if an input or output error is detected when the servlet handles the GET or POST request
		 */
	private void processResponse(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
    	
    	Controller controller = (Controller) request.getAttribute("controller");
    	controller.doProcess(request, response);
	}
	/**
	 * provided by Tomcat server Java Servlet API, from {@link javax.servlet.http.HttpServlet.doGet()}
	 * 
	 * @param req - an HttpServletRequest object that contains the request the client has made of the servlet
	 * @param resp  - an HttpServletResponse object that contains the response the servlet sends to the client
	 * 
	 * @throws ServletException if the request for the POST could not be handled
	 * @throws IOException if an input or output error is detected when the servlet handles the POST request
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processResponse(request, response);
	}
}

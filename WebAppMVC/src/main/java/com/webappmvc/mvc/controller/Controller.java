package com.webappmvc.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The Controller interface represents Controller. This interface must be implemented to act like a Controller
 * @author Md. Nashid Kamal 
 * @version 1.0
 */
public interface Controller{
	/**
	 * Process {@link HttpServletRequest} and {@link HttpServletResponse} and can dispatch request to other {@link Controller} or produce response for clients.
	 * 
	 * @param request  - an HttpServletRequest object that contains the request the client has made of the servlet
	 * @param response - an HttpServletResponse object that contains the response the servlet sends to the client
	 * @throws ServletException  if the request for the GET or POST could not be handled
	 * @throws IOException if an input or output error is detected when the servlet handles the GET or POST request
	 */
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	/**
	 * 
	 * @return mapping of {@link Controller} as a {@link String}
	 */
    public String addMapping();

}
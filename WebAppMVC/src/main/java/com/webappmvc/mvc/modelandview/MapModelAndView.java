package com.webappmvc.mvc.modelandview;

import javax.servlet.http.HttpServletRequest;

import com.webappmvc.mvc.controller.Controller;
import com.webappmvc.mvc.model.Model;
/**
 * Interface that simplified what required to get {@link Model} and view based on {@link Controller#addMapping()}.
 * 
 * @author Md. Nashid Kamal
 * @version 1.0
 */
public interface MapModelAndView {
	/**
	 * Map model and views according to WebAppmvc-mappings.xml
	 * 
	 * @param request - takes {@link HttpServletRequest} object and process mappings
	 */
	public void addMappingWithXML(HttpServletRequest request);
	/**
	 *  Takes controllerName and set model class path and view location.
	 * @param controllerName - takes {@link Controller#addMapping()} value and set model and view.
	 */
	public void setModelAndView(String controllerName);
	/**
	 * returns {@link Model}.
	 * 
	 * @return {@link Model} class path as {@link String}.
	 */
	public String getModel();
	/**
	 * returns view like JSP, HTML etc.
	 * 
	 * @return view location as {@link String}.
	 */
	public String getView();
}

package com.webappmvc.mvc.modelandview;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.webappmvc.mvc.controller.Controller;
import com.webappmvc.mvc.model.Model;
import com.webappmvc.mvc.parser.MVCModule;
import com.webappmvc.mvc.parser.XMLParser;
/**
 * Implementation of {@link ModelAndView} interface that simplified what required to get {@link Model} and view based on {@link Controller#addMapping()}.
 * 
 * @author Md. Nashid Kamals
 * @version 1.0
 */
public class ModelAndView implements MapModelAndView{
	private HashMap<Integer, MVCModule> map = new HashMap<Integer, MVCModule>();
	
	private String model = "";
	private String view = "";
	private String mappingURL = "";
	
	/**
	 * Constructor with {@link HttpServletRequest} object that call {@link #addMappingWithXML(HttpServletRequest)} on object creation.
	 * 
	 * @param request  - an HttpServletRequest object that contains the request the client has made of the servlet.
	 */
	public ModelAndView(HttpServletRequest request) {
		this.model = "";
		this.view = "";
		addMappingWithXML(request);
	}
	/**
	 * Map model and views according to WebAppmvc-mappings.xml
	 * 
	 * @param request  - an HttpServletRequest object that contains the request the client has made of the servlet.
	 */
	public void addMappingWithXML(HttpServletRequest request){
		this.map = parseXML(map, request);
		
	}
	/**
	 *  Takes controllerName and set model class path and view location.
	 * @param controllerName - takes {@link Controller#addMapping()} value and set model and view.
	 */
	public void setModelAndView(String controllerMappingURL){
		for(int i=0; i< map.size(); i++){ 
			if (map.get(i).getMappingURL().toString().equals(controllerMappingURL)) {
				if (map.get(i).getModel() == null) this.model = "empty"; else this.model = map.get(i).getModel();
				if (map.get(i).getView() == null) this.view = "empty"; else this.view = map.get(i).getView();
				if (map.get(i).getMappingURL() == null) this.mappingURL = "empty"; else this.mappingURL = map.get(i).getMappingURL();
				return;
			}else {
				this.model = "empty";
				this.view = "empty";
				this.mappingURL = "empty";
			}
		}
		
	}
	
	/**
	 * Process {@link XMLParser} and returns map as {@link HashMap}<{@link Integer}, {@link MVCModule}> 
	 * 
	 * @param map - {@link HashMap}<{@link Integer}, {@link MVCModule}> that will store all mappings.
	 * @param request -  - an HttpServletRequest object that contains the request the client has made of the servlet
	 * @return {@link HashMap} - that stores all the mappings done in WebAppmvc-mappings.xml
	 */
	private HashMap<Integer, MVCModule> parseXML(HashMap<Integer, MVCModule> map, HttpServletRequest request) {
		map = new XMLParser().getMap(request);
		return map;
	}

	/**
	 * returns {@link Model}.
	 * 
	 * @return {@link Model} class path as {@link String}.
	 */
	public String getModel() {
		return model;
	}

	/**
	 * returns view like JSP, HTML etc.
	 * 
	 * @return view location as {@link String}.
	 */
	public String getView() {
		return view;
	}
	/**
	 * Returns mapping URL of current active {@link Controller}
	 * 
	 * @return {@link ModelAndView#mappingURL} as {@link String}
	 */
	public String getMappingURL() {
		return mappingURL;
	}
    
}

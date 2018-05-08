package com.webappmvc.mvc.model;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
/**
 * The Model interface represents Model. This interface must be implemented to act like a Model.
 * @author Md. Nashid Kamal 
 * @version 1.0
 */
public interface Model {
	
	/**
	 * This method will store class members data on a {@link ArrayList} and return it. When developer request for model from {@link HttpServletRequest} object, It returns values using this method.
	 * 
	 * @return {@link ArrayList} - stored data will be returned as {@link ArrayList}.
	 */
	public ArrayList<?> getDataAsArrayList();
}

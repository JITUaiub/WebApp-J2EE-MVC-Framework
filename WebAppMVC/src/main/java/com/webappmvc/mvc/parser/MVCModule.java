package com.webappmvc.mvc.parser;
/**
 * MVC Module where each module have a view, model name that will be matched with a mappingURL.
 * 
 * @author Md. Nashid Kamal
 * @version 1.0
 */
public class MVCModule {
	private String view;
	private String model;
	private String mappingURL;
	
	/**
	 * Default Constructor 
	 */
	public MVCModule() {
		this("","", "");
	}
	
	/**
	 * Parameterized constructor.
	 * @param model - model name as {@link String}
	 * @param view - view name as {@link String}
	 * @param mappingURL - mappingURL name as {@link String}
	 */
	public MVCModule(String model, String view, String mappingURL) {
		super();
		this.view = view;
		this.model = model;
		this.mappingURL = mappingURL;
	}
	/**
	 * Returns view.
	 * 
	 * @return view name as {@link String}
	 */
	public String getView() {
		return view;
	}
	/**
	 * Set a view name.
	 * 
	 * @param view - Set view name.
	 */
	public void setView(String view) {
		this.view = view;
	}
	/**
	 * Returns model.
	 * 
	 * @return model name as {@link String}
	 */
	public String getModel() {
		return model;
	}
	/**
	 * Set a model name.
	 * 
	 * @param model - Set model name.
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * Returns mapping URL.
	 * 
	 * @return mappingURL value as {@link String}.
	 */
	public String getMappingURL(){
		return mappingURL;
	}
	/**
	 * Set a mapping URL.
	 * 
	 * @param mappingURL - Set mapping url for a model and view.
	 */
	public void setMappingURL(String mappingURL) {
		this.mappingURL = mappingURL;
	}
}

package com.webappmvc.mvc.controller;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webappmvc.mvc.model.Model;
import com.webappmvc.mvc.modelandview.ModelAndView;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/**
 * This class act like a master or global controller that every request and response will need to go through this controller.
 * @author Md. Nashid Kamal
 * @version 1.0
 */
public class WebAppController extends HttpServlet {
	
	private static final long serialVersionUID = -6265197827797854517L;
	private ModelAndView modelandView;
	private ArrayList<?> modelObject;
	private boolean modelFlag = false;
	
	/**
	 * provided by Tomcat server Java Servlet API, from {@link javax.servlet.http.HttpServlet.doGet()}.
	 * 
	 * @param req - an HttpServletRequest object that contains the request the client has made of the servlet.
	 * @param resp  - an HttpServletResponse object that contains the response the servlet sends to the client.
	 * 
	 * @throws ServletException if the request for the GET could not be handled
	 * @throws IOException if an input or output error is detected when the servlet handles the GET request
	 */
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException{
    	dispatchRequestToResponseController(req, resp);

    }
    
    /**
	 * provided by Tomcat server java Servlet API, from {@link javax.servlet.http.HttpServlet.doPost()}
	 * 
	 * @param req - an HttpServletRequest object that contains the request the client has made of the servlet
	 * @param resp  - an HttpServletResponse object that contains the response the servlet sends to the client
	 * 
	 * @throws ServletException if the request for the GET could not be handled
	 * @throws IOException if an input or output error is detected when the servlet handles the GET request
	 */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	dispatchRequestToResponseController(req, resp);
    }
    /**
	 * Process request and response objects and select {@link Controller} at runtime, then select {@link Model} and view. Then dispatch to {@link WebAppResponseController} with controller, view along with model.
	 * 
	 * 
	 * @param req - an HttpServletRequest object that contains the request the client has made of the servlet
	 * @param resp  - an HttpServletResponse object that contains the response the servlet sends to the client
	 * 
	 * @throws ServletException if the request for the GET or POST could not be handled
	 * @throws IOException if an input or output error is detected when the servlet handles the GET or POST request
	 */
	public void dispatchRequestToResponseController(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		modelandView = new ModelAndView(req);
        resp.setContentType("text/html");
        Controller controller = resolveController(req, resp);
        modelandView.setModelAndView(controller.addMapping());
        if(modelandView.getModel().equals("empty")){
			/// No Model For that Request
			modelFlag = false;
		}else {
			modelFlag = true;
		}
        String modelName = "";
		try {
			if (modelFlag) {
				//System.out.println("Modelndview.getmodel() = " + modelandView.getModel());
				modelObject = (ArrayList<?>) resolveModel(modelandView.getModel());
			}else {
				modelName = "empty";
			}
		} catch (NoSuchMethodException | SecurityException | InstantiationException
				| IllegalArgumentException | InvocationTargetException | IllegalAccessException e) {
			//e.printStackTrace();
		}
        String viewName = modelandView.getView();
        
        if (controller != null) {
        	//req.setAttribute("model", modelFlag==true ? modelObject : modelName);
        	//req.setAttribute("view", viewName);
        	//req.getRequestDispatcher("/response").forward(req, resp);
        	
        	req.setAttribute("controller", controller);
        	req.setAttribute("model", modelFlag==true ? modelObject : modelName);
        	req.setAttribute("view", viewName);
        	
        	req.getRequestDispatcher("/response").forward(req, resp);
        }
	}
	
	/**
	 * Resolve controller at runtime. This method returns a {@link Controller} object that can be used to serve that particular request.
	 * 
	 * @param req - an HttpServletRequest object that contains the request the client has made of the servlet
	 * @param resp  - an HttpServletResponse object that contains the response the servlet sends to the client
	 * @return {@link Controller} object as selected for a patricular request
	 * @throws IOException if an input or output error is detected when the servlet handles the GET or POST request
	 */
    private Controller resolveController(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String path = req.getRequestURI().substring(req.getContextPath().length());
        Object obj = req.getServletContext().
                getAttribute("controllers");

        if (obj instanceof List) {
            @SuppressWarnings("unchecked")
			Optional<Controller> first = ((List<Controller>) obj).stream()
                    .filter(p -> path.equals(p.addMapping()))
                    .findFirst();

            if (first.isPresent()) {
                return first.get();
            }
        }
        return null;
    }
    
    /**
	 * Resolve model at runtime. This method returns a {@link Model} object that can be used to get data for that request.
	 * 
	 * @param className - takes full Qualified classPath of a model and return that object
	 * @return {@link Controller} object as selected for a patricular request
	 * @throws IOException if an input or output error is detected when the servlet handles the GET or POST request
	 */
    private Object resolveModel(String className) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    	Object invokedObject = null;
		try {
			Class<?> loadClass = Class.forName(className);
			
			Object selectedModelClass = loadClass.newInstance();
			Method methodName = selectedModelClass.getClass().getMethod("getDataAsArrayList");;
			invokedObject = methodName.invoke(selectedModelClass);
		} catch (ClassNotFoundException e) {
			
		}
    	
    	return invokedObject;
	}

}
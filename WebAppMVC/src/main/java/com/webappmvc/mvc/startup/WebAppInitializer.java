package com.webappmvc.mvc.startup;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.HandlesTypes;

import com.webappmvc.mvc.controller.Controller;
import com.webappmvc.mvc.controller.WebAppController;
import com.webappmvc.mvc.controller.WebAppResponseController;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * This class will load on startup and will add all controller with application Context. This class also add {@link WebAppController} and {@link WebAppResponseController} as global and response controller.
 * {@link WebAppController} adds all {@link Controller} on servlet context. @HandlesTypes used to add all instance of all class that derived or implemented {@link Controller}} interface.
 * @author Md. Nashid Kamal
 * @version 1.0
 */
@HandlesTypes({Controller.class})
public class WebAppInitializer implements ServletContainerInitializer {
    
	/**
	 *  Called on application startup through META-file that placed in META-INF/services/javax.servlet.ServletContainerInitializer
	 *  
	 *  @param controllerClassSet - classes from Controller.class
	 *  @param ctx - Application servlet context.
	 *  
	 *  @throws - {@link ServletException}
	 */
    public void onStartup (Set<Class<?>> controllerClassSet, ServletContext ctx)
              throws ServletException {
        List<Controller> controllerList = new ArrayList<Controller>();
        if (controllerClassSet != null) {
            for (Class<?> controller : controllerClassSet) {
                if (!controller.isInterface() &&
                          !Modifier.isAbstract(controller.getModifiers())) {
                    try {
                    	Controller tmp = (Controller) controller.newInstance();
                        controllerList.add(tmp);
                    } catch (Throwable ex) {
                        throw new ServletException(
                        		"Failed to instantiate WebAppInitializer class", ex);
                    }
                }
            }
        }
        if (controllerList.size() > 0) {
        	//Front Controller Implementation
            ctx.setAttribute("controllers", controllerList);
            ServletRegistration.Dynamic responseController = ctx.addServlet("WebAppResponseController",
                    "com.webappmvc.mvc.controller.WebAppResponseController");
            responseController.addMapping("/response");
            
            ServletRegistration.Dynamic servletRegistration = ctx.addServlet("WebappController",
                                                                             WebAppController.class);
            Iterator<Controller> iterator = controllerList.iterator();
            while (iterator.hasNext()) {
            	servletRegistration.addMapping(iterator.next().addMapping());
			}
            
            //JSP Filter Listener implementation
            //FilterRegistration.Dynamic jspFilter = ctx.addFilter("WebAppViewFilter", "test.WebAppViewFilter");
            //jspFilter.addMappingForUrlPatterns(null, true, "/view");
        }
    }
}
package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webappmvc.mvc.controller.Controller;
public class Home implements Controller{
	private String userName = "";
	
	public String addMapping() {
		return "/home";
	}


	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<String> model = (ArrayList<String>) request.getAttribute("model");		
		
		if(request.getSession().getAttribute("loggedUser") != null){
			userName = request.getSession().getAttribute("loggedUser").toString();
			for(int i=0; i<model.size(); i+=4){
				if (userName.equals(model.get(i))) {
					HttpSession session = request.getSession();
					session.setAttribute("userName", userName);
					session.setAttribute("name", model.get(i+1));
					session.setAttribute("dob", model.get(i+2));
					session.setAttribute("gender", model.get(i+3));
					
					request.getRequestDispatcher(request.getAttribute("view").toString()).forward(request, response);
				}
			}
		}else {
			response.sendRedirect("login");
		}
	}

}

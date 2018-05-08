package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webappmvc.mvc.controller.Controller;

public class Login implements Controller{
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(request.getParameter("login") != null && request.getParameter("userName") != null && request.getParameter("password") != null){
			if(!request.getParameter("userName").equals("") && !request.getParameter("password").equals("") && request.getParameter("login").equals("Login")){
				ArrayList<String> data = (ArrayList<String>) request.getAttribute("model");
				for(int i=0; i<data.size(); i+=2){
					if(request.getParameter("userName").toString().equals(data.get(i))){
						if(request.getParameter("password").toString().equals(data.get(i+1).toString())){
							session.setAttribute("loggedUser", data.get(i).toString());
							//request.getRequestDispatcher("/home").forward(request, response);
							response.sendRedirect("home");
							return;
						}
						request.setAttribute("errorMsg", "Invalid Login");
					}
				}
			}
		}
		
		request.getRequestDispatcher(request.getAttribute("view").toString()).forward(request, response);
	}
	
	public String addMapping() {
		
		return "/login";
	}
	
}

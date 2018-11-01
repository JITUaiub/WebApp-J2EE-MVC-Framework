package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webappmvc.mvc.controller.Controller;

import dao.UserLoginDao;
import dao.UsersDao;
import model.UserLogin;
import model.Users;


public class Registration implements Controller {
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("userName") != null && request.getParameter("name")!= null 
				&& request.getParameter("password")!= null && request.getParameter("dob")!= null 
				&& request.getParameter("gender")!= null 
				&& request.getParameter("reg")!= null){
			if(!request.getParameter("userName").equals("") && !request.getParameter("name").equals("") 
					&& !request.getParameter("password").equals("") && !request.getParameter("dob").equals("") 
					&& !request.getParameter("gender").equals("") 
					&& request.getParameter("reg").equals("Register Now")){
				UsersDao.saveUser(new Users(request.getParameter("userName"),
						request.getParameter("name"), request.getParameter("dob"), 
						request.getParameter("gender")));
				UserLoginDao.saveUser(new UserLogin(
						request.getParameter("userName"), request.getParameter("password")));
								
				request.setAttribute("errorMsg", "Registration Successfull.<br/><a href='login'>Login Now</a>");
				
			}
		}else {
			request.setAttribute("errorMsg", "All Fields Required");
		}
		
		request.getRequestDispatcher(request.getAttribute("view").toString()).forward(request, response);
	}
    
	public String addMapping() {
		return "/registration";
	}

}
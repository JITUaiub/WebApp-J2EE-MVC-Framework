package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webappmvc.mvc.controller.Controller;

public class LogOut implements Controller{

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		session.removeAttribute("loggedUser");
		session.removeAttribute("name");
		session.removeAttribute("userName");
		session.removeAttribute("dob");
		session.removeAttribute("gender");
		
		response.sendRedirect("login");
	}

	public String addMapping() {
		return "/logout";
	}

}

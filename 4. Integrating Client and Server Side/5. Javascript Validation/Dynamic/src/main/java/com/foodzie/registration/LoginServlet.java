package com.foodzie.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uemail = request.getParameter("username");
    	String upwd = request.getParameter("password");
    	Connection con = null;
    	HttpSession session = request.getSession();
    	RequestDispatcher dispatcher = null;
    	if (uemail == null || uemail.equals("")) {
    		request.setAttribute("status", "invalidEmail");
    		dispatcher = request.getRequestDispatcher("login.jsp");
    		dispatcher.forward(request, response);
    	}
    	if (upwd == null || upwd.equals("")) {
    		request.setAttribute("status", "invalidPassword");
    		dispatcher = request.getRequestDispatcher("login.jsp");
    		dispatcher.forward(request, response);
    	}
    	
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/upaisthit?allowPublicKeyRetrieval=true&useSSL=false", "root", "root");
    		PreparedStatement pst = con.prepareStatement("select * from admin_login where admin_email=? and admin_password=?");
    		pst.setString(1, uemail);
    		pst.setString(2, upwd);
    		
    		ResultSet rs = pst.executeQuery();
    		if(rs.next()) {
    			session.setAttribute("name", rs.getString("admin_name"));
    			dispatcher = request.getRequestDispatcher("index.jsp");
    		}else {
    			request.setAttribute("status", "fail");
    			dispatcher = request.getRequestDispatcher("login.jsp");
    		}
    		dispatcher.forward(request, response);
    	
    	} catch(Exception e) {
    		e.printStackTrace();
    		
    	} 
	}

}

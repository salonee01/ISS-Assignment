package com.foodzie.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	String uname = request.getParameter("name");
    	String uemail = request.getParameter("email");
    	String upwd = request.getParameter("pass");
    	String umobile = request.getParameter("contact");
    	RequestDispatcher dispatcher = null;
    	Connection con = null;
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/upaisthit?useSSL=false", "root", "root");
    		PreparedStatement pst = con.prepareStatement("insert into admin_login (admin_id, admin_name, admin_email, admin_password) VALUES (?, ?, ?, ?)");
    		pst.setString(1, umobile);
    		pst.setString(2, uname);
    		pst.setString(3, uemail);
    		pst.setString(4, upwd);
    		
    		int rowCount = pst.executeUpdate();
    		dispatcher = request.getRequestDispatcher("registration.jsp");
    		if (rowCount > 0) {
    			request.setAttribute("status", "success");    			
    		}else {
    			request.setAttribute("status", "fail");
    		}
    		dispatcher.forward(request, response);   		
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    		
    	} finally {
    		try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
	}

}

package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.EmployeeDAO;

public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Delete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.println("<h1>Unauthorized access to this page!</h1>");
		RequestDispatcher rd = request.getRequestDispatcher("Login.html");
		rd.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		System.out.println(request.getParameter("username"));

		ApplicationContext factory = new ClassPathXmlApplicationContext("beans.xml");
		EmployeeDAO obj = (EmployeeDAO) factory.getBean("empimpl");
		
		if(obj.deleteEmp(request.getParameter("username"))) {
			System.out.println("Deleted");
			response.sendRedirect("Success.jsp");

		}else {
			System.out.println("Error in delete");
			response.sendRedirect("Error.jsp");
		}

	}

}

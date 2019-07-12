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

import com.bean.Employee;
import com.bean.EmployeeDAO;


public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public UpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.println("<h1>Unauthorized access to this page!</h1>");
		RequestDispatcher rd = request.getRequestDispatcher("Login.html");
		rd.include(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Employee emp = new Employee();
		emp.setUsername(request.getParameter("username"));
		emp.setPassword(request.getParameter("password"));
		System.out.println("PASSWORD : "+request.getParameter("password"));
		emp.setAge(Integer.parseInt(request.getParameter("age")));
		emp.setEmail(request.getParameter("email"));
		emp.setDepartment(request.getParameter("department"));
		emp.setRole(request.getParameter("role"));

		ApplicationContext factory = new ClassPathXmlApplicationContext("beans.xml");
		EmployeeDAO obj = (EmployeeDAO) factory.getBean("empimpl");

		if (obj.updateEmp(emp)) {

			System.out.println("Successfully updated!");
			response.sendRedirect("Success.jsp");

		} else {
			System.out.println("Error occured while updation!");
			response.sendRedirect("Error.jsp");
		}
		System.out.println(emp.getUsername());
		
	}

}

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

@SuppressWarnings("resource")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.println("<h1>Unauthorized access to this page!</h1>");
		RequestDispatcher rd = request.getRequestDispatcher("Login.html");
		rd.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Employee emp = new Employee();
		emp.setUsername(request.getParameter("username"));
		emp.setPassword(request.getParameter("password"));

		ApplicationContext factory = new ClassPathXmlApplicationContext("beans.xml");
		EmployeeDAO obj = (EmployeeDAO) factory.getBean("empimpl");

		if (obj.checkLogin(emp)) {
			if (obj.checkAdmin(emp.getUsername())) {
				System.out.println("Admin Entered");
				response.sendRedirect("Options.html");
			} else {
				emp = obj.getEmp(emp.getUsername());
				request.setAttribute("emp", emp);
				RequestDispatcher rd = request.getRequestDispatcher("Employee.jsp");
				rd.forward(request, response);
				System.out.println("Unauthorized Entry");
			}
		} else {
			System.out.println("Invalid username or password");
		}

	}

}

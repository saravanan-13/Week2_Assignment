package com.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmployeeDAOImpl implements EmployeeDAO {
	Connection connection = null;

	public boolean databaseConnector() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/employee_db";
			String username = "root";
			connection = DriverManager.getConnection(url, username, "Sapient123");
			return true;
		}

		catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean insertEmp(Employee e) {

		try {

			String login = "insert into employee values(?,?,?,?,?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(login);
			preparedStatement.setString(1, e.getUsername());
			preparedStatement.setString(2, e.getPassword());
			preparedStatement.setInt(3, e.getAge());
			preparedStatement.setString(4, e.getEmail());
			preparedStatement.setString(5, e.getDepartment());
			preparedStatement.setString(6, e.getRole());

			try {
				preparedStatement.execute();
				return true;
			} catch (Exception exp) {
				System.out.println(exp);
				return false;

			}
		}

		catch (Exception exp) {
			System.out.println(exp);
			return false;

		}
	}

	@Override
	public boolean updateEmp(Employee e) {
		
		try {

			String update = "update employee set username = ?, password = ?, age = ?, email = ?, department = ?, role = ? where username = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(update);
			preparedStatement.setString(1, e.getUsername());
			preparedStatement.setString(2, e.getPassword());
			preparedStatement.setInt(3, e.getAge());
			preparedStatement.setString(4, e.getEmail());
			preparedStatement.setString(5, e.getDepartment());
			preparedStatement.setString(6, e.getRole());
			preparedStatement.setString(7, e.getUsername());

			try {
				preparedStatement.execute();
				return true;
			} catch (Exception exp) {
				System.out.println(exp);
				return false;

			}
		}

		catch (Exception exp) {
			System.out.println(exp);
			return false;

		}
		
	}

	@Override
	public Employee getEmp(String username) {

		try {
			String login = "select * from employee where username = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(login);
			preparedStatement.setString(1, username);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				Employee emp = new Employee();
				emp.setUsername(rs.getString(1));
				emp.setAge(Integer.parseInt((rs.getString(3))));
				emp.setEmail(rs.getString(4));
				emp.setDepartment(rs.getString(5));
				emp.setRole(rs.getString(6));
				return emp;
			} else {
				return null;
			}

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	@Override
	public ArrayList<Employee> getAllEmp() {

		try {
			String login = "select * from employee";

			PreparedStatement preparedStatement = connection.prepareStatement(login);
			ResultSet rs = preparedStatement.executeQuery();

			ArrayList<Employee> empList = new ArrayList<Employee>();
			
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setUsername(rs.getString(1));
				emp.setAge(Integer.parseInt((rs.getString(3))));
				emp.setEmail(rs.getString(4));
				emp.setDepartment(rs.getString(5));
				emp.setRole(rs.getString(6));

				empList.add(emp);
			}
			return empList;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public boolean deleteEmp(String username) {

		try {
			System.out.println(username);
			String delete = "delete from employee where username = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(delete);
			preparedStatement.setString(1, username);
			boolean rs = preparedStatement.execute();
			
			if (!rs) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			return false;
		}
		
	}
	
	@Override
	public boolean checkLogin(Employee emp) {

		try {
			String login = "select * from employee where username = ? and password = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(login);
			preparedStatement.setString(1, emp.getUsername());
			preparedStatement.setString(2, emp.getPassword());
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean checkAdmin(String username) {
		try {
			String login = "select role from employee where username = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(login);
			preparedStatement.setString(1, username);
			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
			if (rs.getString(1).equals("admin")) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

}

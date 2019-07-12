package com.bean;

import java.util.ArrayList;

public interface EmployeeDAO {
	public boolean insertEmp(Employee e);
	public boolean updateEmp(Employee e);
	public Employee getEmp(String username);
	public ArrayList<Employee> getAllEmp();
	public boolean deleteEmp(String username);
	public boolean checkLogin(Employee e);
	public boolean checkAdmin(String username);
}

package com.employees.Dao;

import java.util.List;

import com.employees.bean.EmployeeBean;

public interface EmployeeDao {

	public void addEmployee(EmployeeBean employeeBean);

	public void updateEmployee(EmployeeBean employeeBean);

	public EmployeeBean getEmployee(int id);

	public void deleteEmployee(int id);

	public List<EmployeeBean>

			getEmployees();
	
	public List getCountryList();
}

package com.employees.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employees.Dao.EmployeeDao;
import com.employees.bean.EmployeeBean;

@Service
public class EMployeeServiceImpli implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Override
	@Transactional
	public void addEmployee(EmployeeBean employeeBean) {
		employeeDao.addEmployee(employeeBean);
	}

	@Transactional
	@Override
	public void updateEmployee(EmployeeBean employeeBean) {
		employeeDao.updateEmployee(employeeBean);
	}

	@Transactional
	@Override
	public EmployeeBean getEmployee(int id) {

		return employeeDao.getEmployee(id);

	}

	@Transactional
	@Override
	public void deleteEmployee(int id) {
		employeeDao.deleteEmployee(id);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<EmployeeBean> getEmployees() {
		return employeeDao.getEmployees();
	}

	@Override
	public List getCountryList() 
	{
		return employeeDao.getCountryList();
				
	}

}

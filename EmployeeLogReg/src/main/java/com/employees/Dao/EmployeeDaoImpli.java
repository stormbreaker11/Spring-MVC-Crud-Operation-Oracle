package com.employees.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employees.bean.EmployeeBean;

@Repository
public class EmployeeDaoImpli  implements EmployeeDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public EmployeeDaoImpli(SessionFactory sessionFactory2)
	{
		this.sessionFactory=sessionFactory;
	}

	private Session getCurrentSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	@Transactional
	@Override
	public void addEmployee(EmployeeBean employeeBean)
	{

		getCurrentSession().save(employeeBean);
	}

	@Transactional
	@Override
	public void updateEmployee(EmployeeBean employeeBean)
	{
		EmployeeBean updateEmp= getEmployee(employeeBean.getId());
		updateEmp.setName(employeeBean.getName());
		updateEmp.setRating(employeeBean.getRating());
		getCurrentSession().update(updateEmp);
		
	}

	@Transactional
	@Override
	public EmployeeBean getEmployee(int id) 
	{
		EmployeeBean employeeBean=(EmployeeBean)getCurrentSession().get(EmployeeBean.class, id);
		return employeeBean;
	}
	
	@Transactional
	@Override
	public void deleteEmployee(int id) 
	{
		EmployeeBean employeeBean=getEmployee(id);
		if(employeeBean!=null)
		{
			getCurrentSession().delete(employeeBean);
		}
	}

	@Transactional
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeBean> getEmployees() 
	{
		return getCurrentSession().createQuery("from EmployeeBean").list();
	}

	@SuppressWarnings("deprecation")
	@Override
	public List getCountryList() {
		return (List) getCurrentSession().createSQLQuery("select * from Country").list();
	}

}

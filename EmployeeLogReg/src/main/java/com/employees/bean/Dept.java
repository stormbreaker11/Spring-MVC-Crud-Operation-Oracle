package com.employees.bean;

import javax.persistence.Table;


/**
 * @author Karthik
 *
 */
@Table(name = "Deptartment")
public class Dept {

	private Integer id;

	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
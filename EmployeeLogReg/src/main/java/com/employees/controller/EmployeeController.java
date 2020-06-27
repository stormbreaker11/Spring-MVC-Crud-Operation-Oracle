package com.employees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.employees.bean.EmployeeBean;
import com.employees.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeServices;

	@RequestMapping(value = "addTeam")
	public ModelAndView addEmployeePage() {
		ModelAndView modelAndView = new ModelAndView("add-employee");
		modelAndView.addObject("team", new EmployeeBean());
		return modelAndView;
	}

	@RequestMapping(value = "process")
	public ModelAndView addingTeam(@ModelAttribute EmployeeBean employeeBean) {

		ModelAndView modelAndView = new ModelAndView("home");
		employeeServices.addEmployee(employeeBean);

		System.out.println("Successfully added.");
		String message = "Team was successfully added.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}

	@RequestMapping(value = "teamList")
	public ModelAndView listOfTeams() {
		ModelAndView modelAndView = new ModelAndView("list-of-employees");

		List<EmployeeBean> teams = employeeServices.getEmployees();
		modelAndView.addObject("teams", teams);
		return modelAndView;
	}

	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public ModelAndView editTeamPage(@RequestParam Integer id) {
		ModelAndView modelAndView = new ModelAndView("edit-employee");
		EmployeeBean team = employeeServices.getEmployee(id);
		modelAndView.addObject("team", team);
		return modelAndView;
	}

	@RequestMapping(value = "/team/edit/{id}", method = RequestMethod.POST)
	public ModelAndView edditingTeam(@ModelAttribute EmployeeBean employeeBean, @PathVariable Integer id) {

		ModelAndView modelAndView = new ModelAndView("home");
		employeeServices.updateEmployee(employeeBean);
		String message = "Team was successfully edited.";
		modelAndView.addObject("message", message);

		return modelAndView;
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView deleteTeam(@RequestParam Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		employeeServices.deleteEmployee(id);
		String message = "Team was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}

	@RequestMapping
	public @ResponseBody String getCities(@ModelAttribute("team") EmployeeBean employeeBean, Model model,
			@RequestParam("distrct") String dist) {
		employeeServices.getCountryList();
		return "add-employee";
	}

}

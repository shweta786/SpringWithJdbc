/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.model.Employee;
import com.mycompany.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author SHWETA
 */
@Controller
@RequestMapping(value="/employee")
public class EmployeeController {
    
    @Autowired
    EmployeeService employeeService;
    
    @RequestMapping(value="/list", method=RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("employee/employee_page");
        List<Employee> list = employeeService.getEmployee();
        model.addObject("empList", list);        
        return model;
    }
    
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public ModelAndView add() {
        
        ModelAndView model = new ModelAndView("employee/employee_form");
        Employee employee = new Employee();        
        model.addObject("empForm", employee);        
        return model;
    }
    
    @RequestMapping(value="/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute Employee employee) {
        
        employeeService.addEmployee(employee);
        return new ModelAndView("redirect:/employee/list");
    }
}

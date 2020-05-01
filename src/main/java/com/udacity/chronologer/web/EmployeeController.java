package com.udacity.chronologer.web;


import com.udacity.chronologer.DTO.EmployeeDTO;

import com.udacity.chronologer.entity.Employee;

import com.udacity.chronologer.service.EmployeeService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;



    @GetMapping("/employee/{id}")
    public EmployeeDTO getEmployeeDTO(Long id){
        Employee employee = employeeService.getEmployee(id);
        return convertEntityToemployeeDTO(employee);
    }
    @GetMapping("/employee")
    public List<EmployeeDTO> getAllEmployeeDTO(){
        List<EmployeeDTO> listDto =  new ArrayList<>();
        List<Employee> employeeList = employeeService.getAllEmployee();
        for (Employee employee : employeeList) {
            EmployeeDTO employeeDTO = convertEntityToemployeeDTO(employee);

            listDto.add(employeeDTO);
        }
        return listDto;
    }

    @GetMapping("/employee/name")
    public EmployeeDTO getEmployeeByName(String name){
        Employee employee=employeeService.findByName(name);
        return convertEntityToemployeeDTO(employee);
    }

    @GetMapping("/employee/skills")
    public List<EmployeeDTO> getEmployeeBySkills(String skills){
        List<EmployeeDTO> listDto =  new ArrayList<>();
        List<Employee> employeeList=employeeService.findBySkills(skills);
        for (Employee employee : employeeList) {
            EmployeeDTO employeeDTO = convertEntityToemployeeDTO(employee);

            listDto.add(employeeDTO);
        }
        return listDto;
    }

    @PostMapping("/employee")
    public void newEmployee(@RequestBody EmployeeDTO employee){
        Employee newEmployee = convertEmployeeDTOToEntity(employee);
        employeeService.save(newEmployee);
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(Long id) {
        employeeService.delete(id);
    }

    @PutMapping("/employee/id")
    public EmployeeDTO update(@RequestBody EmployeeDTO employeeDTO){
        Employee employee=convertEmployeeDTOToEntity(employeeDTO);
        Employee  newEmployee=employeeService.getUpdate(employee);

        return convertEntityToemployeeDTO(newEmployee);
    }

    private static EmployeeDTO convertEntityToemployeeDTO(Employee employee){
        EmployeeDTO employeeDTO= new EmployeeDTO();
        BeanUtils.copyProperties(employee, employeeDTO);
        return employeeDTO;
    }

    private static Employee convertEmployeeDTOToEntity(EmployeeDTO employeeDTO){
        Employee employee= new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        return employee;
    }
}

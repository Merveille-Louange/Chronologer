package com.udacity.chronologer.web;


import com.udacity.chronologer.DTO.EmployeeDTO;
import com.udacity.chronologer.entity.Employee;
import com.udacity.chronologer.service.EmployeeService;


import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @ApiOperation(value = "Get list of employees in the System ", response = Iterable.class, tags = "getEmployee")

    @RequestMapping(value = "employee/{id}", method = RequestMethod.GET)
    public EmployeeDTO getEmployeeDTO(@PathVariable("id") Long id){
        Employee employee = employeeService.getEmployee(id).get();


            return convertEntityToEmployeeDTO(employee);



    }
    @ApiOperation(value = "Get All Employees ", response = Employee.class, tags = "getEmployees")

    @GetMapping("/employee")
    public List<EmployeeDTO> getAllEmployeeDTO(){
        List<EmployeeDTO> listDto =  new ArrayList<>();
        List<Employee> employeeList = employeeService.getAllEmployee();
        for (Employee employee : employeeList) {
            EmployeeDTO employeeDTO = convertEntityToEmployeeDTO(employee);

            listDto.add(employeeDTO);
        }
        return listDto;
    }

    @RequestMapping(method = RequestMethod.GET)
    public EmployeeDTO getEmployeeByName(@RequestParam(value = "name") String name){
        Employee employee=employeeService.findByName(name);
        return convertEntityToEmployeeDTO(employee);
    }
//    @RequestMapping(method = RequestMethod.GET)
//    public List<EmployeeDTO> getEmployeesSkills(@RequestParam(value = "skills") String skills){
//        List<EmployeeDTO> listDto =  new ArrayList<>();
//        List<Employee> employeeList=employeeService.findBySkills(skills);
//        for (Employee employee : employeeList) {
//            EmployeeDTO employeeDTO = convertEntityToEmployeeDTO(employee);
//
//            listDto.add(employeeDTO);
//        }
//        return listDto;
//    }

    @PostMapping("/employee")
    public void newEmployee(@RequestBody EmployeeDTO employee){
        Employee newEmployee = convertEmployeeDTOToEntity(employee);
        employeeService.save(newEmployee);
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable("id") Long id) {
        employeeService.delete(id);
    }

    @PutMapping("/employee/{id}")
    public EmployeeDTO update(@RequestBody EmployeeDTO employeeDTO){
        Employee employee=convertEmployeeDTOToEntity(employeeDTO);
        Employee  newEmployee=employeeService.getUpdate(employee);

        return convertEntityToEmployeeDTO(newEmployee);
    }

    private static EmployeeDTO convertEntityToEmployeeDTO(Employee employee){
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

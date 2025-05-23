package com.SpringBoot.CrudDemoRestAPI.Rest;

import com.SpringBoot.CrudDemoRestAPI.entity.Employee;
import com.SpringBoot.CrudDemoRestAPI.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController{

    private EmployeeService employeeService;
    private ObjectMapper objectMapper;

    //inject Employee DAO
    public EmployeeRestController(EmployeeService theEmployeeService, ObjectMapper theObjectMapper){
        this.employeeService = theEmployeeService;
        this.objectMapper = theObjectMapper;
    }

    //Expose "/Employee" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    // Adding the Mapping for Get / employee/{employeeId}
   @GetMapping("/employees/{employeeId}")
   public Employee getEmployee(@PathVariable int employeeId){

         Employee theEmployee = employeeService.findById(employeeId);
         if(theEmployee == null){
             throw new RuntimeException("Employee id is not found : "+ employeeId);
         }
         return theEmployee;
   }

    //add Mapping For Post /Employees - Add new Employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){

        // also just in case they pass an id in json .... set id to 0
        // this is to force a save of new item ..... instead of update
        theEmployee.setId(null);

        Employee newEmployee = employeeService.save(theEmployee);

        return newEmployee;
    }

    // Add mapping for Patch /employees/{employeeId} - partial Update
    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId,
    @RequestBody Map<String, Object> patchPayLoad,Employee theEmployee){

        Employee tempEmployee = employeeService.findById(employeeId);

        // Throw Exception
        if(tempEmployee == null){
            throw new RuntimeException("Employee id is not found : "+ employeeId);
        }

        // throw excepti
        if(patchPayLoad.containsKey("id")){
            throw new RuntimeException("Employee ID is not alllowed ib the Json Response body");
        }

        Employee patchEmployee = apply(patchPayLoad, tempEmployee);
        Employee dbEmployee = employeeService.save(patchEmployee);

        return dbEmployee;
    }

    private Employee apply(Map <String, Object> patchPayLoad, Employee tempEmployee){

    // Convert Employee object to a JSON Object Node
    ObjectNode employeeNode = objectMapper.convertValue(tempEmployee, ObjectNode.class);

    // Convert the patchPayLoad map to a JSON Object Node
    ObjectNode patchNode = objectMapper.convertValue(patchPayLoad, ObjectNode.class);

    // Merge the patch update into the employee node
    employeeNode.setAll(patchNode);

    return objectMapper.convertValue(employeeNode, Employee.class);
    }

    // Add mapping for delete /employee/{employeeId} - delete Employee
    @DeleteMapping("employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId ){

        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee == null){
            throw new RuntimeException("The Employee is not found to delete"+ employeeId);
        }

        employeeService.removeById(employeeId);

        return "Employee deleted : "+ employeeId;
    }
}

package com.aniket.Employee.Management.App.work;

import com.aniket.Employee.Management.App.db.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class RequestController {
    EmployeeRepository repository;

    @Autowired
    public void setRepository(EmployeeRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("add")
    public String addEmployee(Employee employee) { //here use @ModelAttribute behind the senses
        Integer rowsAffected = repository.save(employee);
        //rowsAffected is less than 0, means employee info not added in the database
        if (rowsAffected.equals(0)) {
            return "createFailed";
        }
        //rowsAffected is greater than 0, means employee info added in the database
        return "createSuccess";
    }

    @RequestMapping("view")
    public String viewEmployee(Integer empId, Model model) {
        List<Employee> isExist = repository.display(empId, model);

        if (isExist.isEmpty()) {
            //this empId is not exist
            return "employeeNotExist";
        }
        //this empId is existed
        return "employeeExists";
    }

    @RequestMapping("update")
    public String updateEmployee(Employee employee) {
        Integer rowsAffected = repository.update(employee);

        System.out.println(rowsAffected);

        //rowsAffected is less than 0, means employee info not updated in the database
        if (rowsAffected.equals(0)) {
            return "updateFailed";
        }
        //rowsAffected is greater than 0, means employee info updated in the database
        return "updateSuccess";
    }

    @RequestMapping("delete")
    public String deleteEmployee(Integer empId) {
        Integer rowsAffected = repository.delete(empId);

        System.out.println(rowsAffected);

        //rowsAffected is less than 0, means employee info not deleted in the database
        if (rowsAffected.equals(0)) {
            return "deleteFailed";
        }
        //rowsAffected is greater than 0, means employee info deleted in the database
        return "deleteSuccess";
    }
}

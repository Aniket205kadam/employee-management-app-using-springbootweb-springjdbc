package com.aniket.Employee.Management.App.db;

import com.aniket.Employee.Management.App.work.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeRepository {

    private JdbcTemplate template;
    private Employee employee;

    @Autowired
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public Integer save(Employee employee) {
        String sql = "INSERT INTO employees (empId, name, department, salary)" +
                "VALUES (?, ?, ?, ?)";

        return template.update(sql, employee.getEmpId(),
                employee.getName(),
                employee.getDepartment(),
                employee.getSalary());
    }

    public List<Employee> display(Integer empId, Model model) {
        String sql = "SELECT * FROM employees WHERE empId = ?";

        RowMapper<Employee> mapper = new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                employee.setEmpId(rs.getInt("empId"));
                employee.setName(rs.getString("name"));
                employee.setDepartment(rs.getString("department"));
                employee.setSalary(rs.getDouble("salary"));
                return null;
            }
        };

        List<Employee> listOfEmp = template.query(sql, new Object[]{empId}, mapper);

        model.addAttribute("empId", employee.getEmpId());
        model.addAttribute("name", employee.getName());
        model.addAttribute("department", employee.getDepartment());
        model.addAttribute("salary", employee.getSalary());

        return listOfEmp;
    }

    public Integer update(Employee employee) {
        String sql = "UPDATE employees" +
                " SET name = ?, department = ?, salary = ?" +
                " WHERE empId = ?";
        return template.update(sql, employee.getName(),
                employee.getDepartment(),
                employee.getSalary(),
                employee.getEmpId());
    }

    public Integer delete(Integer empId) {
        String sql = "DELETE FROM employees" +
                " WHERE empId = ?";
        return template.update(sql, empId);
    }
}

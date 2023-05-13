package ru.AndMosc.springSecurity.service;

import ru.AndMosc.springSecurity.entity.Employee;

import java.util.List;

public interface EmployeeServices {
    List<Employee> listAllEmployee();
    void saveEmployee(Employee employee);

    void delEmployee(Long id);

    Employee getEmployeeById(Long id);

    List<Employee> getEmployeeByIdDepartment(Long id);
}

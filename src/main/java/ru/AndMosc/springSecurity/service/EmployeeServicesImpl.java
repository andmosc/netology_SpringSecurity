package ru.AndMosc.springSecurity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.AndMosc.springSecurity.entity.Employee;
import ru.AndMosc.springSecurity.repository.EmployeeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServicesImpl implements EmployeeServices {

    private final EmployeeRepository employeeDto;
    @Override
    public void saveEmployee(Employee employee) {
        employeeDto.save(employee);
    }

    @Override
    public void delEmployee(Long id) {
        employeeDto.deleteById(id);
    }

    @Override
    public List<Employee> listAllEmployee() {
        return employeeDto.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeDto.findById(id).orElse(new Employee());

    }

    @Override
    public List<Employee> getEmployeeByIdDepartment(Long id) {
        return employeeDto.getEmployeesByDepartmentId(id);
    }
}

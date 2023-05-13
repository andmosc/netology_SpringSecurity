package ru.AndMosc.springSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.AndMosc.springSecurity.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> getEmployeesByDepartmentId(Long id);
}

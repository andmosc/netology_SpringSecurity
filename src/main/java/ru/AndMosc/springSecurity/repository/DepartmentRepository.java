package ru.AndMosc.springSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.AndMosc.springSecurity.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}

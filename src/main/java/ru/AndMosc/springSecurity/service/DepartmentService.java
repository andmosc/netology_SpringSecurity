package ru.AndMosc.springSecurity.service;

import liquibase.pro.packaged.S;
import ru.AndMosc.springSecurity.entity.Department;
import ru.AndMosc.springSecurity.entity.Employee;

import java.util.Map;

public interface DepartmentService {
    Map<Long, String> listAllDepartments();
}

package ru.AndMosc.springSecurity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.AndMosc.springSecurity.entity.Employee;
import ru.AndMosc.springSecurity.repository.DepartmentRepository;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentDto;

    public Map<Long,String> listAllDepartments() {
        Map<Long,String> listDepartment = new HashMap<>();
        departmentDto.findAll().forEach(item -> listDepartment.put(item.getId(),item.getName()));
        return listDepartment;
    }
}

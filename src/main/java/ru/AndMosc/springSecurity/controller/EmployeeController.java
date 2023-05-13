package ru.AndMosc.springSecurity.controller;

import java.util.List;
import java.util.Map;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.AndMosc.springSecurity.entity.Department;
import ru.AndMosc.springSecurity.entity.Employee;
import ru.AndMosc.springSecurity.service.DepartmentService;
import ru.AndMosc.springSecurity.service.EmployeeServices;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final DepartmentService departmenService;
    private final EmployeeServices employeeServices;

    @GetMapping("/administration")
    public String administration(Model model) {
        List<Employee> employees = employeeServices.listAllEmployee();
        model.addAttribute("empl", employeeServices.listAllEmployee());
        return "administration";
    }

    @GetMapping("/addNewEmployee")
    public String addNewEmpl(Model model) {
        model.addAttribute("listDepartments", departmenService.listAllDepartments());
        model.addAttribute("employee", new Employee());
        return "admin/employee-info";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee empl) {
        employeeServices.saveEmployee(empl);
        return "redirect:/administration";
    }

    @GetMapping("/address-book")
    public String addressBook(Model model) {
        model.addAttribute("listDepartments", departmenService.listAllDepartments());
        return "address-book";
    }

    @GetMapping("/updateEmployee")
    public String updateEmployee(@RequestParam("empId") Long id, Model model) {
        model.addAttribute("listDepartments", departmenService.listAllDepartments());
        model.addAttribute("employee", employeeServices.getEmployeeById(id));
        return "admin/employee-info";
    }

    @GetMapping("/delEmployee")
    public String delEmployee(@RequestParam("empId") Long id) {
        employeeServices.delEmployee(id);
        return "redirect:/administration";
    }

    @GetMapping("/listEmployee")
    public String listEmployee(@RequestParam("id") Long id, Model model) {
        List<Employee> employeeByIdDepartment = employeeServices.getEmployeeByIdDepartment(id);
        model.addAttribute("employee", employeeServices.getEmployeeByIdDepartment(id));
        return "user/listEmployee";
    }
}

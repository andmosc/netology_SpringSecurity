package ru.AndMosc.springSecurity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.AndMosc.springSecurity.entity.Employee;
import ru.AndMosc.springSecurity.service.DepartmentService;
import ru.AndMosc.springSecurity.service.EmployeeServices;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final DepartmentService departmenService;
    private final EmployeeServices employeeServices;

    @GetMapping("/administration")
    @Secured("ROLE_ADMIN")
    public String administration(Model model) {
        List<Employee> employees = employeeServices.listAllEmployee();
        model.addAttribute("empl", employeeServices.listAllEmployee());
        return "administration";
    }

    @GetMapping("/addNewEmployee")
    @RolesAllowed("ROLE_ADMIN")
    public String addNewEmpl(Model model) {
        model.addAttribute("listDepartments", departmenService.listAllDepartments());
        model.addAttribute("employee", new Employee());
        return "admin/employee-info";
    }

    @PostMapping("/saveEmployee")
    @Secured("ROLE_ADMIN")
    public String saveEmployee(@ModelAttribute("employee") Employee empl) {
        employeeServices.saveEmployee(empl);
        return "redirect:/administration";
    }

    @GetMapping("/address-book")
    @Secured({"ROLE_ADMIN","ROLE_USER"})
    public String addressBook(Model model) {
        model.addAttribute("listDepartments", departmenService.listAllDepartments());
        return "address-book";
    }

    @GetMapping("/updateEmployee")
    @Secured({"ROLE_ADMIN","ROLE_USER"})
    public String updateEmployee(@RequestParam("empId") Long id, Model model) {
        model.addAttribute("listDepartments", departmenService.listAllDepartments());
        model.addAttribute("employee", employeeServices.getEmployeeById(id));
        return "admin/employee-info";
    }

    @GetMapping("/delEmployee")
    @PreAuthorize("hasRole('ROLE_ADMIN') and hasRole('ROLE_DELETE')")
    public String delEmployee(@RequestParam("empId") Long id) {
        employeeServices.delEmployee(id);
        return "redirect:/administration";
    }

    @GetMapping("/listEmployee")
    @Secured({"ROLE_ADMIN","ROLE_USER"})
    public String listEmployee(@RequestParam("id") Long id, Model model) {
        List<Employee> employeeByIdDepartment = employeeServices.getEmployeeByIdDepartment(id);
        model.addAttribute("employee", employeeServices.getEmployeeByIdDepartment(id));
        return "user/listEmployee";
    }

    @GetMapping("/auth")
    @PostAuthorize("#userName == authentication.principal.username")
    public String auth(@RequestParam(name = "username") String userName, Model model) {
        model.addAttribute("username",userName);
        return "infoAuthentication";
    }
}

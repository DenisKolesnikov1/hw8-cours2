package Controller;

import Service.Employee;
import Service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import static java.lang.String.format;
@RestController
@RequestMapping
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String add(@RequestParam String firstName, @RequestParam String lastName) {
        Employee result = employeeService.add(firstName, lastName);
        return generateMessage(result);
    }

    @GetMapping("/remove")
    public String remove(@RequestParam String firstName, @RequestParam String lastName) {
        boolean result = employeeService.delete(firstName, lastName);
        return generateMessage(new Employee(firstName, lastName));
    }

    private String generateMessage(Employee result) {
        return null;
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.find(firstName, lastName);
    }

    @GetMapping
    public Collection<Employee> findAll() {
        return employeeService.findAll();
    }

    private String generateMessage(Employee employee, String status) {
        return format("Сотрудник %s: %s",
                employee.getFirstName(),
                employee.getLastName(),
                status
        );
    }
}

package Service;

import exception.ArrayIsFullException;
import exception.EmployeeAlreadyAddedException;
import exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceMapImpl implements EmployeeService {

    private static final int COUNT_EMPLOYEE = 3;
    private final Map<String, Employee> employees = new HashMap<>(COUNT_EMPLOYEE);


    @Override
    public Employee add(String firstName, String lastName) {
        if (employees.size() >= COUNT_EMPLOYEE) {
            throw new ArrayIsFullException("ArrayIsFullException");
        }
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(firstName + lastName)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(firstName + lastName, employee);
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = employees.get(firstName + lastName);
        if (employee != null) {
            return employee;
        }
        throw new EmployeeNotFoundException("EmployeeNotFoundException");
    }

    @Override
    public boolean delete(String firstName, String lastName) {
        return false;
    }


    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
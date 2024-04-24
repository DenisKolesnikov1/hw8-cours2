package Service;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {
    Employee add(String firstName, String lastName);
    Employee find(String firstName, String lastName);
    boolean delete(String firstName, String lastName);
    Collection<Employee> findAll();
}

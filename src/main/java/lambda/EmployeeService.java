package lambda;

import java.util.List;

public class EmployeeService {

    public Employee findFirst(List<Employee> employees, Condition condition) {
        for (Employee employee: employees) {
            if (condition.test(employee)) {
                return employee;
            }
        }
        throw new IllegalArgumentException("no such name");
    }
}

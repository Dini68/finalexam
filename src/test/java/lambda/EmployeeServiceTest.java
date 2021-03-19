package lambda;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeServiceTest {
    @Test
    public void testFindFirst() {
        List<Employee> employees =
                Arrays.asList(
                        new Employee("John Doe"),
                        new Employee("Jane Doe"),
                        new Employee("Jack Doe")
                );
        Employee result = new EmployeeService().findFirst(employees,
                employee -> employee.getName().startsWith("Jane"));

        assertEquals("Jane Doe", result.getName());
    }


}
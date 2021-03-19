package streams;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReduceTest {

    List<Employee> employees = Arrays.asList(
            new Employee("John Doe"),
            new Employee("Jane Jane Doe"),
            new Employee("Joe Doe Doe"),
            new Employee("John John Smith")
    );
    @Test
    public void testReduce() {
        int length = employees.stream().reduce(
                0,
                (i, e) -> i + e.getName().length(),
                (i1, i2) -> i1 + i2
        );
        System.out.println(length);
        assertEquals(43, length);
    }
    @Test
    public void testNameCounter() {
        NameCounter nameCounter = employees.stream().reduce(
                new NameCounter(),
                (nc, e) -> nc.add(e),
                (nc1, nc2) -> nc1.add(nc2));
        assertEquals(3, nameCounter.getThreePartName());
        assertEquals(1, nameCounter.getTwoPartName());
    }


}

package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Employee {

    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Stream.empty(); // üres stream
        Stream st = Stream.of(1,2,3);
        System.out.println(Arrays.toString(st.toArray()));

        Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);

        Stream<String> s = Stream.of("monkey", "ape", "bonobo");
        Optional<String> max = s.max(Comparator.comparingInt(s2 -> s2.charAt(0)));
        max.ifPresent(System.out::println); // ape

        List<String> list = Arrays.asList("monkey", "2", "chimp");
        Stream<String> infinite = Stream.generate(() -> "chimp");
//        System.out.println(infinite.toArray().length);
        Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
        System.out.println(list.stream().anyMatch(pred)); // true
        System.out.println(list.stream().allMatch(pred)); // false
        System.out.println(list.stream().noneMatch(pred)); // false
        System.out.println(infinite.anyMatch(pred)); // true
     //   System.out.println(Arrays.toString(infinite.toArray()));

    }
}

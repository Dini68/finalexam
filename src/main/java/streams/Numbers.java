package streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Numbers {

    private List<Integer> numbers = new ArrayList<>();

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Optional<Integer> min() {
        return numbers.stream().min(Comparator.naturalOrder());
    }
    public Integer sum() {
        return numbers.stream().reduce(0, (a,b) -> a+b);
    }

    public static void main(String[] args) {
        Numbers numbers = new Numbers(List.of(48, 75, 26, 55));
        System.out.println(numbers.min());
        System.out.println(numbers.sum());
    }
}


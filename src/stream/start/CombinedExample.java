package stream.start;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class CombinedExample {
    public static void main(String[] args) {

        // Combined example
        Supplier<Integer> supplier = () -> 10;
        Consumer<Integer> consumer = (x) -> System.out.println("Consumed: "+x);
        Predicate<Integer> predicate = (x) -> x % 2 == 0;
        Function<Integer, Integer> function = (x) -> 10 * x;

        if (predicate.test(supplier.get())){
            consumer.accept(function.apply(supplier.get()));
        }
    }
}

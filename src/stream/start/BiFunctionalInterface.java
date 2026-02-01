package stream.start;

import java.util.function.*;

public class BiFunctionalInterface {
    public static void main(String[] args) {
        // BiConsumer : Something it will accept, and it'll not do anything
        BiConsumer<Integer, Integer> biConsumer = (x, y) -> System.out.println("I am x: " + x + ", y: " + y);
        biConsumer.accept(5, 3);

        // BiPredicate
        BiPredicate<Integer, Integer> biPredicate = (x, y) -> (x + y) % 2 == 0;
        System.out.println("I'm predicate ---->" + biPredicate.test(5, 7));

        // BiFunction
        BiFunction<String, String, Integer> biFunction = (x, y) -> x.concat(y).length();
        System.out.println("I'm function ---->" + biFunction.apply("Vikas", "Am"));

        // BinaryOperator : Extends the function interface only
        BinaryOperator<Integer> binaryOperator = (x, y) -> (x + y) * 2;
        System.out.println("I'm binaryOperator ----> " + binaryOperator.apply(4, 3));

        // UnaryOperator : Extends the function interface only
        UnaryOperator<Integer> unaryOperator = (x) -> x * x;
        System.out.println("I'm unaryOperator ----> " + unaryOperator.apply(3));
    }
}

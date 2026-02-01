package stream.stream;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Primitives {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        IntStream stream = Arrays.stream(arr);

        System.out.println(IntStream.range(1, 5).boxed().collect(Collectors.toList()));
        System.out.println(IntStream.rangeClosed(1, 5).boxed().collect(Collectors.toList()));

        // creating the new int stream
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5, 6);

        DoubleStream doubles = new Random().doubles(5);
        System.out.println("Creating random 5 doubles ---->"+doubles.boxed().toList());

        IntStream integers = new Random().ints(5);
        System.out.println("Creating random 5 integers ---->"+integers.filter(x -> x > 0).boxed().toList());

    }
}

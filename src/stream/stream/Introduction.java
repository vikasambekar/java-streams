package stream.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Introduction {
    public static void main(String[] args) {

        // What is Stream ?
        /*
        Stream is the java 8 feature
        1. Process Collection of data in a functional and declarative manner
        2. Simply data processing
        3. Embrace functional programming
        4. Improve readability and maintainability
        5. Enable easy parallelism


        Stream : A sequence of elements supporting the functional and declarative programming

        How to use the stream ?
        --> source, Intermediate operations, terminal operations
         */

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println("Even count---> " + numbers.stream().filter(x -> x % 2 == 0).count());

        // WAYS OF CREATING THE STREAMS
        // 1. Creating the stream using the collections
        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5, 6);
        Stream<Integer> streamUsingCollection = numList.stream();

        // 2. Creating the stream using the array
        int[] numArr = {1, 2, 3, 4, 5};
        IntStream streamUsingArr = Arrays.stream(numArr);

        // 3. Creating the stream using the stream.of()
        Stream<String> streamString1 = Stream.of("Vikas", "Rajendra", "Ambekar");
        Stream<int[]> streamString2 = Stream.ofNullable(numArr);

        // 4. Creating the infinite stream
        Stream.generate(() -> 10).limit(100);
        Stream.iterate(1, x -> x + 1);
    }
}

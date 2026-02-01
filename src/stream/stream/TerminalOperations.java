package stream.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TerminalOperations {
    /*
        TERMINAL OPERATIONS
        - Terminal operations are used to terminate the stream
        - Without terminal operations, intermediate operations are not processed
     */
    public static void main(String[] args) {

        // 1. collect
        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5);
        // skipping the first element
        List<Integer> collectList2 = numList.stream().skip(1).toList();
        System.out.println("collectList2 ---->" + collectList2);

        Set<Integer> collectList1 = numList.stream().skip(1).collect(Collectors.toSet());
        System.out.println("collectList1 ---->" + collectList1);


        // 2. forEach
        numList.stream().forEach(System.out::println);


        // 3. reduce : Combine elements to produce the result
        Optional<Integer> reduced = numList.stream().reduce((x, y) -> x * y);
        System.out.println("Reduced ---> " + reduced.get());

        // 4. count

        // 5. anyMatch, allMatch, noneMatch
        // anyMatch : Returns the true when any single condition matches
        boolean anyMatch = numList.stream().anyMatch(integer -> integer % 2 == 0);
        System.out.println("anyMatch -----> " + anyMatch);

        // allMatch : Returns the true when all condition matches
        boolean allMatch = numList.stream().allMatch(integer -> integer > 0);
        System.out.println("allMatch -----> " + allMatch);

        // noneMatch : Returns the true when no condition matches
        boolean noneMatch = numList.stream().noneMatch(integer -> integer < 0);
        System.out.println("noneMatch -----> " + noneMatch);

        // 6. findFirst, findAny
        System.out.println("Return the first element ---->" + numList.stream().findFirst());
        System.out.println("Return the any element ---->" + numList.stream().findAny());

        executeTheExamples();
    }

    public static void executeTheExamples() {
        List<String> stringList = List.of("Vikas", "Sham", "Suresh", "Bob", "Ann");
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Example 1: Returns the names whose length is greater than 3
        System.out.println("Example 1 ----> " + stringList.stream().filter(x -> x.length() > 3).toList());
        // Example 2: Return the double of elements
        System.out.println("Example 2 -----> " + list.stream().map(x -> x + x).toList());
        // Example 3: Return the double of elements
        System.out.println("Example 3 -----> " + list.stream().map(x -> x * x).sorted().toList());
        // Example 4: Return the sum of elements
        int sum1 = list.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Example 4.1 -----> " + sum1);

        Optional<Integer> sum2 = list.stream()
                .reduce((a, b) -> a + b);

        System.out.println("Example 4.2 -----> " + sum2);

        // Example 5: Counting the occurrences of characters
        String sentence = "Hello World";

        // This is used to create the stream  from the string
        IntStream charsStream = sentence.chars();
        System.out.println("Example 5 ----> "+charsStream.filter(x -> x == 'l').count());



    }
}

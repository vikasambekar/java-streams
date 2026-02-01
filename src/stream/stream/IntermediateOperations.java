package stream.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOperations {
    /*
        INTERMEDIATE OPERATIONS
        - Intermediate operations transforms the stream into another stream
        - They are lazy, meaning they don't execute until terminal operation is invoked
     */
    public static void main(String[] args) {
        // 1. FILTER
        List<String> strList = Arrays.asList("Vikas", "Vyom", "Vinay", "Vikas");
        Stream<String> newStream = strList.stream().filter(x -> x.startsWith("V"));
        System.out.println("Result ----->" + newStream);
        // here count is the terminal operator
        System.out.println("Count ---->" + newStream.count());

        // 2. MAP
        Stream<String> stringStream = strList.stream().map(String::toUpperCase);

        // 3. sorted
        Stream<String> sortedStream = strList.stream().sorted();
        System.out.println(sortedStream.toList());
        // sorting using the custom comparator
        Stream<String> customSorted = strList.stream().sorted((a, b) -> b.length() - a.length());
        System.out.println(customSorted.toList());

        // 4. distinct
        long count = strList.stream().filter(x -> x.startsWith("V") && x.endsWith("s")).distinct().count();
        System.out.println("The distinct count ---->" + count);

        // 5. limit
        long limitCount = Stream.iterate(1, x -> x + 1).limit(15).count();
        System.out.println("limitCount ----->" + limitCount);

        // 6. skip
        System.out.println("skipCount ----->" + Stream.iterate(1, x -> x + 1) // infinite stream
                .skip(5)                           // skips first 5 elements: 1..5
                .limit(100)                  // then takes next 100 elements
                .count()
        );

        // 7. peak : Perform action on each element as it is consumed
        Stream.iterate(1, x -> x+1).skip(10).limit(100).peek(System.out::println).count();

        // 8. flatmap : useful when each element is a collection itself, flatmap flattens the response
        // FOR BETTER UNDERSTANDING PLEASE CHECK THE EXAMPLE
        /*
                map → transforms elements
                A → B


                flatMap → transforms and flattens
                A → Stream<B> → B



         */
        List<List<String>> list = Arrays.asList(
                Arrays.asList("Vikas", "Rajendra", "Ambekar"),
                Arrays.asList("Vikas", "Rajendra", "Ambekar"),
                Arrays.asList("Vikas", "Rajendra", "Ambekar"),
                Arrays.asList("Vikas", "Rajendra", "Ambekar")
        );
        System.out.println("Flatmap example ---> "+list.stream()
                .flatMap(x -> x.stream())
                .map(x -> x.toUpperCase())
                .toList());

        List<String> result =
                list.stream()
                        .flatMap(inner -> inner.stream())
                        .filter(name -> name.length() > 6)
                        .toList();


        List<List<Integer>> numbers = List.of(
                List.of(1, 2),
                List.of(3, 4),
                List.of(5)
        );

        List<Integer> result1 =
                numbers.stream()
                        .flatMap(Collection::stream)
                        .toList();


    }
}

/*
    Notes :
    - Flatmap flattens the response
    - Example : [[1, 2], [3], [4, 5]]
                - flatMap(x -> x.stream())   ----------------> 1, 2, 3, 4, 5 (Flatten response, internally)
    - flatMap is required whenever one element produces many elements
 */

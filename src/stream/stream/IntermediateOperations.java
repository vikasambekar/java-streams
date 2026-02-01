package stream.stream;

import java.util.Arrays;
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
    }
}

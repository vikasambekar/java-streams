package stream.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CollectorsDemo {
    public static void main(String[] args) {
        // Collectors - Utility class

        // 1. Collecting to list
        List<String> strList = List.of("Vikas", "Vinay", "Ambekar", "Patil");
        System.out.println("Example 1 : " +
                strList.stream()
                        .filter(x -> x.startsWith("V"))
                        .collect(Collectors.toList())
        );


        // 2. Collecting to set
        List<Integer> numList = List.of(1, 1, 3, 4, 4, 5, 6, 6, 6, 7);
        System.out.printf("Example 2 : %s%n", numList.stream().collect(Collectors.toSet()));

        // 3. Collecting a specific collection
        ArrayList<String> collect = strList.stream().collect(Collectors.toCollection(() -> new ArrayList<>()));

        // 4. Summerizing
        IntSummaryStatistics intSummaryStatistics = numList.stream().collect(Collectors.summarizingInt(value -> value));
        System.out.println("intSummaryStatistics --->" + intSummaryStatistics);

        // 5. grouping elements
        List<String> words = Arrays.asList("Hello", "world", "java", "stream", "collections");
        // type 1: classifier
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length)));
        // type 2: classifier, downstream
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length, Collectors.joining(" , "))));
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length, Collectors.counting())));
        // type 3:
        TreeMap<Integer, Long> treeMap = words.stream().collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.counting()));
        System.out.println("Tree map ---->" + treeMap);
        System.out.println("Tree map ---->" + treeMap.lastKey());

        // 6. Partitioning : Returns two parts, even and odd
        Map<Boolean, List<Integer>> partitioning = numList.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0));
        System.out.println("Partitioning ---->" + partitioning);

        // 7. Map
        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry");
        Map<String, Integer> toMap = fruits.stream().collect(Collectors.toMap(x -> x.toUpperCase(), x -> x.length()));
        System.out.println("Map ---->" + toMap);

    }
}

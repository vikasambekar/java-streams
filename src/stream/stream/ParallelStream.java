package stream.stream;

import java.util.List;
import java.util.stream.Stream;

public class ParallelStream {
    public static void main(String[] args) {
        /*
            PARALLEL STREAM
            - A type of Stream that enables the parallel processing of the elements
            - Allowing the multiples threads to process the parts of the stream simultaneously
            - This can increase the performance of the large datasets
            - Workload is distributed across the multiple threads

         */
        long startTime = System.currentTimeMillis();
        List<Integer> list = Stream.iterate(1, x -> x + 1).limit(20000).toList();
        List<Long> factoList1 = list.stream().map(ParallelStream::factorial).toList();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken : " + (endTime - startTime) + " ms");


        startTime = System.currentTimeMillis();
        List<Long> factoList2 = list.parallelStream().map(ParallelStream::factorial).toList();
//        List<Long> factoList2 = list.parallelStream().map(ParallelStream::factorial).sequential().toList();
        endTime = System.currentTimeMillis();
        System.out.println("Time taken : " + (endTime - startTime) + " ms");

        /*
            PARALLEL STREAM
            - Parallel stream is effective for CPU intensive tasks or large data sets where task are independent
            - This may over head for simple task or small datasets
         */
    }

    private static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}

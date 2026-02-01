package stream.start.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class MyConsumer {
    public static void main(String[] args) {

        // Consumer : It will just accept something and will not return anything
        // Method is accept
        Consumer<String> consumer1 = (x) -> System.out.println("name-->" + x);
        consumer1.accept("Vikas");

        // 2. Array list example
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Consumer<List<Integer>> consumer2 = (arrayList) -> {
            for (int x : arrayList) {
                System.out.println("List items: " + x);
            }
        };
        consumer2.accept(list);

        // 3. .andThen() example
        Consumer<String> consumer3 = (x) -> System.out.println("Surname ---->"+x);

        Consumer<String> consumer4 = consumer1.andThen(consumer3);
        consumer4.accept("Vikas");
    }
}

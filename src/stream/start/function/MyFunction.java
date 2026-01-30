package stream.start.function;

import java.util.function.Function;

public class MyFunction {
    public static void main(String[] args) {

        /*
            Function : This is used to take some input and return something
            Function<T, R>
         */

        // 1. Function to duble it
        Function<Integer, Integer> func1 = (a) -> 2 * a;
        System.out.println(" func1 ---->" + func1.apply(2));

        // 2. Function to triple it
        Function<Integer, Integer> func2 = (a) -> 3 * a;
        System.out.println(" func2 ---->" + func2.apply(2));

        // 3. Function .andThen()
        // at first func1 it will execute then it will execute func2
        Function<Integer, Integer> func3 = func1.andThen(func2);
        System.out.println(" func3 ---->" + func3.apply(3));

        // 4. Function .compose()
        // at first func2 it will execute then it will execute func1
        Function<Integer, Integer> func4 = func1.compose(func2);
        System.out.println(" func4 ---->" + func4.apply(3));

        // 5. Function .identity
        Function<Integer, Integer> identity = Function.identity();
        System.out.println("Identity --->" + identity.apply(5));
    }
}

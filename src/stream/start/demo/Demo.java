package stream.start.demo;

public class Demo {
    public static void main(String[] args) {
        // lambda expressions
        Thread t1 = new Thread(() -> {
            System.out.println("I am executing runnable");
        });

        System.out.println("Info t1 --->" + t1);


        // functional way writing
        Thread t2 = new Thread(new Test());
        System.out.println("Info t2 --->" + t2);


        // Lambda expression
        // Interface reference is holding the lambda expression
        MathsOperations mathsOperations = (a, b) -> a + b;
        System.out.println("Sum ---->" + mathsOperations.operation(5, 4));
        MathsOperations mathsOperations1 = (a, b) -> a * b;
        System.out.println("Multiplication ----->" + mathsOperations1.operation(5, 4));
    }
}


class Test implements Runnable {
    @Override
    public void run() {
        System.out.println("I am executing runnable");
    }
}

// To use the operation method for ADD, MULTIPLY and for other operation we need to implement this separately
// But using the lambda expression it is quite easy
@FunctionalInterface
interface MathsOperations {
    int operation(int a, int b);
}

/*
    Lambda expressions
    1. It is applicable only for the functional interface
    2. Functional Interface holds only single abstract method

 */

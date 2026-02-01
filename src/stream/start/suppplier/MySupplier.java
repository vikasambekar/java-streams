package stream.start.suppplier;

import java.util.function.Supplier;

public class MySupplier {
    public static void main(String[] args) {
        // Supplier : It doesn't take anything, it only returns something
        Supplier<String> supply = () -> "Hello I'm supplier";
        System.out.println("Supplier : " + supply.get());
    }
}

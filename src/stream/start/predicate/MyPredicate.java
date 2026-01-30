package stream.start.predicate;

import java.util.function.Predicate;

public class MyPredicate {
    public static void main(String[] args) {
        // 1. Takes any type and return the boolean value
        // Predicate is holding the single condition
        Predicate<Integer> isEven = (a) -> a % 2 == 0;
        System.out.println("Ans 1 ---->" + isEven.test(4));


        // 2. AND, OR, EQUAL and other operations
        Predicate<String> isWordStartsWithA = x -> x.toUpperCase().startsWith("A");
        Predicate<String> isWordEndWithR = x -> x.endsWith("r");
        Predicate<String> ans = isWordStartsWithA.and(isWordEndWithR);
        System.out.println("Ans 2 ---->"+ans.test("Ambekar"));

        // 3. Check the methods
        Predicate<String> isEmpty = String::isEmpty;
        System.out.println("Ans 3 ---->"+isEmpty.test("null"));

        // 4.
    }
}

/*
   NOTES:
   1. In the functional interface there is only single abstract method
   2. Functional interface can hold multiple static and default methods
   3. Table
    | Method   | Meaning                                                  |
    | -------- | -------------------------------------------------------- |
    | `and`    | `p1.and(p2)` → true if **both** predicates are true      |
    | `or`     | `p1.or(p2)` → true if **at least one** predicate is true |
    | `negate` | `p.negate()` → logical NOT of predicate                  |
   4.

 */

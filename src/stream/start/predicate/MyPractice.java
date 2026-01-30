package stream.start.predicate;

import java.util.function.Predicate;

public class MyPractice {
    public static void main(String[] args) {
        // Q1. Write a predicate to check if a string contains only digits.
        // regex -> '\\d' to check it only contains the digits
        Predicate<String> ans1 = x -> x.matches("\\d+");
        System.out.println("Ans 1 -----> " + ans1.test("34343434"));

        // Q2. Write a predicate to check if a number is a perfect square.
        Predicate<Integer> ans2 = x -> {
            int root = (int) Math.sqrt(x);
            return root * root == x;
        };
        System.out.println("Ans 2 -----> " + ans2.test(16));

        // Q3. Given a list of objects Person{name, age}, create a predicate to filter all adults (age >= 18) whose name starts with "A".
        Person person1 = new Person("Alias", 25);
        Predicate<Person> ans3 = x -> x.age >= 18 && x.name.startsWith("A");
        System.out.println("Ans 3 ---->" + ans3.test(person1));

        // Q4. .and
        Predicate<Integer> minimumAge = (a) -> a > 18;
        Predicate<Integer> maximumAge = (a) -> a < 60;
        Predicate<Integer> andPredicate = minimumAge.and(maximumAge);
        System.out.println("And predicate ---->"+andPredicate.test(57));

        // Q5. .or
        Predicate<Integer> minimumAge1 = (a) -> a > 18;
        Predicate<Integer> maximumAge2 = (a) -> a < 60;
        Predicate<Integer> orPredicate = minimumAge1.or(maximumAge2);
        System.out.println("OR predicate ---->"+orPredicate.test(17));

        // Q6. .negate
        Predicate<String> isEmptyOrNull = (x) -> x == null || x.isBlank();
        // Flips the test method
        Predicate<String> isValid = isEmptyOrNull.negate();
        System.out.println("Is '' valid? " + isValid.test(""));       // false
        System.out.println("Is null valid? " + isValid.test(null));   // false
        System.out.println("Is 'Hello' valid? " + isValid.test("Hello")); // true
    }
}

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
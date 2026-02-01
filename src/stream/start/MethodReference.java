package stream.start;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReference {
    public static void main(String[] args) {

        // Method reference :
        // 1. Use the method without invoking
        // 2. Always replaces in place of lambda expressions
        List<String> studentList = Arrays.asList("Vikas", "Shubham", "Vivek");
//        studentList.forEach(x -> System.out.println(x));
        studentList.forEach(System.out::println);


        // Constructor reference
        List<String> list = Arrays.asList("A", "B", "C");
        List<MobilePhone> newList = list.stream().map(MobilePhone::new).collect(Collectors.toList());
        System.out.println("New list ----> "+newList);
    }
}

class MobilePhone {
    String name;

    MobilePhone(String name) {
        this.name = name;
    }
}

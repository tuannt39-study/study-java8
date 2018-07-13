package vn.its;

import java.util.ArrayList;
import java.util.List;

public class Java8_03_MethodReferences {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java 7");
        list.add("Java 8");
        list.add("Java 9");
        list.add("Java 10");
        list.forEach(System.out::println);
    }
}

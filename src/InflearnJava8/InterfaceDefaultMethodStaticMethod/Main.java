package InflearnJava8.InterfaceDefaultMethodStaticMethod;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Foo foo = new DefaultFoo("Jungmin");
        foo.printName();
        foo.printNameUpperCase();

        Foo.printAnything();

        System.out.println();
        List<String> name = new ArrayList<>();
        name.add("keesun");
        name.add("whiteship");
        name.add("toby");
        name.add("foo");

        name.forEach(System.out::println);

        System.out.println("Spliterator");
        Spliterator<String> spliterator = name.spliterator();
        Spliterator<String> stringSpliterator = spliterator.trySplit();
        while (spliterator.tryAdvance(System.out::println)) ;
        System.out.println("---------------------");
        while (stringSpliterator.tryAdvance(System.out::println)) ;

        System.out.println("Stream");
        Set<String> k = name.stream().map(String::toUpperCase)
                .filter(s -> s.startsWith("K"))
                .collect(Collectors.toSet());
        System.out.println(k.toString());

        System.out.println("==== remove if ====");
        name.removeIf(s -> s.startsWith("k"));
        name.forEach(System.out::println);

        System.out.println("--- sort ---");
        name.sort(String::compareToIgnoreCase);
        name.forEach(System.out::println);
        System.out.println("--- reverse ---");
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        name.sort(compareToIgnoreCase.reversed());
        name.forEach(System.out::println);
    }
}

package InflearnJava8.FunctionalInterfaceAndLambdaIntroduce;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MethodReference {
    public static void main(String[] args) {

        // Static method reference
        System.out.println("static method reference");

        Function<Integer, String> intToString = (i) -> "number";

        UnaryOperator<String> hi = (s) -> "hi " + s;
        UnaryOperator<String> hi2 = Greeting::hi;

        System.out.println(hi.apply("Jungmin"));
        System.out.println(hi2.apply("JJJ"));

        // Instance method refernce (특정 객체)
        System.out.println("Instance Method reference");
        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;
        System.out.println(hello.apply("Jungmin"));

        // 생성자 참조
        // 입력값은 없고 반환값만 있는 경우 (아래에서 반환은 Greeting)
        System.out.println("생성자 참조");
        Supplier<Greeting> newGreeting = Greeting::new;
        newGreeting.get();

        Function<String, Greeting> keesunGreeting
                = Greeting::new;
        Greeting jungmin = keesunGreeting.apply("Jingmin");
        System.out.println(jungmin.getName());
        Supplier<Greeting> keesunGreeting2 = Greeting::new;

        // 임의 객체의 메소드 인스턴스 참조
        String[] names = {"keesun", "whiteship", "toby"};
        // Arrays.sort(names, new Comparator<String>() {
        //
        //     @Override
        //     public int compare(String o1, String o2) {
        //         return o1.length() - o2.length();
        //     }
        // });
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));
    }
}

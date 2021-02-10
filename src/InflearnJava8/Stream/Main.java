package InflearnJava8.Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("keesun");
        names.add("whiteship");
        names.add("toby");
        names.add("foo");

        // 중개 stream: return stream
        // 종료 stream: return stream x
        Stream<String> stringStream = names.stream().map(String::toUpperCase);

        names.forEach(System.out::println);

        System.out.println("============================");
        // 중개형 operator 만으로는 실행이 안된다.(오직 정의만 한것일뿐)
        names.stream().map((s) -> {
            System.out.println(s);
            return s.toUpperCase();
        });

        // 종료형 operator 가 있어야 중개형에 정의한것도 실행한다.
        System.out.println("========== terminal operator 추가 ==============");
        List<String> collect = names.stream().map((s) -> {
            System.out.println(s);
            return s.toUpperCase();
        }).collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println("============== 원본 데이터 ==============");
        // stream에서 수행한 작업이 원본 데이터에는 영향을 주지 않는다.
        names.forEach(System.out::println);
    }
}

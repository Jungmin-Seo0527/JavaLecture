package InflearnJava8.FunctionalInterfaceAndLambdaIntroduce;

import java.util.function.*;

public class Foo {
    public static void main(String[] args) {
        int baseNumber = 2;
        // 익명 내부 클래스 anonymous inner class
        RunSomething runSomething = (i) -> {
            // 함수 외부의 변수를 참조는 할수 있지만 변경은 불가능
            // baseNumber++; // 불가능

            int baseNum = 10;
            return i * baseNumber;
        };

        // baseNumber++; // 불가능
        /*
            Functional method 선언시 함수 밖의 변수를 참조했다면
            그 변수는 final로 설정되어 변수 수정이 불가능 하다.
            (단 파라미터로 전달받지 않는 변수에 한함)

            또한 함수 내부에서 선언된 변수는 함수 밖에서 접근이 불가
         */
        // baseNum++; // 불가

        System.out.println(runSomething.doit(1));
        System.out.println(runSomething.doit(1));
        System.out.println(runSomething.doit(1));
        System.out.println(runSomething.doit(2));
        System.out.println(runSomething.doit(2));
        System.out.println(runSomething.doit(3));

        // 2. 자바에서 제공하는 함수형 인터페이스
        System.out.println("자바에서 제공하는 함수형 인터페이스");
        System.out.println("Function");
        Plus10 plus10 = new Plus10();
        System.out.println(plus10.apply(100));

        Function<Integer, Integer> plus11 = (num) -> num + 11;
        System.out.println(plus11.apply(10));

        Function<Integer, Integer> multiply2 = (i) -> i * 2;
        System.out.println(multiply2.apply(1));

        // 입력값을 가지고 파라미터 함수 수행후 함수 수행 (multiply2 -> plus10);
        System.out.println("compose");
        Function<Integer, Integer> mutiply2AndPlus10 = plus10.compose(multiply2);
        System.out.println(mutiply2AndPlus10.apply(2)); // 2 * 2 + 10 = 14

        // andThen: compose 와 반대
        // plus10 -> multiply2
        System.out.println("andThen");
        Function<Integer, Integer> plus10AndMultiply2 = plus10.andThen(multiply2);
        System.out.println(plus10AndMultiply2.apply(2));

        // consumer: void (반환값이 없음)
        System.out.println("consumer");
        Consumer<Integer> printT = (i) -> System.out.println(i);
        printT.accept(10);

        // Supplier: 입력값이 없이 반환
        System.out.println("Supplier");
        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10);

        // Predicate: 입력값을 받아서 boolean 을 return
        System.out.println("Predicate");
        Predicate<String> startsWithKeesun = (s) -> s.startsWith("keesun");
        Predicate<Integer> isEven = (i) -> i % 2 == 0;
        System.out.println("keesum: " + startsWithKeesun.test("keesum"));
        System.out.println("keesun: " + startsWithKeesun.test("keesun"));

        System.out.println("2: " + isEven.test(2));
        System.out.println("3: " + isEven.test(3));

        // UnaryOperator: Function<Integer, Integer> 에서 입력값과 반환값이 모두 Integer 즉 동일한 경우 사용
        System.out.println("UnaryOperator");
        UnaryOperator<Integer> plus20 = (i) -> i + 20;
        Integer resultPlus20 = plus20.apply(10);
        System.out.println(resultPlus20);

    }
}

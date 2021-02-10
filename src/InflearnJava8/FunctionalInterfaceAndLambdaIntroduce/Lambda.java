package InflearnJava8.FunctionalInterfaceAndLambdaIntroduce;

import java.util.function.*;

public class Lambda {
    public static void main(String[] args) {
        Supplier<Integer> get10 = () -> 10;
        BiFunction<Integer, Integer, Integer> get11 = Integer::sum;
        BinaryOperator<Integer> sum = (a, b) -> a + b;

        // 변수 캡쳐
        Lambda lambda = new Lambda();
        lambda.run();
    }

    private void run() {
        final int baseNumber = 10; // Java8 부터 final이 생각가능한 경우가 존재

        // local class
        class LocalClass {
            int baseNumber = 11;

            void printBaseNumber() {
                System.out.println("local class");
                System.out.println(baseNumber); // 11
                // 로컬 클래스의 baseNumber 변수가 run의 변수 baseNumber를 가려버림
            }
        }
        LocalClass lc = new LocalClass();
        lc.printBaseNumber();

        // 익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) {
                System.out.println(baseNumber);
            }
        };

        // 람다: 같은 scope (같은 scope안에 같은 이름의 변수를 선언할 수 없다)
        IntConsumer printInt = (i) -> {
            System.out.println(i + baseNumber); // baseNumber -> final (effective final)
        };
        printInt.accept(10);

        // baseNumber++;
        // Cannot assign a value to final variable 'baseNumber'
        // 람다식으로 인해 baseNumber 는 final 이 기정사실화 되었는데 (effective final) 갑자기 baseNumber를 수정하려 하면
        // 컴파일러가 잡아냄
    }
}

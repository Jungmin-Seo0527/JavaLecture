package InflearnJava8.FunctionalInterfaceAndLambdaIntroduce;

// Funtional Interface : 추상 method를 하나만 가지고 있는 Interface
// SAM(Single Abstract Method)
// static, default method 는 상관없음
@FunctionalInterface
public interface RunSomething {

    int doit(int number);

    static void printName() {
        System.out.println("Keesum");
    }

    default void printAge() {
        System.out.println("40");
    }
}

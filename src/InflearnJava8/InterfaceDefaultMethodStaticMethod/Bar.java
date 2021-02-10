package InflearnJava8.InterfaceDefaultMethodStaticMethod;

public interface Bar extends Foo {

    // Foo 에서 default method였지만 Bar 구현체에서 다시 구현해야함
    // 생략하면 default method 그대로 사용함
    void printNameUpperCase();

    // 만일 각각의 인테페이스(서로 관계 없음)에서 동일한 default 추상 메소드가 존재하고
    // 어떤 객체가 두 인터페이스를 implements 하여 구현할때
    // 동일한 이름의 default method가 충돌이 일어나므로
    // override 해주어야 함

}

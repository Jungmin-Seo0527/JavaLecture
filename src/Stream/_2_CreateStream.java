/*
    스트림의 생성
    --------------------------------------------------------------------------------------------------------------------
    * 스트림의 생성
    스트림 API는 다음과 같은 다양한 데이터 소스에서 생성할 수 있다.
    1) 컬렉션
    2) 배열
    3) 가변 매개변수
    4) 지정된 범위의 연속된 정수
    5) 특정 타입의 난수들
    6) 람다 표현식
    7) 파일
    8) 빈 스트림

    --------------------------------------------------------------------------------------------------------------------
    1. 컬렉션

    자바에서 제공하는 모든 컬렉션의 최고 상위 조상인 Collection 인터페이스에는 stream() 메소드가 정의되어 있다.
    따라서 Collection 인터페이스를 구현한 모든 List와 Set 컬렉션 클래스에서도 stream() 메소드로 스트림을 생성할 수 있다.
    또한, parallelStream() 메소드를 사용하면 병렬 처리가 가능한 스트림을 생성할 수 있다.
    --------------------------------------------------------------------------------------------------------------------
    2. 배열

    배열에 관한 스트림을 생성하기 위해 Arrays 클래스에는 다양한 형태의 stream() 메소드가 클래스 메소드로 정의되어 있다.
    또한, 기본 타입인 int, long, double 형을 저장할 수 있는 배열에 관한 스트림이 별도로 정의되어 있다.
    이러한 스트림은 java.util.stream 패키지의 IntStream, LongStream, DoubleStream 인터페이스로 각각 제공된다.
    --------------------------------------------------------------------------------------------------------------------
    3. 가변 매개변수

    Stream 클래스의 of()메소드를 사용하면 가변 매개변수(variable parameter)를 전달받아 스트림을 생성할 수 있다.
    --------------------------------------------------------------------------------------------------------------------
 */

package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class _2_CreateStream {
    public static void main(String[] args) {

        // 1. 컬렉션
        System.out.println("1. 컬렉션");
        ArrayList<Integer> list_1 = new ArrayList<>();
        list_1.add(4);
        list_1.add(2);
        list_1.add(3);
        list_1.add(1);

        // 컬렉션에서 스트림 생성
        Stream<Integer> stream_1 = list_1.stream();

        // forEach() 메소드를 이용한 스트림 요소의 순차 접근
        // forEach() 는 스트림 요소를 하나씩 소모해가며 순차적으로 요소에 접근하는 메소드이다.
        // 따라서 같은 스트림으로는 forEach() 메소드를 한 번밖에 호출할 수 없다.
        // 단, 원본 데이터의 요소를 소모하는 것은 아니므로, 같은 데이터에서 또 다른 스트림을 생성하여 forEach() 메소드를 호출하는
        // 것은 가능하다.
        stream_1.forEach(System.out::println);

        // 2. 배열
        System.out.println("2. 배열");
        String[] arr_2 = new String[]{"넷", "둘", "셋", "하나"};
        Stream<String> stream_2 = Arrays.stream(arr_2);
        stream_2.forEach(e -> System.out.print(e + " "));
        System.out.println();

        // 배열의 특정 부분만을 이용한 스트림 생성
        Stream<String> stream_2_1 = Arrays.stream(arr_2, 1, 3);
        stream_2_1.forEach(e -> System.out.print(e + " "));
        System.out.println();

        // 3. 가변 매개변수
        System.out.println("3. 가변 매개변수");
        Stream<Double> stream_3 = Stream.of(4.2, 2.5, 3.1, 1.9);
        stream_3.forEach(System.out::println);
    }
}

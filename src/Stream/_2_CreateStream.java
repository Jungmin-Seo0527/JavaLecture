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
    4. 지정된 범위의 연속된 정수

    지정된 범위의 연속된 정수를 스트림으로 생성하기 위해 IntStream 이나 LongStream 인터페이스에는 range() 와 rangeClosed()
    가 정의되어 있다.

    range() 메소드는 명시된 시작 정수를 포함하지만, 명시된 마지막 정수를 포함하지 않는 스트림을 생성한다.
    rangeClose() 메소드는 명시된 시작 정수뿐만 아니라 명시된 마지막 정수까지도 포함하는 스트림을 생성한다.
    --------------------------------------------------------------------------------------------------------------------
    5. 특정 타입의 난수들

    특정 타입의 난수로 이루어진 스트림을 생성하기 위해 Random 클래스에는 ints(), longs(), doubles() 와 같은 메소드가 정의되어
    있다.

    이 메소드들은 매개변수로 스틀미의 크기를 long타입으로 전달받을 수 있다.
    이 메소드들은 만약 매개변수를 전달받지 않으면 크기가 정해지지 않은 무한 스트림(infinite stream) 을 반환한다.
    이때에는 limit() 메소드를 사용하여 다로 스트림의 크기를 제한해야 한다.
    --------------------------------------------------------------------------------------------------------------------
    6. 람다표현식
    
    람다 표현식을 매개변수로 전달받아 해당 람다 표현식에 의해 반환되는 값을 요소르 하는 무한 스트림을 생성하기 위해 Stream 클래스에는
    Iterate()와 generate() 메소드가 정의되어 있다.
    
    iterate() 메소드는 시드(seed) 로 명시된 값을 람다 표현식에 사용하여 반환된 값을 다시 시드로 사용하는 방식으로 무한 스트림을 
    생성한다.
    --------------------------------------------------------------------------------------------------------------------
    7. 파일

    파일의 한 행(line)을 요소라 하는 스트림을 생성하기 위해 java.nio.file.Files 클래스에는 lines() 메소드가 정의되어 있다.
    또한, java.io.BufferedReader 클래스의 lines() 메소드를 사용하면 파일뿐만 아니라 다른 입력으로부터도 데이터를 행(line) 단위로
    읽어 올 수 있다.
    --------------------------------------------------------------------------------------------------------------------
    8. 빈 스트림

    아무 요소도 가지지 않는 빈 스트림은 Stream 클래스의 empty() 메소드를 사용하여 생성할 수 있다.
 */

package Stream;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
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

        // 4. 지정된 범위의 연속된 정수
        System.out.println("4. 지정된 범위의 연속된 정수");
        IntStream stream_4 = IntStream.range(1, 4);
        stream_4.forEach(e -> System.out.print(e + " "));
        System.out.println();

        IntStream stream_4_1 = IntStream.rangeClosed(1, 4);
        stream_4_1.forEach(e -> System.out.print(e + " "));

        // 5. 특정 타입의 난수들
        System.out.println("5. 특정 타입의 난수들");
        IntStream stream_5 = new Random().ints(4);
        stream_5.forEach(System.out::println);

        // 6. 람다 표현식
        System.out.println("6. 람다 표현식");
        // IntStream stream_6 = (IntStream) Stream.iterate(2, n -> n + 2);

        // 7. 파일
        System.out.println("7. 파일");
        // String<String> stream = Files.lines(Path.path); ???
        // Stream<String> stringStream = Files.lines(Path path); // 이게 맞겠지???

        // 8. 빈 스트림
        System.out.println("8. 빈 스트림");
        Stream<Object> stream_8 = Stream.empty();
        System.out.println(stream_8.count());

    }
}


/*
    0. 스트림의 최종 연산(terminal operation)
    스트림 API에서 중개 연산을 통해 변환된 스트림은 마지막으로 최종 연산을 통해 각 요소를 소모하여 결과를 표시
    즉, 지연(lazy) 되었던 모든 중개 연산들이 최종 연산 시에 모두 수행되는것
    이렇게 최종 연산 시에 모든 요소를 소모한 해당 스트림은 더는 사용할 수 없다.

    1) 요소의 출력: forEach()
    2) 요소의 소모: reduce()
    3) 요소의 검색: findFirst(), findAny()
    4) 요소의 검사: anyMatch(0, allMatch(), noneMatch()
    5) 요소의 통계: count(), min(), max()
    6) 요소의 연산: sum(), average()
    7) 요소의 수집: collect()
*/

/*
    1. 요소의 출력
    forEach() 메소드는 스트림의 각 요소를 소모하여 명시된 동작을 수행한다.
    반환 타입이 void이므로 보통 스트림의 모든 요소를 출력하는 용도로 많이 사용돤다.
 */

/*
    2. 요소의 소모
    스트림의 초종 연산은 모두 스트림의 각 요소를 소모하여 연산을 수행하게 된다.
    하지만 reduce() 메소드는 첫 번째와 두 번재 요소를 가지고 연산을 수행한 뒤, 그 결과와 세번째 요소를 가지고 또다시 연산을 수행한다.
    이런 식으로 해당 스트림의 모든 요소를 소모하여 연산을 수행하고, 그 결과를 반환한다.
    또한, 인수로 초깃값을 전달하면 초깃값과 해당 스트림의 첫 번째 요소와 연산을 시작하며, 그 겨로가와 두 번째 요소를 가지고 계속해서 연산을 수행하게 돤다.
 */

/*
    3. 요소의 검색
    findFirst()와 findAny() 메소드는 해당 스트림에서 첫 번째 요소를 참조하는 Optional 객체를 반환한다.
    두 메소드 모두 비어있는 스트림에서는 비어있는 Optional 객체를 반환한다.

    병렬 스트림인 경우에 findAny() 메소드를 사용해야만 정확한 연산 결과를 반환할 수 있다.

 */

/*
    4. 요소의 검사
    해당 스트림의 요소 중에서 특정 조건을 만족하는 요소가 있는지, 아니면 모두 만족하거나 모두 만족하지 않는지를 다음 메소드를 사용하여 확인할 수 있다.

    1) anyMatch(): 해당 스틀미의 일부 요소가 특정 조건을 만족할 경우에 true
    2) allMatch(): 해당 스트림의 모든 요소가 특정 조건을 만족할 경우에 true
    3) noneMatch(): 해당 스트림의 모든 요소가 특정 조건을 만족하지 않을 경우게 true

    세 메소드 모두 인수로 predicate 객체를 전달받으며, 요소의 검사 결과는 boolean 값으로 반환

 */

/*
    5. 요소의 통계: count(), min(), max()
    count() 메소드는 해당 스트림의 요소의 총 개수를 long 타입의 값으로 반환한다.
    또한, max()와 min() 메소드를 사요하면 해당 스트림의 요소 중에서 가장 큰 값과 가장 작은 값을 가지는 요소를 참조하는 Optional 객체를 얻을 수 있다.
 */

/*
    6. 요소의 연산: sum(), average()
    IntStream이나 DoubleStream과 같은 기본 타입 스트림에는 해당 스트림의 모든 요소에 대해 합과 평균을 구할 수 있는 sum()과 average() 메소드가 각각 정의되어 있다.
    이때 average() 메소드는 각 기본 타입으로 래핑 된 Optional 객체를 반환한다.
 */

/*
    7. 요소의 수집
    collect() 메소드는 인수로 전달되는 Collectors 객체에 구현된 방법대로 스트림의 요소를 수집한다.
    또한, Collectors 클래스에는 미리 정의된 다양한 방법이 클래스 메소드로 정의되어 있다.
    이 ㅚ에도 사용자가 직접 COllector 인터페이스를 구현하여 자신만의 수집 방법을 정의할 수도 있다.

    스트림 요소의 수집 용도별 사용할 수 있는 Collectors 메소드는 다음과 같다.
    1) 스트림을 배여잉나 컬렉션으로 변환: toArray(), toCollection(), toSet(), toMap()
    2) 요소의 통계와 연산 메소드와 같은 동작을 수행: counting(), maxBy(), minBy(), summingInt(), averageingInt() 등
    3) 요소의 소모와 같은 동작을 수행: reducing(), joining()
    4) 요소의 그룹화와 분할: groupingBy(), partitioningBy()
 */

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class _3_Stream_Terminal_operation {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("넷", "둘", "셋", "하나");

        // 1. 요소의 출력
        System.out.println("1. 요소의 출력");
        stream.forEach(System.out::println);

        // 2. 요소의 소모
        System.out.println("2. 요소의 소모");
        Stream<String> stream1 = Stream.of("넷", "둘", "셋", "하나");
        Stream<String> stream2 = Stream.of("넷", "셋", "둘", "하나");
        Optional<String> result1 = stream1.reduce((s1, s2) -> s1 + "++" + s2); // 넷++둘++셋++하나
        result1.ifPresent(System.out::println);

        String result2 = stream2.reduce("시작", (s1, s2) -> s1 + "++" + s2); // 시작++넷++넷++둘++하나
        System.out.println(result2);

        // 3. 요소의 검색
        System.out.println("3. 요소의 검색");
        IntStream intStream1 = IntStream.of(4, 2, 7, 3, 5, 1, 6);
        IntStream intStream2 = IntStream.of(4, 2, 7, 3, 5, 1, 6);

        OptionalInt result3_1 = intStream1.sorted().findFirst();
        System.out.println("result3_1 = " + result3_1.getAsInt());

        OptionalInt result3_2 = intStream2.sorted().findAny();
        System.out.println("result3_2 = " + result3_2.getAsInt());

        // 4. 요소의 검사
        // 스트림의 모든 요소를 검사하여 80보다 큰 값을 가지는 요소가 하나라도 존재하는지를 검사
        System.out.println("4. 요소의 검사");
        IntStream stream4_1 = IntStream.of(30, 90, 70, 10);
        IntStream stream4_2 = IntStream.of(30, 90, 70, 10);

        System.out.println(stream4_1.anyMatch(n -> n > 80)); // 80보다 큰 값이 하나라도 존재하면 true
        System.out.println(stream4_2.allMatch(n -> n > 80)); // 모든 스트림의 값이 80보다 커야 true

        // 5. 요소의 통계
        System.out.println("5. 요소의 통계");
        IntStream stream5_1 = IntStream.of(30, 90, 70, 10);
        IntStream stream5_2 = IntStream.of(30, 90, 70, 10);

        System.out.println(stream5_1.count());
        System.out.println(stream5_2.max().getAsInt());

        // 6. 요소의 연산
        System.out.println("6. 요소의 연산");
        IntStream stream6_1 = IntStream.of(30, 90, 70, 10);
        DoubleStream stream6_2 = DoubleStream.of(30.3, 90.9, 70.7, 10.1);
        System.out.println("stream6_1.sum() = " + stream6_1.sum());
        System.out.println("stream6_2.average() = " + stream6_2.average().getAsDouble());

        // 7. 요소의 수집
        System.out.println("7. 요소의 수집");

        // 7-1. collect() 메소드를 이용하여 해당 스트림을 리스트로 변환
        System.out.println("7-1. stream->list by collect() method");
        Stream<String> stream7_1_1 = Stream.of("넷", "둘", "하나", "셋");

        List<String> list = stream7_1_1.collect(Collectors.toList());
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next() + " ");
        }

        // 7-2. Collectors 클래스의 partitioningBy() 메소드를 이용하여 해당 스트림의 각 요소별 글자 수에 따라 홀수와 짝수로 나누어 저장하는 예
        System.out.println("Collectors 클래스의 partitioningBy() 메소드를 이용하여 해당 스트림의 각 요소별 글자 수에 따라 홀수와 짝수로 나누어 저장하는 예");
        Stream<String> stream7_2_1 = Stream.of("HTML", "CSS", "JAVA", "PHP");
        Map<Boolean, List<String>> patition = stream7_2_1.collect(Collectors.partitioningBy(s -> (s.length() % 2) == 0));

        List<String> oddLengthList = patition.get(false);
        System.out.println(oddLengthList);
        List<String> evenLengthList = patition.get(true);
        System.out.println(evenLengthList);
    }
}

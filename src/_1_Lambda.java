import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class _1_Lambda {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("jeong", "pro", "jdk", "java");
        long count = 0;
        for (String name : names) {
            if (name.contains("o")) {
                count++;
            }
        }
        System.out.println(count);

        // filter: 중계연산(조건에 맞는 것만 거른다)
        // if 역할인듯
        count = 0;
        count = names.stream().filter(x -> x.contains("o")).count();
        System.out.println(count);

        // map: stream의 각 요소를 연산하는데 쓰인다. (peek() 과 유사)
        names.stream()
                .map(x -> x.concat("s"))
                .forEach(x -> System.out.println(x));

        // sort():정렬

        // limit()
        List<Integer> ages = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        ages.stream()
                .filter(x -> x > 3)
                .limit(3).forEach(x -> System.out.println(x));


    }
}


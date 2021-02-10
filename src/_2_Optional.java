
// Optional class
/*
    1. Optional 객체 생성
    Optional<T> 클래스는 Integer나 Double 클래스처럼 'T'타입의 객체를 포장해 주는 래퍼 클래스(Wrapper class)
    따라서 Optional 인스턴스는 모든 타입의 참조 변수를 저장할 수 있다.

    이러한 Optional 객체를 사용하면 예상치 못한 NullPointerException 예외를 제공되는 메소드로 간단히 회피할 수 있다.
    즉, 복잡한 조건문 없어도 null값으로 인해 발생하는 예외를 처리할 수 있게 된다.
    따라서 만약 참조 변수의 값이 만에 하나 null이 될 가능성이 있다면, ofNullable()메소드를 사용하여 Optional 객체를 생성하는 것이 좋다.
    ofNullable() 메소드는 명시된 값이 null이 아니면 명시된 값을 가지는 Optional 객체를 반환하며, 명시된 값이 null이면 비어있는 Optional 객체를 반환한다.
    Optional<String> opt = Optional.ofNullable("자바 Optional 객체");
    System.out.println(opt.get());
    
    null
 */

/*
    2. Optional 객체에 접근
    get() 메소드를 사용하면 Optional 객체에 저장된 값이 접근할 수 있다.
    만약 Optional 객체에 저장된 값이 null이면, NoSuchElementException 예외가 발생한다.
    따라서 get() 메소드를 호출하기 전에 isPresent() 메소드를 사용하여 Optional 객체에 저장된 값이 null인지 아닌지를 먼저 확인하는 후 호출하는것이 좋다.

    2-1. null값 대체
    또한 다음과 같은 메소드를 사용해여 null 대신에 대체할 값을 지정할 수도 있다.
    1) orElse(): 저장된 값이 존재하면 그 값을 반환하고, 값이 존재하지 않으면 인수로 전달된 값을 반환함
    2) orElseGet(): 저장된 값이 존재하면 그 값을 반환하고, 값이 존재하지 않으면 인수로 전달된 람다 표현식의 결과값을 반환
    3) orElseThrow(): 저장된 값이 존재하면 그 값을 반환하고, 값이 존재하지 않으면 인수로 전달된 예외를 발생시킴
 */

/*
    3. 기본타입의 Optional 클래스
    자바에서는 IntStream 클래스와 같이 기본 타입 스트림을 위한 별도의 Optional 클래스를 제공하고 있다.

    1) OptionalInt
    2) OptionalLong
    3) OptionalDouble
    이러한 클래스는 반환타입이 Optional<T> 타입이 아니라 해당 기본 타입이라는 사실만 제외하면 거의 모든 면에서 비슷
    또한 Optional 객체이서 get() 메소드를 사용하여 저장된 값이 접근할 수 있는 것처럼 클래스별로 저장된 값이 접근할 수 있는 메소드를 제공
    Optional<T>: T get()
    OptaionlInt: int getAsInt()
    OptionalLong: long getAsLong()
    OptionalDouble: double getAsDouble()
 */

/*
    4. Optional Method
    
    1) static <T>Optional<T>empty(): 아무런 값도 가지지 않는 비어있는 Optional 객체를 반환
    2) T get(): Optional 객체에 저장된 값을 반환함
    3) boolean isPresent(): 저장된 값이 존재하면 true, else false
    4) static<T>Optional<T> of(T vlue): null이 아닌 명시된 값을 가지는 Optional 객체를 반환함
    5) static<T>Optional<T>ofNullable(T value): 명시된 값이 null이 아니면 명시된 값을 가지는 Optional 객체를 반환하며,
                                                명시된 값이 null이면 비어있는 Optional 객체를 반환
    6) T orElse(T other): 저장된 값이 존재하면 그 값을 반환하고, 값이 존재하지 않으면 인수로 전돨된 값을 반환
    7) T orElseGet(Supplier<?extends T>other): 저장된 값이 존재하면 그 값을 반환하고, 값이 존재하지 않으면 인수로 전달된 람다 표현식의 결과값을 반환
    8) <X extends Throwable T orElseThrow(Supplier<?extends X> exceptionSupplier): 저장된 값이 존재하면 그 값을 반환, else 인수로 전달된 예외를 발생
 */

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class _2_Optional{
    public static void main(String[] args) {
        // 1. Optional 객체 생성
        Optional<String> opt = Optional.ofNullable("자바 Optional 객체");
        System.out.println(opt.get());

        // 2. Optional 객체에 접근
        // opt 객체가 null 값이 아니라면 get() 을 이용해 그 값을 출력
        if (opt.isPresent()) {
            System.out.println(opt.get());
        }

        // 2-1. null값 대체
        opt = Optional.empty(); // Optional를 null로 초기화함
        System.out.println(opt.orElse("빈 Optional 객체"));
        System.out.println(opt.orElseGet(String::new));

        // 3. 기본타입의 Optional 클래스
        System.out.println("3. 기본타입의 Optional 클래스");
        IntStream stream = IntStream.of(4, 2, 1, 3);
        OptionalInt result = stream.findFirst();
        System.out.println(result.getAsInt());
    }
}
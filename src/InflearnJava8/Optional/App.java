package InflearnJava8.Optional;

import InflearnJava8.Stream.OnlineClass;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        OnlineClass spring_boot = new OnlineClass(1, "spring boot", true);
        // Duration studyDuration = spring_boot.getProgress().getStudyDuration(); // getProgress 메소드가 null 값을 가리킴
        // System.out.println(studyDuration);
        Optional<Progress> progress = spring_boot.getProgress();

        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("jpa"))
                .findFirst();

        optional.ifPresent(oc-> System.out.println(oc.getTitle()));
        OnlineClass onlineClass = optional.orElse(createNewClasss()); // 무조건 createNewClasss 메소드를 실행은 함
        System.out.println(onlineClass.getTitle()); // 단 optional 이 널이 아니면 값을 바꾸진 않음

        OnlineClass onlineClass2 = optional.orElseGet(App::createNewClasss); // optionl 에 값이 없을때만 실행을 함
        System.out.println(onlineClass.getTitle());

        // OnlineClass onlineClass1 = optional.orElseThrow(IllegalArgumentException::new);
        // System.out.println(onlineClass1.getTitle());

        Optional<OnlineClass> onlineClass3 = optional
                .filter(oc -> !oc.isClosed());
        System.out.println(onlineClass3.isEmpty());

        Optional<Integer> integer = optional.map(OnlineClass::getId);
        System.out.println(integer.isPresent());

        Optional<Progress> progressMap = optional.flatMap(OnlineClass::getProgress);

    }

    private static OnlineClass createNewClasss() {
        System.out.println("creating new online class");
        return new OnlineClass(10, "New class", false);
    }

}

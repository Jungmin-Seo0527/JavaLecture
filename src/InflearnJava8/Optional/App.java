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



    }

}

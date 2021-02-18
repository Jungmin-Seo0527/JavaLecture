package InflearnJava8.DateTime;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        long time = date.getTime();
        System.out.println(date);
        System.out.println(time);

        Thread.sleep(1000);
        Date after3Seconds = new Date();
        System.out.println("after3Seconds = " + after3Seconds);
        after3Seconds.setTime(time);
        System.out.println("after3Seconds = " + after3Seconds);

        Calendar JungminBirthDay = new GregorianCalendar(1994, Calendar.JUNE, 27);

        /*
            지금 이 순간을 기계 시간으로 표현하는 방법
            Instant.now(): 현재 UTC(GMT)를 리턴한다.
            Universal Time Coordinated == Greenwich Mean Time
         */
        System.out.println("--- 지금 이 순간을 기계 시간으로 표현하는 방법 ---");
        Instant now = Instant.now();
        System.out.println(now);
        System.out.println(now.atZone(ZoneId.of("UTC")));

        ZonedDateTime zonedDateTime = now.atZone(ZoneId.systemDefault());
        System.out.println(zonedDateTime);

        System.out.println("--- 인류의 일시를 표현하는 방법 ---");
        LocalDateTime now1 = LocalDateTime.now();
        System.out.println(now1);

        LocalDateTime birthday = LocalDateTime.of(1994, Month.MAY, 27, 0, 0, 0);
        System.out.println("birthday = " + birthday);

        ZonedDateTime nowInKoreaIncheon = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println("nowInKoreaIncheon = " + nowInKoreaIncheon);

        Instant nowInstant = Instant.now();
        ZonedDateTime zonedDateTime1 = nowInstant.atZone(ZoneId.of("Asia/Seoul"));
        System.out.println("zonedDateTime1 = " + zonedDateTime1);

        System.out.println("--- 기간을 표현하는 방법 ---");
        LocalDate today = LocalDate.now();
        LocalDate thisYearBirthday = LocalDate.of(2021, Month.MAY, 27);

        Period period = Period.between(today, thisYearBirthday);
        System.out.println("period.getDays() = " + period.getDays());
        System.out.println(period.get(ChronoUnit.DAYS));

        Period until = today.until(thisYearBirthday);
        System.out.println("until = " + until.getDays());
    }
}

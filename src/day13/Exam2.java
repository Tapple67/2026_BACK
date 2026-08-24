package day13;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Exam2 {
    public static void main(String[] args) {
        //[1] 래퍼클래스: 기본타입 --> 참조 타입 표현, 참조 타입은 상태 /기능 갖는다.
        int value1 = 100;       //System.out.println(value1.toString());
        Integer value2 = 100;     System.out.println(value2.toString());
        //즉, 기본타입은 기능이 없으니까 참조 타입으로 변환해서 기능 사용하자
        //1. 언박싱 과 오토 박싱
        int value3 = value2;  //Integer(참조) --> int (기본) 변환 <언박싱>
        Integer value4 = value1;   //int (기본) --> Integer(참조) 변환 <오토박싱>

        //DTO: 포장(래퍼), 정보가 많아서

        //2. 타입 변환(csv,excel,api,python,json 등등) 자바에서 외부자료들을 주고받을 때
        // xxxx.parsexxx(문자열)
        int value5 = Integer.parseInt("100"); 
        double value6 = Double.parseDouble("3.14");
        boolean value7 = Boolean.parseBoolean("true");
        //기본타입 --> 문자열 변환
        String s1 =100+"";
        String s2 = String.valueOf(100);

        //[2] 날짜 /시간 현재 날짜 가져오기
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        // 2. 현재 시간 가져오기
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        // 3. 현재 날짜/시간 가져오기
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        // 4. 정해진 날짜/시간 객체 생성
        LocalDateTime localDateTime2 = localDateTime.of(2026 , 8, 19,11,11,30);
        System.out.println(localDateTime2);

        //5. 정해진 형식으로 날짜/시간 표현
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("y년m월d일 hh시mm분ss초");
        System.out.println(localDateTime2.format(formatter));

        //6. 날짜 계산
        LocalDateTime result1 = localDateTime2.plusDays(20);
        System.out.println(result1);
        LocalDateTime result2 = localDateTime2.plusDays(20);
        System.out.println(result2);

        //7. 특정한 날짜 /시간 추출 , getxxx()
        System.out.println(localDateTime2.getYear());
        System.out.println(localDateTime2.getDayOfMonth());
        System.out.println(localDateTime2.getDayOfMonth());
        System.out.println(localDateTime2.getSecond());



    }
}

package day13;

import java.util.Random;
import java.util.UUID;

public class Exam4 {
    public static void main(String[] args) {
        
        //[1]난수클래스
        //1. 랜덤 객체 , .nextXXXX(), .nextXXXX(개수) + 시작번호
        Random random = new Random();
        
        int value1 = random.nextInt(); System.out.println(value1);
        int value2 = random.nextInt(10); System.out.println(value2);
        int value3 = random.nextInt(10)+1; System.out.println(value3);
        boolean value4 = random.nextBoolean(); System.out.println(value4);

        //[2] uuid 범용 고유 식별자,, 절대 중복없는 난수 생성
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);

    }
    
}

package day13;

import java.util.Arrays;

public class Exam3 {
    

    public static void main(String[] args) {
        //String 클래스
        //1. 문자열은 배열이다.
        char str1 = '유';;
        char[] str2 = {'유','재','석'};
        String str3 = "유재석";
        char str4 = 65; 
        System.out.println(str4);
        char[] str5={74,65,86,65};
        System.out.println(str5);
        char str6 = '유'; System.out.println((int)str6); 
        //* 정수 char */
        //1조 문자열 비교
        System.out.println("유재석" == "유재석");
        System.out.println(new String("유재석") =="유재석");
        System.out.println(new String("유재석").equals("유재석"));


        //4. 문자열A.concat(문자열)
        String str7= "자바";
        String str8= "자바";
        System.out.println(str7.concat(str8));
        System.out.println(str7+str8);

        //5. StringBuilder, append()
        StringBuilder builder = new StringBuilder();
        builder.append(str7);
        builder.append(str8);
        System.out.println(builder);
        //6. chatAt(인덱스)
        String str9 = "자바프로그래밍"; System.out.println(str9.charAt(2));
        //7. length()문자열내 문자계수 반환
        System.out.println(str9.length());
        //8. replace(기존문자, 새로운 문자): 만일 기존 문자가 존재하면 새로운 문자로 치환하여 반환
        System.out.println(str9.replace("자바", "JAVA"));
        
        //9.substring(시작인덱스,[끝인덱스]), 시작인덱스 부터 끝 인덱스 전까지 문자열 추출
        String str10 = "012345-1230123";
        System.out.println(str10.substring(6));
        //10. split(기준 문자) , 기준 문자 기준으로 문자열 분해하여 배열반환
        System.out.println(str10.split("-"));
        String[] strAry = str10.split("-");
        System.out.println(strAry[0]);
        System.out.println(strAry[1]);

        //11. .indexOf(찾을 문자), 만일 찾을 문자가 존재하면 인덱스, 없으면 -1
        System.out.println("자바 프로그래밍 언어".indexOf("프로")); //3
        System.out.println("자바 프로그래밍 언어".contains("프로")); //true

        //12.
        byte[] strAry2 = "ABC".getBytes();
        System.out.println(Arrays.toString(strAry2));
        System.out.println(new String(strAry2));

    }

    
    
}

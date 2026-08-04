package day05;

public class exam {
    
    
    
    

        
    public static void main(String[] args) {
        /*
        
        1. 객체 란? 상태 또는 정의 하는것
         ->주체(개발자) vs 객체(프로그램내 모든 대상)
         ->상태(값->자료), 행위(함수/메소드)
        2. 객체 지향 프로그래밍 : 개발자(주체)가 컴퓨터내 객체(대상) 만들기
        3. 객체 정의: 클래스 (설계도) 기반으로 객치 정의한다,
        4. 클래스란? 객체(추상)의 상태와 행위 코드로 정의한곳
            1)설계클래스(객체 정의 용도) 2) main함수 클래스(실행 목적 용도)
        5. 인스턴스란? 클래스로 (객체가) 정의된 기반으로 메모리 할당
            new 연산자 이용
            ****** 8가지 타입(boolean char byte short int long float double) 기본타입  ************
            ****** 8가지외 커스텀 타입=> 클래스 타입 / 참조타입 *****
            즉 클래스란? 존재하지 않는 타입 만드든 것만 동일
        */


            /*
            1. 객체만들기
            2. class 명 
            3. 실행문 에서 객체 생서이 타입명 변수명 = new 생성자 ( 인수, 인수); 
                1.class 타입도 참조 타입이다.
                2. class  타입은 첫글자 대문자 ,기본타입 소문자, 변수명 소문자 시작 관례
                3.new 연산자 : 클래스 기반으로 (heap) 메모리 할당
            
            */
            class Student{
                int studentID;
                String studentName;
            }


            new Student( );  // 객체 생성
            Student s1 = new Student( ); // 객체 생성 후 변수에 저장

            System.out.println( s1 );
            System.out.println( s1.studentID );
            System.out.println( s1.studentName );

            s1.studentID = 10;  
            System.out.println( s1.studentID );
            s1.studentName = "유재석";
            System.out.println( s1.studentName );

            Student s2 = new Student( );
            Student s3 = new Student( );
            Student s4 = s2;
            System.out.println( s2 );
            System.out.println( s3 );
            System.out.println( s4 );
            s2.studentName = "강호동";
            System.out.println(s2.studentName); System.out.println(s4.studentName);


            }


        
    

}

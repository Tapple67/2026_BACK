package day12;

import java.util.InputMismatchException;
import java.util.Scanner;

public class exam12 {
    public static void main(String[] args) {
        //예외란? 에러 발생 시 고치는 게 아니라 흐름 제어 vs if
        //[1] 일반 예외: 실행(컴파일)하기 전 예외가 발생 할 수 있는 코드에 대해 미리 예외
        //1. ClassNotFoundException: 클래스 찾을 수 없다.
        try{
            Class.forName("string");
        }catch(ClassNotFoundException e){
            System.out.println("존재하지 않은 클래스입니다." + e);
        }
        
        //스레드란? 컴파일(번역)된 코드들을 읽어들이는 흐름
        //2. InterruptedException: 스레드에 문제가 발생 하면
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            System.out.println("인터럽트 문제 발생 "+ e);
        }
        //[2] 실행 예외 : 실행(컴파일) 후 예외 발생 *경험 중요* 예측하거나 유지보수(로그)
        
        try {
            String str1 = null; // null이란? 참조값이 없다 즉, 객체가 없다.
            System.out.println( str1.length());
        } catch (NullPointerException 변수) {
            // TODO: handle exception
            System.out.println(변수);
        }
        //4. NumberFormatException: 숫자 타입으로 변환이 불가능한 이유
        try {
            String str2 = "100"; Integer.parseInt(str2);
            String str3 = "100a"; Integer.parseInt(str3);

        } catch (NumberFormatException e) {
            // TODO: handle exception
            System.out.println(e);
        }

        //5.
        
        try {
            int[] 배열 = {10, 25};
            System.out.println(배열[0]);
            System.out.println(배열[2]);
        } catch (ArrayIndexOutOfBoundsException e) {
            // TODO: handle exception
            System.out.println(e);

        } // *여러 타입들의 예외들을 하나의 타입으로 Exception(상위)클래스 사용 가능하다.
        
        //다중 catch : try에서 다양한 예외들을 다양하게 흐름제어 , catch 1qjs!
        //[4] finally: 예외가 발생 여부 상관없이 무조건 실행 구역, 외부 프로그램 연동 종료 코드
        //6. InputMismatchException: 입력 타입 예외 발생
        try {
            Scanner scan = new Scanner(System.in);
            int ch = scan.nextInt();
            Integer.parseInt("ABC");
        } catch (InputMismatchException e) {
            // TODO: handle exception
            System.out.println("정수만 입력하세요");
        } catch (NumberFormatException e){
            System.out.println(" 타입 변환 오류");
        } catch (Exception e){
            System.out.println("");
        } finally {
            System.out.println("무조건 실행");

        }
        
        // *try{예외발생하것 같은 코드}catch(예외 클래스명 변수명){}catch(예외클래스명 변수명){}finally{}
        //[5] 예외 던지기(떠넘기기) , *예외반환*: 해당 메소드를 호출한 곳으로 예외 반환
        try {
            method1();
        } catch (Exception e) {
            System.out.println(e);
        }

        method2();

    }
    
    //7. 예외발생시 발생한 곳에서 예외처리하지 않고 반환
    public static void method1() throws ClassNotFoundException{
        Class.forName("java.lang.Spring"); //예외 발생?
    }


    public static void method2(){

        try {
            Class.forName("java.lang.Spring"); //예외 발생?
        } catch (Exception e) { 
            System.out.println(e);
        }
        
    }
}

package day16;

public class Exam1 {
    public static void main(String[] args) {
        /*
            스레드: 코드 실행 흐름 단위.
            멀티스레드: 여러 사용자들이 하나의 웹서버(통캣)에 요청함으로 웹서는 멀티 스레드로 관리
            장점: 여러 요청들을 다중처리, 단점: 관리(동기화/과부하)
            1. 동기화 vs 비동기화 
                동기화: 락(대기)상태 이용하여 단 하나의  스레드 가 하나의 메소드 점유
                    -무결성 보장함, 순서가 필요한 경우!
                비동기화: 여러 스레드가 하나의 메소드 같이 점유
                    - 무경성 보장 없음, 순서가 필요 없는 경우! (요청 후 다른 작업 필요한 경우)
        */

            계산기 calculator = new 계산기();

            스레드1 thread1 = new 스레드1();
            thread1.calculator = calculator;

            스레드2 thread2 = new 스레드2();
            thread2.calculator = calculator;

            thread1.start();
            thread2.start();

            
            
        
    }
}
class 스레드1 extends Thread{
    public 계산기 calculator;
    @Override
    public void run() {
        calculator.setMemory(100);
    }
}
class 스레드2 extends Thread{
    public 계산기 calculator;
    @Override
    public void run() {
        calculator.setMemory(200);
    }
}


class 계산기{
    //멤버변수란? 인스턴스의 상태/변수/값저장소/필드/속성, 인스턴스마다!! 할당
    public int memory;
    //메소드란? 인스턴스의 행위/이벤트, 여러 인스턴스가 공유

    //[1]비동기화
    public void setMemory(int memory){
    //[2]동기화
    // public synchronized void setMemory(int memory){
        this.memory = memory;
        //super란? 부모의 메소드/멤버변수 가리킴
        //2~3초 대기상태만들기
        try {
            Thread.sleep(2000);
        } catch (Exception e) {}
        System.out.println("현재 계산기의 값"+ this.memory);
    }
}

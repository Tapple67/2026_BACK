package day15;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Exam4 {
    public static void main(String[] args) {

        //[1]시계 구현
        시계스레드 runnable1 = new 시계스레드();
        Thread thread = new Thread(runnable1);  //스레드 객체에 구현체 대입

        thread.start();  // 스레드 객체 시작, [1.MAIN스레드]가 [2.시계스레드] 켠다

        //[2] 입력 구현 
        // while (true) {
        //     System.out.println("1.ON, 2.OFF :");
        //     Scanner scan =new Scanner(System.in);
        //     int ch = scan.nextInt();
            
        // }
        
        //[3]타이머 구현[3.타이머 스레드]
        타이머스레드 thread2 =null;

        while (true) {
            System.out.println("1.ON, 2.OFF :");
            Scanner scan =new Scanner(System.in);
            int ch = scan.nextInt();
            if(ch ==1){
                thread2 = new 타이머스레드();
                thread2.start();
            }
            if(ch==2){
                if(thread2 != null){
                    thread2.state = false;
                }
            }
        }








    }//main end  [MAIN스레드] 사라짐
    
}//class end

class 시계스레드 implements Runnable{//Runnable 인터페이스 구현하면 멀티 스레드 정의!
    @Override
    public void run() {
        while (true) {
            System.out.println(LocalDateTime.now());

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }// run 종료시 작업 스레드 종료

}

class 타이머스레드 extends Thread{
    public boolean state = true;
    @Override
    public void run() {
        int time = 0;
        while (state) { // 타이머 작동여부가 t이면 무한 루프 / f 종료
            time++;
            System.out.println(">> 타이머: " + time + "초");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
        }
    }// run 종료시 작업 스레드 종료
}
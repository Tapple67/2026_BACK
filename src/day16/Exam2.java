package day16;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Exam2 {
    public static void main(String[] args) {
        
        /*
        스레드 풀: 매번 새로운 스레드 생성하지 않고 미리 일정한 스레드 풀(pool)에 생성
        목적: 과부하 방지
        구조: 선입선출 방식으로 먼저 요청이 들어온 순서대로 대기중인 스레드가 처리한다.
            *) 만일 대기중인 스레드가 없으면 wait(대기상태) 상태이며 스레드가 작업이 끝나고 대기중인 요청 처리
            활용처 : 웹서버(통캣),jdbc, 안전한 서버(돈) 구축 등등

            강호동 ---안녕--->
                  <---안녕---
                  
            신동엽 <---안녕---   카카오톡(서버)

            유재석 <---안녕---
        */

            //[1] 스레드풀 구축, ThreadPoolExecutor
            ThreadPoolExecutor pollExecutor = (ThreadPoolExecutor)Executors.newFixedThreadPool(3);
            //[2] 임의의 요청 스레드 생성 (구현체)
            Runnable runnable =new Runnable(){
                @Override
                public void run() {
                    for (int i = 0; i < 20; i++) {
                        try {
                            Thread.sleep(3000);
                        } catch (Exception e) {
                        }
                        CallTask task = new CallTask(i); //i번째 요청스레드 생성
                        pollExecutor.submit(task); //스레드 풀에 요청스레드 배정
                        //[6] 현재 스레드 상태
                        int 작업중인스레드수 = pollExecutor.getActiveCount();
                        int 대기중인스레드수 = pollExecutor.getCorePoolSize() - 작업중인스레드수;
                        int 대기중인요청수 = pollExecutor.getQueue().size();
                        System.out.println("작업중인 스레드수" + 작업중인스레드수);
                        System.out.println("대기중인 스레드수" + 대기중인스레드수);
                        System.out.println("대기중인 요청수" + 대기중인요청수);


                    } //for end
                    pollExecutor.shutdown();

                }//run end
            }; //runnable end

            Thread thread = new Thread(runnable);
            thread.start();
    } //main end
}//class end

class CallTask implements Runnable{
    private Random random = new Random();
    private int id;
    public CallTask(int id){this.id =id;}
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName+"상담원이 고객통화 시작됨 고객id:"+id);
        try {
            Thread.sleep(6000+random.nextInt(6000)); // 6~12초
        } catch (Exception e) {
        }
        System.out.println( threadName + "상담원이 고객통화 종료됨");
    }
}
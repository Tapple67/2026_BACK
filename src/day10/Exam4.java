package day10;

public class Exam4 {
    public static void main(String[] args) {
        Car myCar = new Car();  // Car 타입의 mycar가 Car 생성자를 참조
        myCar.tire = new Tire();  //myCar 의 Tire타입 인 tire 멤버변수가 Tire 생성자 참조
        myCar.run();  //myCar의 run() 메서드 실행 run()에 tire.roll()이 있기 때문에 Tire 생성자를 참조해서 roll()을 실행 -->[일반] 타이어가 회전
        myCar.tire = new HankookTire(); //myCar.tire가 HankookTire 생성자 참조,  이전 생성자 참조 끊김
        myCar.run(); //메서드 명 , 매개변수가 같아 오버라이딩, HankookTire의 roll()이 실행
        myCar.tire = new KumhoTire(); //myCar.tire가 KumhoTire 생성자 참조, 이전 생성자 참조 끊김
        myCar.run(); //메서드 명 , 매개변수가 같아 오버라이딩, KumhoTire의 roll()이 실행
        System.out.println( myCar.tire instanceof Tire ); // true
        System.out.println( myCar.tire instanceof KumhoTire ); // true
        System.out.println( myCar.tire instanceof HankookTire ); // false
      
    } // main
}



class Car{ // 자동차      
 Tire tire;  
 void run() { this.tire.roll(); }
}

class Tire{ // 타이어

    void roll(){
        System.out.println("[일반] 타이어가 회전");
    }
}

class HankookTire extends Tire{
    void roll(){ System.out.println("[한국] 타이어가 회전(업그레이드)"); }
}

class KumhoTire extends Tire{ 
    void roll(){ System.out.println("[금호] 타이어가 회전(업그레이드)"); }
}


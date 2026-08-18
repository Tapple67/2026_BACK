package day11;

public class Exam3 {
    public static void main(String[] args) {

        Car myCar = new Car();
        myCar.tire = new HankookTire();
        myCar.run();

        myCar.tire = new KumhoTire();
        myCar.run();

        System.out.println( myCar.tire instanceof Tire ); // true
        System.out.println( myCar.tire instanceof KumhoTire ); // true
        System.out.println( myCar.tire instanceof HankookTire ); // false
        //[*] 익명(클래스 없이)구현체 = 일회성 사용하는 인터페이스 구현체
        // *자체적으로 추상메소드 오버라이딩 *
        // new 인터페이스명(){오버라이딩}
        myCar.tire =new Tire(){
            @Override public void roll(){
                System.out.println("일반타이어 회전");
            }
        };
        myCar.run();

    }
    
}

class Car{
    Tire tire;
    void run(){this.tire.roll();}
}

interface Tire{
    void roll();
}

class HankookTire implements Tire{
    @Override public void roll(){
        System.out.println("한국타이어 회전");
    };
}
class KumhoTire implements Tire{
    @Override public void roll(){
        System.out.println("금호타이어 회전");
    };
}

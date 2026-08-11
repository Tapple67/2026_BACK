package day10;

public class Exam3 {
    public static void main(String[] args) {

        /*
        오버로딩 : 생성자명 또는 메소드명 동일하게 여러개 선언 
        오버라이딩 : 물려 받은 메소드 재정의
        */

        상위클래스 obj1 = new 상위클래스();
        obj1.show();
        System.out.println(obj1.value1);
        System.out.println(obj1.value2);


        하위클래스 obj2 = new 하위클래스();
        obj2.show();
        System.out.println(obj2.value1);
        System.out.println(obj2.value2);
        System.out.println(obj2.value3);
        System.out.println(obj2.value4);
        

        상위클래스 obj3 = obj2;
        obj3.show();

        상위클래스 c1 = new 하위클래스();
    }
    
}

class 상위클래스{
    int value1 = 10;
    int value2 = 20;

    상위클래스(){System.out.println(" 상위 탄생");}
    void show() { System.out.println("상위 메소드 실행");}
}

class 하위클래스 extends 상위클래스{
    int value3 =30; int value4 =40;
    하위클래스(){System.out.println("하위탄생");}
    // 주의할점 :오버로딩vs 오버라이딩
    void show(int a){} //메소드명은 같지만 매개변수가 다르다.
        

    void show(){
           System.out.println("하위 메서드가 재정의 실행");
    } // 사위 클래스의 매소드 선언부 모두 동일하면 재정의
}


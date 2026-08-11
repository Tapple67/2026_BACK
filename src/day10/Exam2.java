package day10;

public class Exam2 {
    public static void main(String[] args) {
        //자바는 100% 객체지향이다
        // Object(슈퍼클래스) 클래스로부터 모든 클래스는 상속관계
        //1.
        A a = new A();   //A --> Object

        B b = new B();   //B --> A --> Object

        C c= new C();    //C --> A --> Object

        D d= new D();    //D --> C --> A --> Object

        E e = new E();   //E --> C --> A --> Object


        A a2 = b;  // B -->A 가능
        Object o1 = a2;
        B b2 = (B)a2;
        // C c2 = (C)b2;
        // 타입 확인
        System.out.println( e instanceof Object);
        System.out.println( e instanceof C); 
        // System.out.println( e instanceof D);
        // System.out.println( e instanceof B);

        //instanceof 활용해서 타입 확인 하여 변환





    }
    
}

class A{
    A(){System.out.println("[1]A객체 생성");}
}
class B extends A{
    B(){System.out.println("[2]B객체 생성");}

}
class C extends A{
    C(){System.out.println("[3]C객체 생성");}
}
class D extends B{
    D(){System.out.println("[4]D객체 생성");}

}
class E extends C{
    E(){System.out.println("[5]E객체 생성");}

}

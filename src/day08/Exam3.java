package day08;

public class Exam3 {
    static int a;
    void b(){};
    public static void main(String[] args) {
        System.out.println(a);


        D d1 = new D();
        D d2 = new D();

        

        // d1.고정변수 = 20;

        // 2 static 클래스 명.(클래스마다) 정적변수
        D.정적변수 = 20;
        D.정적변수 = 30;

        // 2 static 객체 명.(인스턴스) 멤버변수
        d1.멤버변수 =20;
        d2.멤버변수 =30;

        System.out.println(D.상수);




    }
    
}

class D{
    //- final 키워드: 초기값 이후 수정 불가능
    //public final int 고정변수;
    // - static 키워드: (정적) 우선할당 변수
    public static int 정적변수;  //클래스/정적 변수

    public int 멤버변수 =10;

    // static 프로그램 시작시 할당되고 프로그램 종료시사라진다.
    // public static final : 상수

    public static final int 상수 =30;
    // 무분별한 사용은 메모리 효율성 떨어짐
    
}
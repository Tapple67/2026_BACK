package day09;

public class Exam1 {
    public static void main(String[] args) {
        //싱글톤패턴 : 프로그램내 단 *하나의* 인스턴스(객체) 갖는 설계 구조

        //목적  1. 다수 인스턴스 생성 방지
        //      2.하나 인스턴스 사용하여 메모리 공유

        View 인스턴스1 = new View(); System.out.println(인스턴스1);
        View 인스턴스2 = new View(); System.out.println(인스턴스2);
        Controller 인스턴스3 = Controller.getInstance(); System.out.println(인스턴스3);
        Controller 인스턴스4 = Controller.getInstance(); System.out.println(인스턴스4);



    }
    
    
}

class View{

}

class Controller{
    private Controller(){}   // 1. 생성자를 private 한다. <다른 클래스 에서 생성자 사용금지> 


    //2. 클래스 내부에 단 하나의 인스턴스 생성한다
    private static final Controller instance = new Controller();
    //3. 클래스 내부에 인스턴스를 간접 사용(공유) 하도록 getter를 만든다.

    public static Controller getInstance() {
        return instance;
    }
    
}

package day06;

class Phone{
    // *** 클래스 가족 (멤버들) ***
    // 1.멤버변수
    String model;
    String color;
    int price;

    // 2. 생성자
    // 생성자가 1개 없으면 *자동으로 기본생성자* 생성
    // 생성자명은 중복이 안된다. -> 오버로딩(매개변수 개수, 타입,순서 다르면 ) 중복 가능
    // 메서드와 다르게 생성자는 반환이 없다 (생성된 객체 주소:)
    //1) 기본생성자 : 매개변수가 없는
    Phone(){};

    //2) 기본생성자 : 매개변수가 있는

    Phone (String model,String color){
        this.model = model;
        this.color = color;
    }

    //3) 기본생성자 : 매개변수가 없는

    Phone (String model,String color,int 가격){
        this.model = model;
        this.color = color;
        price = 가격;
    }
    // 3. 메소드/함수


}





public class exam {

    public static void main(String[] args) {
        
        /*
        생성자 : 인스턴스(객체) 생성할 때 사용되는 키워드
        선언하는 방법
            1) 클래스 내부
            2) 클래스명과 동일!
            3) 오버로딩 지원: 동일한 이름으로 여러개 선언
            목적 : 1) 빠른 초기화 2)객체생성 규칙/유효성 검사
            종류 : 1) 기본 생성자(매개변수없는) 2) 매개변수있는생성자
        */

            // 기본 생성자로 객체 생성
            Phone p1 = new Phone(); 
            p1.model = "애플";

            //정의 생성자로 객체 생성
            Phone p2 = new Phone("갤럭시","검정"); 


            //정의 생성자로 객체 생성
            Phone p3 = new Phone("갤럭시","검정",5000); 

            System.out.println(p1.model + p1.color);

            //선언되는 변수 위치에 따라 이름이 다르다.
            //지역변수: if/for/func(함수){} 안의 선언된 변수
            //멤버변수 : 클래스{} 안에서 선언되고 "new 인스턴스" 생성된 객체 내 변수
            //          this: 해당 생성자/메소드 호출한 객체 (인스턴스)뜻
            //매개변수 : 생성자/메소드 호출하면서 인수깂들을 저장하는 변수

    }
    
}

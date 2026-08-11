package day10;

public class exam1 {
    public static void main(String[] args) {

        동물 animal1 = new 동물();

        animal1.name = "강아지";
        animal1.show();

        조류 bird1 = new 조류(); // 조류 생성자 + 동물 생성자
        bird1.name = "비둘기";
        bird1.show();

        참새 sparrow1 = new 참새();
        sparrow1.name = "참새";
        sparrow1.show();

        닭 chicken = new 닭();
        chicken.name = "닭";
        chicken.show(); 


        조류 bird2 =sparrow1;

        동물 animal2 = sparrow1;

        참새 sparrow2 = (참새)animal2;  // 강제 타입 변환 /다운캐스팅(내려가기) 

        참새 sparrow3 = (참새)animal1; // 안되는 이유 동물1이 태어날때 참새가 태어나지않음
    }
}

class 동물{ //부모클래스
    String name;  // 1. 멤버변수

    동물(){ //2.생성자
        System.out.println("동물 생성");
    }
    void show(){ //3.메서드
        System.out.println("동물 입니다.");
    }
}//c end 

class 조류 extends 동물{
    조류(){ //2.생성자
        System.out.println("조류 생성");
    }
} // 하위 클래스 확장 extends 상위 클래스 명{}
class 참새 extends 조류{
    
}
class 닭 extends 조류{}

/*
  < 가계부 >
    동물
     |
    조류
  |     |
  참새    닭
*/
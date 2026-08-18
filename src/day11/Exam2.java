package day11;

public class Exam2 {
    public static void main(String[] args) {
        KeyBoard myBoard;

        myBoard = new SportsGame();
        myBoard.aKey();

        myBoard = new ActionGame();
        myBoard.bKey(1);
    }
}

class ActionGame implements KeyBoard{
    @Override
    public void aKey(){System.out.println("공격");}
    @Override
    public int bKey(int x){System.out.println("방어"); return x;}
};

class SportsGame implements KeyBoard{
    @Override
    public void aKey(){System.out.println("슈팅");}
    @Override
    public int bKey(int x){System.out.println("수비"); return x;}
};


interface Buy{
    //1) 추상메소드: 구현부가 없는 메서드
    public abstract void method1();
    //2. 디폴트메소드 : 구현부가 있는 메소드
    public default void method2(){};
    //3. 정적메소드 : static 이면 인스턴스 없이(구현체) 사용 메소드
    public static void method(){}
    //4. 비공개메소드: 하위타입 오버라이딩 불가능한 메소드
    private void method4(){}
}
interface Sell{void method5();}
//생략시 public absract 기본적용됨

class Customer implements Buy, Sell{
    // 여러개 인터페이스들을 구현가능
    // 추상메소드만! 필수 오버라이딩
    @Override public void method1(){}
    @Override public void method5(){}

}

interface CustomerControl extends Buy, Sell{
    void order();
}

class Customer2 implements CustomerControl{
    @Override public void method1(){}
    @Override public void method5(){}
    @Override public void order(){}

}


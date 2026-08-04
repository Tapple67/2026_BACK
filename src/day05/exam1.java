package day05;


class Book {
  String title;
  // 생성자: 객체 생성 시 전달받은 도서 제목(title)으로 멤버변수(필드)를 초기화합니다.
  Book(String title) { this.title = title; } 
}

public class exam1 {
//제시된 코드에서 총 인스턴스는 몇개 만들어졌고 
//main 함수가 종료되기 전 유효한 인스턴스는 몇 개 이고 몇 개 사라졌을까
public class Main {
  public static void main(String[] args) {
    Book b1 = new Book("Java Basics");   // 1
    Book b2 = new Book("OOP Concepts");  // 2

    Book[] library = new Book[3]; 

    library[0] = b1;
    library[1] = new Book("Data Structure");  //3

    Book b3 = library[1]; 

    b2 = library[0];

    Book[] archive = library;
    archive[2] = new Book("Algorithm");  //4

    library[0] = null;
    b1 = null;   

    // ===== 프로그램 실행 종료 직전 (Final State) =====
    // 제시된 코드에서 총 인스턴스는 몇개 만들어졌고 main함수가 종료 되기 전 유효 한 인스턴스는 몇 개 이고 몇개가 사라졌을까?
    // 인스턴스 5개  유효 3개 종료 1개

    // b1 -> "Java Basics", b2 ->   가 가리킴
    // library[0]이 ->"Java Basics" 를 같이 가리킨다
    //  이 -> "Data Structure" 를 가리킨다 b3 도 같이 가리킨다.
    // 근데 b2가 library[0]을 가리켜서 "Java Basics"  그럼 b2 는 더이상 "OOP Concepts"를 가리키지 않는다
    // library[0] ->"Java Basics" , library[1]이 -> "Data Structure" 그럼  archive도 [0] ,[1]이 "Java Basics" ,"Data Structure" 이케들어감
    // archive[2]에 -> "Algorithm"

    // "Java Basics"   b2 , archive[0]
    // "OOP Concepts"                               b2에서 없어짐
    // "Data Structure"  library[1]  b3 archive[1]
    // "Algorithm"   archive[2]  library[2]

}
}

    
}

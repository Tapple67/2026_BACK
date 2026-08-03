package day01;
import java.util.*;

public class Exam2 {
    //[1]출력함수
 public static void main(String[] args) {

    System.out.println("안녕");

    System.out.print("안녕");

    System.out.println("\n자바 안녕3\t 자바안녕4\"\' \\");

    System.out.printf("저는 %s 이고 나이는 %d 입니다", "유재석",40);

    System.out.printf("\n저는 %s 이고 나이는 %6d 입니다", "유재석",40);

    System.out.printf("\n저는 %s 이고 나이는 %-6d 입니다", "유재석",40);

    System.out.printf("\n저는 %6s 이고 나이는 %06d 입니다", "유재석",40);

    System.out.printf("\n저는 %-6s 이고 점수는 %5.2f 입니다", "유재석", 123.456789);


    Scanner scanner = new Scanner(System.in);

    scanner.next();

    String str = scanner.next();



    System.out.println();

    System.out.println("2) 점수 입력:");
    int i = scanner.nextInt();
    System.out.printf("입력받은 자료:%d", i);

 }
}

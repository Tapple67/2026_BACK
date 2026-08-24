package day14;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Exam2 {
    public static void main(String[] args) {
        //제네릭: 클래스내 타입들을 인스턴스 생성시 정한다.
        /*
            컬렉션(수집)프레임(틀)워크(일)
                -정의: 데이터 수집(목록) 하는 자료구조 (방법) 미리 만들어둔 인터페이스/클래스들
                -목적: 복잡한 자료들을 편리하게 제공받아 사용
                - 종류
                    List 인터페이스 : 구현체: ArrayList,vector,LinkedList,Stack  등
                    set 인터페이스 :  구현체: HashSet, TreeSet  등
                    Map 인터페이스 :  구현체: HashMap, HashTable, TreeMap  등
                    인터페이스? 다중구현, 서로다른 클래스들을 하나의 타입으로 조작
                    구현체란? 인터페이스내 추상메소드 구현한 클래스들을
                    다형성이란? (캐스팅) 하나의 자료가 서로다른 타입으로 변환

        
        */





        //[1] List 인터페이스
        ArrayList<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list2 = new LinkedList<>();
        // list1 = new LinkedList<>(); // 불가능 // 형제끼리 타입 변환 불가능

        //[2] List 인터페이스 타입으로 구현체 메소드 사용가능
        list2.add("유재석");
        System.out.println(list2.get(0));

        //[3] 리스트/배열 과 반복문 관계, // 리스트(목록)내 항목(값)들을 한번에 꺼내기 없다, 하나씩 (순회/반복) 꺼내기
        //1. 일반 for문
        for( int index = 0; index<list2.size(); index++){

        }
        //2. 향상된 for문
        for(String str : list2){System.out.println(str);}

        //3. forEach문 , 반복 메소드, 리스트 객체 ,forEach( (반복변수명) -> {} );
        list2.forEach((str) -> {System.out.println(str);});


        //4. List 구현체 차이 : 사용법(함수/메소드) 동일, 구조적 차이
        //ArrayList : 인덱스 기반의 배열 구조 + 동기화 미지원
        //              [A] [b] [c] [d]     // e 저장한 경우 마지막 뒤에 e 저장
        //               0   1   2   3      // B 삭제한 경우 삭제된 B 이후로 C D 한칸씩 앞으로 이동한다.
        //LinkedList : 링크 [h헤더][d본문][t꼬리] = 노드 기반의 리스트 구조
        //                  
        //Vector: ArrayList 동일한 구조 + 동기화(스레드)지원??














        String a ="AAABBCC";
        
        char[][] chlist2 = new char[3][];
        //문자열 나누기 
        char[] chlist = a.toCharArray(); //list는 문자
        char nowch;
        int count; 
        for(char i : chlist){
            count = 1;
            nowch = i;
            if(nowch == i){
                count ++;
            }
        }
        //처음 값은 배열에 넣고 있으면 count up
        



    }
    
}

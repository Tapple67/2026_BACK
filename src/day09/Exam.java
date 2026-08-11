package day09;

import java.util.ArrayList;

public class Exam {
    public static void main(String[] args) {
        
        /*
        배열 :여러개 (동일한타입)자료들을 저장하는 타입, 정적길이
        ArrayList 클래스:
        1. 컬렉션(수집)




        4.주요메서드
            1.add(자료)  리스트 추가
            2.add(인덱스, 자료) : 리스트 중간삽입
            3.set(인덱스,자료) : 리스트 특정 인덱스 요소 수정
            4.size() : 리스트내 요소 개수 반환
            5.get(인덱스): 리스트 특정인덱스 요소 값 반환
            6.remove(인덱스) : 리스트 특정인덱스 삭제
            7.clear() : 리스트 요소 전체 삭제
            8.indexOf(찾을 값): 리스트내 찾을 값이 존재 하면 인덱스 없으면 -1 반환
            9.contains(찾을 값): 리스트내 찾을 값이 존재하면 true
            10.isempty(): 리스트가 비어있으면 true 아니면 false 반환
        */


        //[1] 리스트 생성
        ArrayList<String> 변수명1 = new ArrayList<>();

        //[2] 리스트 요소 추가
        변수명1.add("유재석");  
        변수명1.add("강호동");  
        변수명1.add("신동엽");  
        //[3] 리스트 전체 출력
        System.out.println(변수명1);

        //[4] 리스트 중간삽입
        변수명1.add(1,"하하");
        System.out.println(변수명1);

        //[5] 리스트 요소 수정
        변수명1.set(1, "서장훈");
        System.out.println(변수명1);

        //[6] 리스트 요소 총개수
        System.out.println(변수명1.size());

        //[7] 리스트 특정 요소 출력
        System.out.println(변수명1.get(1));

        //[8] 리스트 요소 삭제
        변수명1.remove(1);
        System.out.println(변수명1); 

        //[9] 리스트 요소 찾기
        System.out.println(변수명1.indexOf("강호동"));
        System.out.println(변수명1.contains("강호동"));

        //[10] 반복문과 리스트 관계
        // 1. 일반 for문
        for(int i =0; i<변수명1.size(); i++){}
        // 2.향샹된 for문
        for( String str : 변수명1){}
        //[11] 리스트 전체 삭제
        변수명1.clear();
        //[12]
        System.out.println(변수명1.isEmpty());
    }
    
}

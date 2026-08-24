package day14;

import java.util.*;
public class Exam3 {
    public static void main(String[] args) {
        //Set 인터페이스 : 여러개 자료들을 저장하는 컬렉션 , 단 * 중복제거, 인데스(순서) 없다.
        //1. Set 구현
        Set<String> set1 = new HashSet<>();
        //2. Set  .add(추가할값)
        set1.add("유재석");   set1.add("강호동");
        set1.add("유재석"); 
        set1.add(new String("유재석"));
        System.out.println(set1);
        //3. .get(인덱스); 지원불가, 인덱스가 없으니까.
        //set1.get(0);
        //4. .size(); : 항목 개수 반환
        System.out.println( set1.size());
        //6. .remove(자료);
        // set1.remove("유재석");
        //7. .indexOf(찾을값); 지원불가, contains(찾을값)
        // set1.indexOf("강호동");
        //8. .clear() : 항목 전체삭제
        // set1.clear();
        //9. .isEmpty() : 항목이 하나도 없으면 true,false
        set1.isEmpty();
        //10. set 컬렉션과 반복문 관계
        //1. 일반 for문은 사용x ,인덱스가 없어서
        //2. 향샹된 for문 가능
        for(String str: set1){
            System.out.println(str);
        }
        //3. forEach 지원
        set1.forEach((str)->{System.out.println(str);});
        
        //11. TreeSet : 이진트리(자료구조) 이용한 자동 정렬
        TreeSet<Integer> set2 = new TreeSet<>();
        set2.add(50); set2.add(70); set2.add(60);
        System.out.println(set2);  // 기본값이 오름차순
        System.out.println(set2.descendingSet()); // 내림차순

        Iterator<String> list =  set1.iterator( ); //인덱스가 아닌 자료들을 순회하는 인터페이스 반환
        while (list.hasNext()) {
            System.out.println(list.next());
        }

    }
}

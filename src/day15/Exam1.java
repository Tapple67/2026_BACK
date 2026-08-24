package day15;

import java.util.HashMap;
import java.util.Map;

public class Exam1 {
    public static void main(String[] args) {
        /*
        제네릭타입: 클래스


        컬렉션(수집)프레임(틀)워크(일)
                
                    List 인터페이스 : 구현체: ArrayList,vector,LinkedList,Stack  등
                    set 인터페이스 :  구현체: HashSet, TreeSet  등
                    Map 인터페이스 :  Key 중복불가/Value 중복 허용 , 인덱스(순서) 없다, HashMap, TableMap,TableMap, TreeMap
                   


        [1] Map : key와 value 한쌍(엔트리)으로 여러개 쌍(엔트리) 저장하는 구조 = JSON( { } )
        
        
        
        */

        Map<String, Integer> map = new HashMap<>();
        map.put("유재석", 95);
        map.put("강호동", 100);
        map.put("신동엽", 78);
        map.put("유재석", 80);
        System.out.println(map);

        //2) .get(key) : key 해당하는 value 반환
        System.out.println(map.get("강호동"));
        //3) .size() : 총 엔트리 수 반환 
        System.out.println(map.size());
        //4) .containsKey(찾을 key) : 찾을 key 존재하면 true / false
        //   .containsvalue(찾을value)  : 존재하면 true / false
        System.out.println(map.containsKey("강호동"));
        System.out.println(map.containsKey(100));
        //5) .keyset(): 모든 key 반환, .values() 모든 value 반환
        System.out.println(map.keySet());
        System.out.println(map.values());
        //6) .remove( ):해당하는 key의 엔트리(key: value) 삭제
        map.remove("강호동");   System.out.println(map);
        // map.clear(); System.out.println(map);
        //7) isEmpty() : 엔트리가 1개도 없으면 t or f
        System.out.println(map.isEmpty());
        // * 활용처: 1] JSON(JS) <-- 통신 --> DTO/MAP(JAVA) 2]자료구조(암호화) 등등
        //9) 반복문 관계
        //(1) 일반 for문 불가능
        //(2) 향상된for문, KEY
        
        for(String key : map.keySet() ){
            System.out.println(key + ":" + map.get(key));

        }
        //(3) forEach , KEY
        map.keySet().forEach((key)->{ System.out.println(key + ":" + map.get(key)); });
        



    }
}

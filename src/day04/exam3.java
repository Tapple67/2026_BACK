package day04;

import java.util.*;
public class exam3 {
    public static void main(String[] args) {
        
        /*
        자바 배열 *동일한 타입*의 여러 자료들을 순서(인덱스) 대로 저장하는 *타입*
        선언 :
        - 타입[] 변수명 = new 타입명[총개수];   vs let 변수명 =[]
        - 타입[] 변수명 = {초기값 ,초기값, 초기값};   vs let 변수명 =[초기값 ,초기값, 초기값]

        특징 : 1) 동일한타입끼리  2) 고정길이 3) 요소 초기값(자동)
        인덱스 : 요소(자료)들이 저장되는 순서번호, 0번 시작

        
        */

        //배열의 선언
        int[] arry1 = new int[3];  // int형 3개 저장 가능한 배열 선언
        System.out.println(arry1);   //배열의 메모리 주소값 1개
        System.out.println(Arrays.toString(arry1));
        

        String[] arry2 = {"유재석","강호동","신동엽"};

        System.out.println(arry2[0]);
        System.out.println(arry2.length);
        System.out.println(arry2[1]);

        arry2[0] = "유재석2";
        System.out.println(arry2[0]);
        // arry2[3] = "하하";  오류
        // arry2.push("하하"); 오류
        // arry2.splice(0,1);  오류

        /*배열 메모리 : 메모리는 1byte 단위로 저장!
            자바 int 1개 선언 -> 4byte -> [][][][] 4개의 메모리가 컴퓨터 할당
            자바 new int[3] 선언 4byte -> [][][][], [][][][], [][][][] 12개의 할당
            byte 단위별 주소값 정해진다.
            [*101] [102] [103] [104], [201] [202] 
        
        */

            Scanner scan = new Scanner(System.in);

            int[] number = new int[0];
            for(;;){
                System.out.println("현재 배열 [ 크기:" + number.length + "]:" + (number.length==0 ?"비어있음":Arrays.toString(number)));
                System.out.println("1.요소추가 | 2. 인덱스로 삭제 | 0. 종료");
                int num = scan.nextInt();

                if(num == 1){
                    int[] copynumber = Arrays.copyOf(number, number.length+1);
                    System.out.println("추가할 정수 값을 입력하세요");
                    int scannum = scan.nextInt();
            
                    for(int i = 0; i<number.length; i++){
                      copynumber[i] = number[i];
                    }

                    copynumber[number.length] = scannum;

                    number = copynumber;
                    
                    System.out.printf("%d 값이 성공적으로 추가 되었습니다.\n",scannum);



                }else if(num==2){
                    System.out.printf("삭제할 인덱스 번호(0~%d)를 입력하세요",number.length-1);

                    int[] copynumber = Arrays.copyOf(number, number.length-1);

                    int scannum = scan.nextInt();

                    for(int i = 0; i<scannum; i++){
                       copynumber[i] = number[i];
                    }
                    for(int i = scannum; i<copynumber.length; i++){
                       copynumber[i] = number[i+1];
                    }

                    number = copynumber;
                    System.out.printf("%d 값이 성공적으로 삭제 되었습니다.\n",scannum);

                }else if( num ==0){
                    break;
                }else{
                    continue;
                }
            }






    }
    
}

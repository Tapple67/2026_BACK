package day12.종합예제.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import day12.종합예제.controller.BoardController;
import day12.종합예제.model.dto.BoardDto;
public class BoardView {
    private BoardView(){} // 1.
    private static final BoardView instance = new BoardView(); // 2.
    public static BoardView getInstance( ){ return instance; } // 3. 

    // [*] MVC패턴 흐름의 controller 싱글톤 호출
    private BoardController bc = BoardController.getInstance();

    private Scanner scan = new Scanner(System.in);
    public void run(){
        while (true) {
            try { //예외 처리
                System.out.println("1.등록 2. 전체조회 3.개별 수정 4. 개별 삭제 선택:");
                int ch = scan.nextInt();
                if(ch == 1){save();}
                else if(ch==2){findAll();}
                else if(ch==3){update();}
                else if(ch==4){delete();}
            } catch (InputMismatchException e) {
                scan = new Scanner(System.in); // 입력 했지만 타입에서 예외 이므로 입력 객체 초기화
                System.out.println("[다시입력]"+ e);
            }
            
        }
    };

    public void save(){
        System.out.println("내용:"); String 내용 = scan.next();    //저장할 자료 입력
        System.out.println("작성자:"); String 작성자 = scan.next();
        BoardDto boardDto = new BoardDto(0,내용,작성자);  //자료 객체화
        
        boolean result = bc.save(boardDto);

        if (result) {
            System.out.println("등록 성공");
        }else{
            System.out.println("등록 실패");
        }
    }

    public void findAll(){
        ArrayList<BoardDto> result = bc.findAll();
        for (BoardDto dto:result){
            System.out.println( dto.getNo()+" / "+dto.getWriter()+" / " +dto.getContent() );
        }
    }

    public void update( ){
        System.out.print("수정할번호: ");   int 수정할번호 = scan.nextInt();
        System.out.print("수정할내용: ");   String 수정할내용 = scan.next();
        BoardDto boardDto = new BoardDto(수정할번호, 수정할내용, null ); // writer 사용안함.null
        boolean result = bc.update( boardDto );
        if( result ){ System.out.println(">수정 성공"); }
        else{ System.out.println(">수정 실패(없는 번호)"); }
    }


    public void delete( ){
        System.out.print("삭제할번호: ");   int 삭제할번호 = scan.nextInt();


        boolean result = bc.delete( 삭제할번호 );
        if( result ){ System.out.println(">삭제 성공"); }
        else{ System.out.println(">삭제 실패"); }
    }

}  

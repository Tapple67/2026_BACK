package day09.종합예제.view;

import java.util.ArrayList;
import java.util.Scanner;

import day09.종합예제.controller.BoardController;
import day09.종합예제.model.dto.BoardDto;

public class BoardView {
    private BoardView (){}
    private static final BoardView instance = new BoardView();
    public static BoardView getinstance(){ return instance;}
    BoardController bc = BoardController.getInstance();
    Scanner scan = new Scanner(System.in);

    
    //[1] 게시물 작성 입출력 
    public void save(){
        System.out.println("내용");  String 내용 = scan.next();
        System.out.println("작성자");  String 작성자 = scan.next();

        //2.객체화
        BoardDto boardDto = new BoardDto(내용, 작성자);
        boolean result = bc.save(boardDto);

        if(result){System.out.println("등록 성공");}
        else{System.out.println("등록 실패");}

    }


    public void findAll(){
        //1.
        ArrayList<BoardDto> result = bc.findAll();

        for(BoardDto board:result){
            System.out.println(board.getWriter() + ":"+board.getContent());
        }
    }


 public void run(){
        while(true){ // 무한루프
            System.out.print("1.등록 2.전체조회: " );
            int ch = scan.nextInt();
            if( ch == 1 ) { save(); }
            else if( ch == 2 ) { findAll(); }
        }
    }
}

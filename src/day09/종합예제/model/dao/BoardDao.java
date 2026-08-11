package day09.종합예제.model.dao;

import java.util.ArrayList;

import day09.종합예제.model.dto.BoardDto;

public class BoardDao {
    
    private BoardDao (){}
    private static final BoardDao instance = new BoardDao();

    public static BoardDao getInstance() {
        return instance;
    }
    
    //arrayList 사용
    private ArrayList <BoardDto> boardList = new ArrayList<>();


    public boolean save(BoardDto boardDto){
        //1. controller 으로 부터저장할 정보 객체 받는다.
        //c추후에 insert이용한 db 저장
        //2. 
        boardList.add(boardDto);

        return true;
    }

    public ArrayList<BoardDto> findAll(){
        return boardList;
    }
}
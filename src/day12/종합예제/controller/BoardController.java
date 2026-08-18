package day12.종합예제.controller;

import java.util.ArrayList;

import day12.종합예제.model.dao.BoardDao;
import day12.종합예제.model.dto.BoardDto;

public class BoardController {
    private BoardController(){}
    private static final BoardController instance = new BoardController();
    public static BoardController getInstance(){ return instance; }
    //[*] MVC패턴 흐름의 dao 싱글톤 호출
    private BoardDao bd = BoardDao.getInstance();

    public boolean save(BoardDto BoardDto){
        boolean result = bd.save(BoardDto); 
        return result;
    }


    public ArrayList<BoardDto> findAll(){
        return bd.findAll();
    }

    public boolean update(BoardDto boardDto){
        return bd.update(boardDto);
        
    }

    public boolean delete(int 삭제할번호){
        return bd.delete(삭제할번호);
        
    }
}


package day09.종합예제.controller;

import java.util.ArrayList;

import day09.종합예제.model.dao.BoardDao;
import day09.종합예제.model.dto.BoardDto;

public class BoardController {
    private BoardController(){}
    private static final BoardController instance = new BoardController();
    public static BoardController getInstance(){ return instance; }


    private BoardDao bd = BoardDao.getInstance();

    public boolean save(BoardDto boardDto){
        //1.view 으로 부터 저장할 정보 객체로 받는다.
        // 유효성 검사 / 타입 변환등등 
        //2.DAO 에게 요청하고 응답받기
        boolean result = bd.save(boardDto);

        return result;
    }

    public ArrayList<BoardDto> findAll(){
        ArrayList<BoardDto> result = bd.findAll();
        return result;
    }
}


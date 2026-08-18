package day12.종합예제.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import day12.종합예제.model.dto.BoardDto;

public class BoardDao extends BaseDao {
    private BoardDao(){}
    private static final BoardDao instance = new BoardDao();
    public static BoardDao getInstance(){ return instance; }

    public boolean save( BoardDto boardDto){
        
        try {
            String sql = "insert into board(content,writer) values(?,?)";
            //1.2 연동된 데이터베이스에 sql 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            //1.3 기재된 sql문법내 ? (와일드 카드) 매개변수 값 대입
            ps.setString(1, boardDto.getContent());
            ps.setString(2, boardDto.getWriter());
            //1.4 기재된 sql 실행 .executeUpdate() insert/update/delete 에서 사용
            int result = ps.executeUpdate();
            //1.5 sql 결과
            if( result == 1){
                return true;
            } //성공 반환

        } catch (SQLException e) {
            System.out.println(e);
            
        }
        //1.1 등록 sql 작성 , 값에 와일드 카드(?) 이용한 매개변수 대입
        return false;
    }


    public ArrayList<BoardDto> findAll(){
        ArrayList<BoardDto> list = new ArrayList<>();
        try {
            String sql = "select * from board";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) { // rs.next() :다음 레코드로 이동, 마지막 레코드까지 반복
                BoardDto boardDto = new BoardDto();
                boardDto.setNo(rs.getInt("no"));
                boardDto.setContent(rs.getString("content"));
                boardDto.setWriter(rs.getString("writer"));

                list.add(boardDto);

            }
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e);
        }
        return list;
    } 

    public boolean update(BoardDto boardDto){
        try {
            String url = "update board set content = ? where no = ?";
            PreparedStatement ps = conn.prepareStatement(url);
            ps.setString(1, boardDto.getContent());
            ps.setInt(2, boardDto.getNo());

            int result = ps.executeUpdate();
            if(result == 1){ return true;}
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    };


    public boolean delete(int 삭제할번호){
        try {
            String url = "delete from board where no = ?";
            PreparedStatement ps = conn.prepareStatement(url);
            ps.setInt(1, 삭제할번호);
            int result = ps.executeUpdate();
            if (result == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;

        
    };
            
}

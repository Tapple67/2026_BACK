package day12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Exam2 {
    public static void main(String[] args) {
        //JDBC 란? 자바 와 데이터 베이스 연동 제공하는 인터페이스
        // [준비] 프로젝트 lib 폴더에 저장
        //[연동]
        //[1] MYSQL 회사에서 제공하는 Driver 구현체 (동적) 로드 *예외처리 필수*
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("연동 성공");
            
            //[2] 데이터 베이스 서버 연동
            //DriverManager.getConnection("jdbc:mysql://ip번호:3306/데이터베이스명");
            String url = "jdbc:mysql://127.0.0.1:3306/mydb0813";
            String user = "root"; String password = "1324";
            Connection conn = DriverManager.getConnection(url, user, password);

            //[3] 연동된 데이터베이스 내 DML 조작
            //1. insert 하기
            // String sql = "insert into test(name) values('유재석') ";
            // PreparedStatement ps = conn.prepareStatement(sql);
            // //conn(연동된인터페이스).prepareStatement(기재할 sql);
            // //PrepareStatment(sql 기재된 인터페이스)
            // int result = ps.executeUpdate();
            // System.out.println(result);

            //2. select 하기 ,select 필드명 from 테이블 명;
            String sql2 = "select * from test";
            PreparedStatement ps2 =  conn.prepareStatement(sql2); // 작성한 sql 기재
            ResultSet rs =  ps2.executeQuery();  // 기재된 sql 실행, 결과물 rs 인터페이스 대입
            rs.next();
            System.out.println(rs.getInt("no"));
            System.out.println(rs.getString("name"));
            rs.next();
            System.out.println(rs.getInt("no"));
            System.out.println(rs.getString("name"));

            String sql3 = "delete from test";
            PreparedStatement ps3 = conn.prepareStatement(sql3);
            int result3 = ps3.executeUpdate();
            System.out.println(result3);


        }catch(ClassNotFoundException e){
            System.out.println("Driver(클래스) 가 존재하지 않습니다." + e);
        }catch(SQLException e){
            System.out.println("DB 서버와 연동 실패");
        } 
        
        
    }
    
}

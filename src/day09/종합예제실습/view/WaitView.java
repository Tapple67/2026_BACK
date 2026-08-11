package day09.종합예제실습.view;

import java.util.ArrayList;
import java.util.Scanner;

import day09.종합예제실습.controller.WaitController;
import day09.종합예제실습.dto.WaitDto;

public class WaitView {
    private WaitView(){};
    private static final WaitView instance = new WaitView();

    public static WaitView getInstance() {
        return instance;
    }

    Scanner scan = new Scanner(System.in);
    
    private WaitController wc = WaitController.getInstance();
    
    public void run(){
        while(true){ // 무한루프
            System.out.print("1.등록 2.전체조회 3.수정 4.삭제: " );
            int ch = scan.nextInt();
            if( ch == 1 ) { save(); }
            else if( ch == 2 ) { findAll(); }
            else if(ch == 3){waitUpdate();}
            else if(ch == 4){waitDelete();}
        }
    }

    public void save(){
        System.out.println("전화번호 입력:");  String phn = scan.next();
        System.out.println("인원 입력");  int pen = scan.nextInt();
        

        WaitDto waitDto = new WaitDto(phn, pen);
        boolean result = wc.save(waitDto);
        
        if(result){
            System.out.println("등록 성공!");
        }else{
            System.out.println("등록 실패!");

        }
    }

    public void findAll(){
        ArrayList<WaitDto> result = wc.findAll();

        for(WaitDto wait:result){
            System.out.println(wait.getPhoneNum() + ":" + wait.getPeopleNum());
        }
    }

    // public void waitUpdate(){
    //     System.out.println("인덱스 번호 입력:"); int index = scan.nextInt();
    //     System.out.println("전화번호 입력:");  String phn = scan.next();
    //     System.out.println("인원 입력");  int pen = scan.nextInt();

    //     WaitDto waitDto = new WaitDto(phn, pen);
        
    //     boolean result = wc.waitUpdate(index,waitDto);
            
    //     if (result) {
    //         System.out.println("수정 성공");
    //     }else{
    //         System.out.println("수정 실패");

    //     }

    // }


    public void waitUpdate(){
        
        ArrayList<WaitDto> list = wc.findAll();
        System.out.println("전화번호 입력:");  String phn = scan.next();
        boolean result = false;
        for(WaitDto i :list){ 
            if(i.getPhoneNum().equals(phn)){
                System.out.println("인원 입력");  int pen = scan.nextInt();
                WaitDto waitDto = new WaitDto(phn, pen);
                
                result = wc.waitUpdate(waitDto);
                
            }
        }

            
        if (result) {
            System.out.println("수정 성공");
        }else{
            System.out.println("수정 실패");

        }

    }


    public void waitDelete(){
        System.out.println("전화번호 입력:");
        String pn = scan.next();

        boolean result = wc.waitDelete(pn);

        if (result) {
            System.out.println("삭제 성공");
        }else{
            System.out.println("삭제 실패");

        }
    }
}

package day09.종합예제실습.dao;

import java.util.ArrayList;
import java.util.Scanner;

import day09.종합예제실습.dto.WaitDto;

public class WaitDao {
    private WaitDao(){};
    private static final WaitDao instance = new WaitDao();

    public static WaitDao getInstance() {
        return instance;
    }

    ArrayList<WaitDto> arrayList = new ArrayList<>();

    public boolean save(WaitDto waitDto){
        arrayList.add(waitDto);

        return true;
    }

    public ArrayList<WaitDto> findAll(){
        return arrayList;
    }

    // public boolean waitUpdate(int index, WaitDto waitDto){

    //     arrayList.set(index, waitDto);
        
    //     return true;
                
    // }

    public boolean waitUpdate(WaitDto waitDto){

        int index =-1;

        for (int i = 0; i < arrayList.size(); i++) {
            if (waitDto.getPhoneNum().equals(arrayList.get(i).getPhoneNum())) {
                index = i;
                break;
            }
        }

        arrayList.set(index, waitDto);

        return true;
    }


    public boolean waitDelete(String pn){
        Scanner scan =new Scanner(System.in);
        ArrayList<WaitDto> list = findAll();

        for(WaitDto watchPn : list){
            if(watchPn.getPhoneNum().equals(pn)){
                
                list.remove(watchPn);
                return true;

            }
        }
        return false;
    }
}


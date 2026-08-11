package day09.종합예제실습.controller;

import java.util.ArrayList;

import day09.종합예제실습.dao.WaitDao;
import day09.종합예제실습.dto.WaitDto;

public class WaitController {
    private WaitController(){};
    private static final WaitController instance = new WaitController();

    public static WaitController getInstance() {
        return instance;
    }

    private WaitDao wd = WaitDao.getInstance();


    public boolean save(WaitDto waitDto){


        boolean result = wd.save(waitDto);

        return result;
    }

    public ArrayList<WaitDto> findAll(){
        ArrayList<WaitDto> result = wd.findAll();

        return result;
    }


    // public boolean waitUpdate(int index, WaitDto waitDto){
        
    //     boolean result =  wd.waitUpdate(index,waitDto);

    //     return result;
    // }

    public boolean waitUpdate(WaitDto waitDto){
        
        boolean result =  wd.waitUpdate(waitDto);

        return result;
    }

  

    public boolean waitDelete(String pn){
        boolean result =  wd.waitDelete(pn);

        return result;

    }
}


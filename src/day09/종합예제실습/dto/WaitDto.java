package day09.종합예제실습.dto;

public class WaitDto {
    
    String PhoneNum;
    int PeopleNum;

    //생성자
    public WaitDto() {
    }

    public WaitDto(String phoneNum, int peopleNum) {
        PhoneNum = phoneNum;
        PeopleNum = peopleNum;
    }

    //getter and setter
    public String getPhoneNum() {
        return PhoneNum;
    }


    public void setPhoneNum(String phoneNum) {
        PhoneNum = phoneNum;
    }


    public int getPeopleNum() {
        return PeopleNum;
    }


    public void setPeopleNum(int peopleNum) {
        PeopleNum = peopleNum;
    }

    //toString
    @Override
    public String toString() {
        return "WaitDto [PhoneNum=" + PhoneNum + ", PeopleNum=" + PeopleNum + "]";
    }

}

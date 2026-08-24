package practice.java;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class Pr14 {
    public static void main(String[] args) {
        
        String carParkingList = "3,211가6231,202608190930\n8,452하1234,202608171227";
        StringBuilder builder = new StringBuilder();
        builder.append(carParkingList);

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print("1.위치찾기 2.입차 3.출차 선택:");
            int ch = scan.nextInt();
            if( ch == 1 ){findCarLocation(builder);} // 위치찾기 구현 
            if( ch == 2 ){parking(builder); } // 입차 구현 
            if( ch == 3 ){out(builder); } // 출차 구현
        }

       


    
        // [ 문자열 실습 ] 타워 주차 관리 시스템 데이터 처리
        // 1. 문제 개요
        // 주차장 관제 시스템에서 관리 중인 차량 데이터(carParkingList)는 단일 String으로 관리되고 있습니다. 
        // 이 데이터를 기반으로 입차, 출차, 내 차량 위치 찾기 기능을 구현하세요.
        // 단) 새로운 클래스 만들지 않습니다.

        // 2. 데이터 규격
        // 데이터 구분자:
        // 행(객체/차량) 구분: 줄바꿈 문자 (\n)
        // 열(속성) 구분: 쉼표 (,)
        // 컬럼 순서: 위치번호,차량번호,날짜시간(YYYYMMDDhhmm)

        // 초기 데이터 예시:
        // String carParkingList = "3,211가6231,202608190930\n8,452하1234,202608171227";

        // 3. 구현 요구사항
        // 다음 세 기능 구현하세요. 
        // ① 차량 위치 찾기 (findCarLocation)
        // 기능: 차량 번호를 입력받아 현재 주차된 위치 번호를 반환합니다.
        // 입력: carNumber (찾을 차량번호)
        // 출력/반환:
        // 차량이 존재할 경우: 주차 위치 번호 (예: "3")
        // 차량이 없을 경우: "미등록 차량" 또는 -1 반환



        // ② 입차 처리
        // 기능: 새로운 차량의 주차 정보를 기존 데이터에 추가합니다.
        // 조건:
        // 이미 주차되어 있는 위치 번호에는 중복 주차할 수 없습니다
        // 입력: location (위치번호), carNumber (차량번호), dateTime (입차일시)
        // 출력/반환:
        // 차량이 입차한 경우 : 주차 위치 번호 (예: "3")
        // 차량이 입차가 없을 경우: 위치 번호에는 중복 주차할 수 없습니다. (위치 중복 시 입차 불가 메시지 출력)

        // ③ 출차 처리
        // 기능: 출차할 차량 번호를 입력받아 해당 차량의 행을 carParkingList에서 삭제합니다.
        // 입력: carNumber (출차할 차량번호)
        // 반환: 해당 차량이 제거되고 줄바꿈이 올바르게 정리된 갱신된 carParkingList 문자열
        // 기본 정책: 최초 30분 무료추가 요금: 30분 초과 시, 10분당 1,000원 (10분 단위 절상/올림 계산)
        // 예: 31분 ~ 40분 주차 -> 1,000원   
        // 예: 41분 ~ 50분 주차 -> 2,000원
        // 일일 최대 요금: 24시간(1일)당 최대 20,000원여러 날에 걸쳐 주차한 경우, 
        // 각 일자 단위로 계산 후 합산하거나 총 일수×20,000원 + 잔여시간 요금(최대 20,000원)을 적용합니다.

    

        
    }
    public static int findCarLocation(StringBuilder list){
        Scanner sc = new Scanner(System.in);
         //스플릿으로 나누기
        String[] carlist = list.toString().split("\n");

        System.out.println(Arrays.toString(carlist));

        
        //차번호 입력받아 배열과 비교
        System.out.println("차 번호 입력:");
        String car = sc.next();

        for(String i : carlist){
            if(i.contains(car)){
                String[] loca = i.split(",");
                System.out.println(loca[0]);
                return Integer.parseInt(loca[0]);
            }
        }

        return -1;
    }



    public static void parking(StringBuilder builder){
        String[] carlist = builder.toString().split("\n");
        String[][] locarlist = new String[carlist.length][];
        boolean bo = true;

        for(int i = 0; i<carlist.length; i++){
           locarlist[i] = carlist[i].split(",");
        }
        System.out.println(Arrays.deepToString(locarlist));

        
        //데이터 입력
        Scanner sc = new Scanner(System.in);
        System.out.println("위치번호:");  String location = sc.next();
        System.out.println("차량번호:");  String carNumber = sc.next();
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");

        //주차위치번호 검사
        for(int i = 0; i<locarlist.length; i++){
            
            if(locarlist[i][0].equals(location)){
                System.out.println("주차 위치 번호 :"+ location);
                String result = "\n"+location+","+carNumber+","+localDateTime.format(formatter);

                builder.append(result);
                
            }else{
                
                System.out.println("위치 번호에는 중복 주차할 수 없습니다.");
            }
        }
        
    }

    public static void out(StringBuilder builder){
        Scanner scan = new Scanner(System.in);
         // [Scanner.next()] 출차할 차량번호 문자열 입력받음
                String carNumber = scan.next();
                for( String car : builder.toString().split("\n") ){
                    // [String.equals(Object)] 빈 문자열 여부 확인
                    if( car.equals( "" ) ) break;
                    
                    // [String.split(String regex)] 쉼표(,) 기준으로 파싱
                    String[] info = car.split(",");
                    
                    // [String.equals(Object)] 출차할 차량번호와 일치하는지 비교
                    if( info[1].equals( carNumber ) ){
                        // [String.substring(int beginIndex, int endIndex)] 시작 위치부터 끝 위치 전까지의 부분 문자열 추출
                        // [Integer.parseInt(String s)] 숫자 형식의 문자열을 기본형 정수(int)로 파싱하여 반환
                        int year = Integer.parseInt( info[2].substring( 0 , 4 ) );      
                        int month = Integer.parseInt( info[2].substring( 4 , 6 ));   
                        int day = Integer.parseInt( info[2].substring( 6 , 8 ));       
                        int hur = Integer.parseInt( info[2].substring( 8 , 10 ));      
                        int min = Integer.parseInt( info[2].substring( 10 , 12 ));      
                        
                        // [LocalDateTime.of(int year, int month, int dayOfMonth, int hour, int minute)] 지정된 연, 월, 일, 시, 분으로 LocalDateTime 객체 생성
                        LocalDateTime inTime = LocalDateTime.of(year, month, day, hur, min ); // 주차시간 
                        
                        // [LocalDateTime.now()] 시스템의 현재 날짜와 시간 정보를 가진 LocalDateTime 객체 반환
                        LocalDateTime now = LocalDateTime.now(); // 현재시간
                        
                        // 연/월이 같은 단순 일자 차이 기준
                        // [LocalDateTime.getYear()] 연도(int) 반환
                        // [LocalDateTime.getDayOfYear()] 해당 연도의 몇 번째 날인지(1~366, int) 반환
                        int inTotalDays = (inTime.getYear() * 365) + inTime.getDayOfYear();
                        int nowTotalDays = (now.getYear() * 365) + now.getDayOfYear();
                        int diffDays = nowTotalDays - inTotalDays;
                        
                        // 분 차이 기준
                        // [LocalDateTime.getHour()] 시간(0~23, int) 반환
                        // [LocalDateTime.getMinute()] 분(0~59, int) 반환
                        int inMinutesOfDay = (inTime.getHour() * 60) + inTime.getMinute();
                        int nowMinutesOfDay = (now.getHour() * 60) + now.getMinute();
                        
                        // 차이난 일수의 분과 분 차이 합계
                        int totalMinutes = (diffDays * 24 * 60) + (nowMinutesOfDay - inMinutesOfDay);
                        if( totalMinutes < 0 ) totalMinutes = 0;
                        
                        // 3. 요금 계산 (일자 단위 + 잔여 분)
                        int days = totalMinutes / (24 * 60);          // 일수
                        int remainMinutes = totalMinutes % (24 * 60); // 일수 제외한 분(나머지)
                        int remainFee = 0;
                        if (remainMinutes > 30) {
                            int billableMinutes = remainMinutes - 30;
                            remainFee = ((billableMinutes + 9) / 10) * 1000; // 10분 단위 올림
                        }
                        if (remainFee > 20000) {
                            remainFee = 20000; // 일 최대 20,000원 캡
                        }
                        int totalFee = (days * 20000) + remainFee; // 일별 추가 요금.
                        
                        // [PrintStream.println(String / Object)] 각 출력 라인별 정보 출력 및 줄바꿈
                        System.out.println("====== 출차 안내 ======");
                        System.out.println("차량번호: " + carNumber);
                        System.out.println("입차시간: " + inTime); // LocalDateTime.toString() 형태 출력
                        System.out.println("출차시간: " + now);    // LocalDateTime.toString() 형태 출력
                        System.out.println("주차시간: " + totalMinutes + "분 (" + days + "일 " + remainMinutes + "분)");
                        System.out.println("주차요금: " + totalFee + "원");
                        System.out.println("=====================");
                        
                        // 차량정보 제거
                        // [String.replace(CharSequence target, CharSequence replacement)] 대상 문자열 내의 일치하는 모든 하위 문자열을 치환(여기서는 제거)하여 새로운 String 반환
                        // 차량정보 제거
                        int startIndex = builder.indexOf(car);

                        if (startIndex != -1) {
                            int endIndex = startIndex + car.length();

                            // 행 뒤쪽에 줄바꿈이 있으면 같이 삭제
                            if (endIndex < builder.length()
                                    && builder.charAt(endIndex) == '\n') {
                                endIndex++;
                            }
                            // 마지막 행이라 뒤에 줄바꿈이 없다면 앞의 줄바꿈 삭제
                            else if (startIndex > 0
                                    && builder.charAt(startIndex - 1) == '\n') {
                                startIndex--;
                            }

                            builder.delete(startIndex, endIndex);
                        }

                        break;
                    }
                }
            } // 출차 구현
       
        

    }



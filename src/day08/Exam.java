package day08;


class User{
    //1. apaqjqustn = 상태 = private 사용
    private String name;
    private int age;    
    //2.생성자 = 초기화
    //3. 메소드 = 행위
    // - private 메소드에대한 간접 접근 메소드
    //setter , getter, set 멤버변수, get멤버변수
    //setter, getter, set 멤버변수, get 멤버변수
    //getter 존재하면 V(value)O(object) 읽기모드
    //setter/getter 존재하면 D(data)T(transfer)O(object) 일기
    public void setName( String name){
        if(name.length()<1){return;}
        this.name =name;
    }

    public String getName(){
        return this.name;
        
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", age=" + age + "]";
    }
    //DTO: 1.관례적으로 멤버 변수 모두 private
    //     2.setter/getter 제공한다.
    //     3.toString 제공한다
    //     4.생성자에 기본생성자1개, 전체매개변수1개 -> 2개
    //MVC 패턴 소규모가 아닌 체계적인 (약속) 규모 필요할때 클래스 역할나누기/ AI에이전트->역할
    /*
        V: VIEW 입출력 담당             HTML/CSS/JS/REACT/FLUTER
        C: controller 제어(백/프) 중계      JAVA/PYTHON/NODE.JS
        M: Model 데이터 담당
        1인 식당 운영: 사장이 서빙-요리-재료관리
        n인 식당 운영: 서빙담당자 - 요리담당자 - 재료담당자
    */
}

public class Exam {
    public static void main(String[] args) {


        User u1 = new User();

        System.out.println(u1.toString());







    }
}

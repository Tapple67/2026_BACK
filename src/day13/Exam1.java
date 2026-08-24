package day13;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Exam1 {
    public static void main(String[] args) {
        

        //1.
        String obj1 = new String(); Class c1 =obj1.getClass();
        System.out.println(c1);
        
        //2. Class.forName("패키지명.클래스명"), 일반예외 필수
        // *** 리플렉션 *** : 최초실행(컴파일)할때 해당 클래스의 객체를 로드/생성 하지 않고 실행 도중에 객체 동적 생성
        try {
            Class.forName("java.lang.String");
        } catch (Exception e) {
            System.out.println(e);
        }
        
        //3. .getFields 클래스내 멤버변수 정보 반환
        Field[] fields = c1.getFields();
        for(Field field : fields){
            System.out.println(field);
        }

        //4. .getConstructors() : 클래스내 생성자 정보 반환
        Constructor[] constructors = c1.getConstructors();
        for( Constructor constructor : constructors){System.out.println(constructor);}

        //5. .getMethods() : 클래스내 메소드 정보반환
        Method[] methods = c1.getMethods();
        for(Method method : methods){
            System.out.println(method);
        }
    }
    
}

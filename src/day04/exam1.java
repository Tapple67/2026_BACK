package day04;

public class exam1 {
    public static void main(String[] args) {
        

        int grade = 1;
        int adult = 1;

        switch (grade) {
            case 'A':
                switch (adult) {
                    case 1:System.out.println("zz");
                    case 0: System.out.println("zz");  
                
                    default:
                        break;
                }
                break;
        
            default:
                break;
        }


        for (int i = 0; i < 10; i++){

        }





        int[] ary = {92, 80, 75};
        for(int j =0; j < ary.length; j++){
            System.out.println(ary[j]);
        }

        for (int data : ary){
            System.out.println(data);
        }








    }




}

package day06;

import java.util.Scanner;

public class OverallControllerTest {
    
    public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);

        Post[] posts = new Post[100];

        
       


    for(;;){
            System.out.println("==========================");
            System.out.println("1.게시글 쓰기 2.게시물 출력");
            System.out.println("==========================");

            System.out.println("입력 >");
            int num = scan.nextInt();

        if(num==1){
            scan.nextLine();
            System.out.println("내용 입력:");
            String content = scan.nextLine();
            System.out.println("게시자:");
            String writer = scan.nextLine();

            Post post = new Post(content,writer);
            boolean tf =false;

        

                for(int i = 0; i<posts.length; i++){
                    if(posts[i]==null){
                        posts[i]=post;
                        tf = true;
                        break;
                    }
                }

                if(tf){
                    System.out.println("성공적으로 등록");
                }else{
                    System.out.println("등록 실패");
                }

                }else if(num ==2){


                for(Post i:posts){
                    if(i != null){
                        System.out.printf("게시글: %s 게시자:%s\n",i.content,i.writer);
                    }
                }
            }
        }
    }
}

class Post{
    String content;
    String writer;
    public Post() {
    }

    public Post(String content, String writer) {
        this.content = content;
        this.writer = writer;
    }

}

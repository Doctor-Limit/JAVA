package Day01;

/*

多行注释不可嵌套使用
看到一个与其匹配的即认为结束

*/


import Day09.Man;

/**
 文本注释
 javadoc -d 新文件夹名称 -author -version 源java程序
 @author Delll
 @version  v2.0
 this is my first java;

 */

 public class Hello {
    public static void main(String args[]){

//System.out.println("Hello World!");
//int m=12,n=12;
//String max=m>n?"m大":(m==n?"m与n相等":"n大"); //三元运算符的嵌套使用
//System.out.println(max);

        int count=0;
        for (int i = 2; i < 230; i++) {
            boolean b=true;
            for (int j = 2; j < i; j++) {
                if (i%j==0){
                    b=false;
                    break;
                }
            }
            if (b){
                count++;
                System.out.print(i+"\t");
                if (count%10==0){
                    System.out.println();
                }
            }
        }




    }

}

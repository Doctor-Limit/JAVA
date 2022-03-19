package Day03;


import java.util.Scanner;

//[a,b] (int)(Math.random*(b-a+1)+10)
//a.equals("b") 判定字符串a中的内容是否相同，相同则返回真
public class TEXT {

    public static void main(String args[]){









    }



    public static void main4(String args[]){
        Scanner scanner=new Scanner(System.in);
        int n=0,y=0;
        double input=0,output=0,money=1000;
        String details=" ",result=" ",memory=" ";//字符串直接相连实现显示多次结果
       boolean x=true;

   label:   do{
    System.out.println("*******系统收支记账******");
    System.out.println("    1.收支明细");
    System.out.println("    2.登记收入");
    System.out.println("    3.登记支出");
    System.out.println("    4.退出");

    do{
        n=scanner.nextInt();
    if(n>4||n<1)System.out.print("输入有误，请重新输入:");}
    while(n>4||n<1);
    switch (n) {
        case 1:System.out.print("收支  \t");
            System.out.print("账户金额  \t");
            System.out.print("收发金额  \t");
            System.out.println("说明  \t");
           System.out.print(memory);
            break ;
        case 2:System.out.println("请登记输入：");
         input=scanner.nextDouble();
        System.out.println("请输入明细：");
        details=scanner.next();
        money+=input;
        result="收入";
        memory+=("收入\t"+money+"\t"+input+"\t"+details+"\n");
        break;
        case 3:System.out.println("请登记支出：");
            output=scanner.nextDouble();
            if(money>=output)money-=output;
            else System.out.println("账户可用额度不足，支付失败");
            result="支出";
            System.out.println("请输入明细：");
            details=scanner.next();
            memory+=("支出\t"+money+"\t"+output+"\t"+details+"\n");
            break;
        case 4:
           do{ System.out.println("是否确认退出<y/n>,1代表yes，0代表n");
               y=scanner.nextInt();
               if(y!=0&&y!=1) System.out.println("请重新输入：");
         }while (y!=0&&y!=1);
      x=y==1?false:true;
      break ;
    }
}while(x);

    }
    public static void main3(String args[]){
        int count=0;
        double start=System.currentTimeMillis(); //获取当前时间距1970-01-01的时间差（ms）

        label:    for(int i=2;i<=10000;i++){
            boolean isFlag=true;
            for(int j=2;j<=Math.sqrt(i);j++){
                if(i%j==0){
                   continue  label;
                }
            }
            if(isFlag==true){
                System.out.println(i);
                count++;}
        }
        double end=System.currentTimeMillis();
        System.out.println("质数个数为："+count);
        System.out.println("所花费时间为:"+(end-start));

    }
    public static void main2(String args[]){
double start=System.currentTimeMillis(); //获取当前时间距1970-01-01的时间差（ms）

label:    for(int i=2;i<=10000;i++){
    boolean isFlag=true;
    for(int j=2;j<=Math.sqrt(i);j++){
        if(i%j==0){
            isFlag=false;
           break; //默认跳出最近的一层循环 Math.sqrt(i)那层
            // break label  跳出指定标识的循环
            //continue label 同理，结束指定标识的当前循环然后执行下一次循环
        }
    }
    if(isFlag==true){System.out.println(i);}

}
double end=System.currentTimeMillis();
System.out.println("所花费时间为:"+(end-start));

    }
    public static void main1(String args[]){
        int random=(int)(Math.random()*90+10); //random默认区间[0.0,1.0)
        System.out.println("请输入一个两位数：");
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        int x=random/10,y=random%10,m=t/10,n=t%10;
        if(x==m&&y==n){System.out.println("奖金10000");}
        else if(x==n&&y==m){System.out.println("奖金3000");}
        else if((x==m&&y!=n)||(y==n&&x!=m)){System.out.println("奖金1000");}
        else if((x==n&&y!=m)||(y==m&&x!=n)){System.out.println("奖金500");}
        else System.out.println("抱歉未中奖");
        System.out.println(random);
    }

}

import java.util.Scanner;

public class A {
//       public static void main(String args[]){
//           char x='你',y='e',z='吃';
//           if(x>'A'){
//               y='苹';
//               z='果';
//           }
//           else y='酸';
//           z='甜';
//           System.out.println(x+","+y+","+z);
//       }
//    public static void main(String args[]){
//        char c='\0';
//        for(int i=1;i<=4;i++){
//            switch(i){
//                case 1:c='J';
//                System.out.println(c);
//                case 2:c='e';
//                System.out.println(c);
//                    break;
//                case 3:c='p';
//                System.out.println(c);
//                default: System.out.print("好");
//            }
//
//        }
//
//}
static int sum(int n){
    int x=n;
    int temp=0;
    for(int i=1;i<=x;i++){
        temp=temp+i;
    }
    return temp;
}


    static int factorial(int n) {
        int c=0;
        if(n<=0) System.out.println("输入有误");
        if(n==1) c=1;
        if(n>1) c=n*factorial(n-1);
        return c;
    }


    public static void main(String args[]) {
       int temp=0;
       for(int i=1;i<=10;i++){
           temp=factorial(i)+temp;
       }
       System.out.println(temp);
//    }
//        double temp = 0.0;
//        for (int i = 1; i <= 20; i++) {
//           temp=temp+1.0/factorial(i);
//        }

//        int j=1,temp1=0;
//        do{
//            temp=temp+1.0/factorial(j);
//            j++;
//        }while(j<=20);
//        System.out.println(temp);

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






//        for(int i=2;i<1000;i++){
//            int sum=0;
//            for(int j=1;j<i;j++){
//                if(i%j==0) sum+=j;
//            }
//            if(i==sum)System.out.println(sum);
//        }

//        public static void main(String args[]){
//            Scanner scanner=new Scanner(System.in);
//            int n=scanner.nextInt();
//            int i,j;
//            for(i=1;i<=n;i++){
//                for(j=1;j<=n-i;j++){
//                    System.out.print(" ");
//                }
//                int temp=i;
//                while(temp!=0){
//                    System.out.print(temp--);
//                }
//                for(int x=temp+2;x<=i;x++){
//                    System.out.print(x);
//                }
//                System.out.println();
//            }
//        }


//        int a=8,b=a;
//        for(int i=0;i<=10;i++){
//            temp=temp+b;
//          b=b*10+a;
//        }
//        System.out.println(temp);

for(int n=1;;n++) {
    if (sum(n) < 8888 && sum(n + 1) > 8888)
    { System.out.println(n);
        break;}
else continue;
}
    }

}

package Day02;

// 或运算同理 一个或运算符第一个为真时执行第二条语句 两个或运算符第一个为真就跳过第二条语句
//字符串.equals(array[i]) 判断array[i]中的元素是否与字符串相等
public class Test {
    public static void main(String args[]){

        for(int i=1;i<1000;i++){
            int temp=0;
            for(int j=1;j<=i/2;j++){
                if(i%j==0) temp+=j;
            }
            if(temp==i)System.out.println(i);
        }

    }

    public static void main1(String args[]) {
        boolean a1=false;
        int num1=12;
        if(a1&(num1++)>0){  //只有一个与运算符时，若第一个结果为假依旧执行第二条语句
            System.out.println("北京");
        }
        else System.out.println("南京");
        System.out.println(num1);
        boolean a2=false;
        int num2=12;
        if(a1&&(num2++)>0){  //存在两个与运算符时，第一个若为假则不执行第二条语句
            System.out.println("北京");
        }
        else System.out.println("南京");
        System.out.println(num2);

        boolean b1=true;
        int num3=12;
        if(a1&(num3++)>0){  //只有一个与运算符时，若第一个结果为假依旧执行第二条语句
            System.out.println("北京");
        }
        else System.out.println("南京");
        System.out.println(num3);
        boolean b2=true;
        int num4=12;
        if(a1&&(num4++)>0){  //存在两个与运算符时，第一个若为假则不执行第二条语句
            System.out.println("北京");
        }
        else System.out.println("南京");
        System.out.println(num4);

    }

}

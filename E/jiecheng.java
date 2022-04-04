public class jiecheng {
    static int factorial(int n) {
        int c=0;
        if(n<=0) System.out.println("输入有误");
        if(n==1) c=1;
        if(n>1) c=n*factorial(n-1);
        return c;
    }
    public static void main(String[] args) {
        int temp=0;
        for(int i=1;i<=10;i++){
            temp=factorial(i)+temp;
        }
        System.out.println(temp);
    }
}


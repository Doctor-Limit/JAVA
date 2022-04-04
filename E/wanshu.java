public class wanshu {
    public static void main(String[] args) {
                for(int i=2;i<1000;i++){
            int sum=0;
            for(int j=1;j<i;j++){
                if(i%j==0) sum+=j;
            }
            if(i==sum)System.out.println(sum);
        }
    }
}

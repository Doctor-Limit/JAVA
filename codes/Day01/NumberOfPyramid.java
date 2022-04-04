package Day01;
import java.util.Scanner;
public class NumberOfPyramid {
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int i,j;
      for(i=1;i<=n;i++){
          for(j=1;j<=n-i;j++){
              System.out.print(" ");
          }
        int temp=i;
          while(temp!=0){
              System.out.print(temp--);
          }
      for(int x=temp+2;x<=i;x++){
          System.out.print(x);
      }
          System.out.println();
         }
      }
    }


package Work1.Day01;
class Point_1{
    int x,y;
    void SetXY(int a,int b){
        x=a;
        y=b;
    }
}

public class Example4_4 {
    public static void main(String[] args) {
        Point_1 p1=null;
        Point_1 p2=null;
        p1=new Point_1();
        p2=new Point_1();
        System.out.println("p1�����ã�"+p1);
        System.out.println("p2������"+p2);
        p1.SetXY(1111,2222);
        p2.SetXY(-100,-200);
        System.out.println("p1��x,y���꣺"+p1.x+","+p1.y);
        System.out.println("p2��x,y���꣺"+p2.x+","+p2.y);
        p1=p2;
        System.out.println("��p2�����ø���p1��");
        int address=System.identityHashCode(p2);
        System.out.printf("p1�����ã�%x\n",address);
         address=System.identityHashCode(p1);
        System.out.printf("p2������:%X\n",address);
        System.out.println("p1��x,y���꣺"+p1.x+","+p1.y);
        System.out.println("p2��x,y����:"+p2.x+","+p2.y);

    }
}

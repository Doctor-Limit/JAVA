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
        System.out.println("p1的引用："+p1);
        System.out.println("p2的引用"+p2);
        p1.SetXY(1111,2222);
        p2.SetXY(-100,-200);
        System.out.println("p1的x,y坐标："+p1.x+","+p1.y);
        System.out.println("p2的x,y坐标："+p2.x+","+p2.y);
        p1=p2;
        System.out.println("将p2的引用赋给p1后：");
        int address=System.identityHashCode(p2);
        System.out.printf("p1的引用：%x\n",address);
         address=System.identityHashCode(p1);
        System.out.printf("p2的引用:%X\n",address);
        System.out.println("p1的x,y坐标："+p1.x+","+p1.y);
        System.out.println("p2的x,y坐标:"+p2.x+","+p2.y);

    }
}

package Work1.Day02.Example4_13;

public class test {
    public static void main(String[] args) {
        Circle circle=new Circle();
        circle.setRadius(196.87);
        TiXing ladder=new TiXing(3,21,9);
        Student zhang=new Student();
        System.out.println("zhang����Բ�������");
        double result= zhang.computerArea(circle);
        System.out.println(result);
        System.out.println("zhang�������ε������");
        result= zhang.computerArea(ladder);
        System.out.println(result);

    }
}

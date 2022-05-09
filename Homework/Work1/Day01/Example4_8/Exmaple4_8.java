package Work1.Day01.Example4_8;

public class Exmaple4_8 {
    public static void main(String[] args) {
        Circle circle=new Circle();
        circle.setRadius(10);
        Circular circular=new Circular();
        System.out.println("circle的引用："+circle);
        System.out.println("圆锥bottom的引用："+circular.bottom);
        circular.setHeight(5);
        circular.setBottom(circle);
        System.out.println("circle的引用："+circle);
        System.out.println("圆锥bottom的引用："+circular.bottom);
        System.out.println("圆锥的体积："+circular.getVolume());
        System.out.println("修改circle的半径，bottom的半径同样变化");
        circle.setRadius(20);
        System.out.println("botttom的半径："+circular.getBottomRadius());
        System.out.println("重新创建circle，circle的引用将发生变化");
        circle=new Circle();
        System.out.println("circle的引用"+circle);
        System.out.println("但不影响circular的bottom引用");
        System.out.println("圆锥bottom的引用："+circular.bottom);
    }
}

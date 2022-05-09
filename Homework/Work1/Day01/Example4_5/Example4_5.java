package Work1.Day01.Example4_5;

public class Example4_5 {
    public static void main(String[] args) {
        Rect rect=new Rect();
        rect.width=109.87;
        rect.height=25.18;
        double area=rect.getArea();
        System.out.println("矩形的面积为："+area);
        Ladder ladder=new Ladder();
        ladder.above=10.798;
        ladder.bottom=156.65;
        ladder.height=18.12;
        area=ladder.getArea();
        System.out.println("梯形的面积："+area);
    }
}

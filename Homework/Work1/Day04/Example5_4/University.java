package Work1.Day04.Example5_4;

/**
 * ********概述：
 */
public class University {
    void enterRule(double math,double english,double chinese){
        double total=math+english+chinese;
        if(total>=180) System.out.println("达到大学录取线");
        else System.out.println("未达到大学录取线");
    }
}

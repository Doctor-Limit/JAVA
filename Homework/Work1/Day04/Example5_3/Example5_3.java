package Work1.Day04.Example5_3;

/**
 * ********概述：
 */
public class Example5_3 {
    public static void main(String[] args) {
        CheapGoods cheapGoods=new CheapGoods();
        cheapGoods.newSetWeight(198);
        System.out.println("对象cheapGoods的weight的值是："+cheapGoods.weight);
        System.out.println("cheapGoods用子类新增的优惠方法计算价格："+cheapGoods.newGetPrice());
        cheapGoods.oldSetWeight(198.987);
        System.out.println("cheapGoods使用继承的方法(无优惠)计算价格："+cheapGoods.oldGetPrice());
    }
}

package Work1.Day04.Example5_3;

/**
 * ********概述：
 */
public class CheapGoods extends Goods{
    public int weight;
    public void newSetWeight(int w){
        weight=w;
        System.out.println("int型的weight="+weight);
    }
    public double newGetPrice(){
        double price=weight*10;
        return price;
    }
}

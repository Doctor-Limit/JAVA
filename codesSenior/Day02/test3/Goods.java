package Day02.test3;

/**
 * ********概述：
 */
public class Goods implements Comparable{
     private String name;
     private double price;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
    public Goods(){
    }
    public Goods(String name,double price){
        this.name=name;
        this.price=price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Goods){
            Goods goods=(Goods) o;
            if(this.price>goods.price){
                return 1;
            }else if(this.price<goods.price){
                return -1;
            }else return this.name.compareTo(goods.name);
            // return 0;

          //  return Double.compare(this.price,goods.price);等价于
        }
        throw new RuntimeException("传入数据类型不一致");
    }
}

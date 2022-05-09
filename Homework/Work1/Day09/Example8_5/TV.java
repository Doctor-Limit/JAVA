package Work1.Day09.Example8_5;

/**
 * ********概述：
 */
public class TV {
    double price;

    public void setPrice(double m) {
        this.price = m;
    }

    @Override
    public String toString() {
        String oldStr = super.toString();
        return oldStr + "\n这是电视机，价格是:" + price;
    }
}

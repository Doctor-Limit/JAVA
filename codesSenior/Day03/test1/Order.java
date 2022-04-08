package Day03.test1;

/**
 * ********概述：
 */
public class Order<T>{

    String orderName;
    int orderId;

    //类的内部结构使用类的泛型
    T orderT;

    public Order(){
    }
    public Order(String orderName,int orderId,T orderT){
        this.orderId=orderId;
        this.orderName=orderName;
        this.orderT=orderT;
    }
    public T getOrderT(){
        return orderT;
    }
    public void setOrderT(T orderT){
        this.orderT=orderT;
    }



}

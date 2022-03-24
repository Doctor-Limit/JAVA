package Day10.test3;

class Order{
    private int orderId;
    private String orderName;

    public int getOrderId(){
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
    public String getOrderName() {
        return orderName;
    }
    public Order(){
    }
   public Order(int orderId,String orderName){ //权限修饰符+类名即可
        super();
        this.orderId=orderId;
        this.orderName=orderName;
   }
   public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(obj instanceof Order){
            Order order=(Order)obj;

            return this.orderId==order.orderId&&
                    this.orderName.equals(order.orderName);
        }
        return false;
   }
}
public class OrderTest {
    public static void main(String[] args) {
         Order order1=new Order(1001,"AA");
         Order order2=new Order(1002,"BB");
         System.out.println(order1.equals(order2));

         Order order3=new Order(1002,"BB");
         System.out.println(order2.equals(order3));



    }
}

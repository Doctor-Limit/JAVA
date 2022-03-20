package Day05;

public class CustomerList {
    private Customer[] customers; //保存客户数组
    private int total=0;//记录已保存客户对象数量

    public CustomerList(int totalCustomer){ //动态分配客户数量
        customers=new Customer[totalCustomer];
    }
    public boolean addCustomer(Customer customer){ //将指定客户添加至数组中
        if(total>=customers.length) return false; //当已保存客户数量超过总长度时，会添加失败
        customers[total++]=customer;
        return true;
    }
    public boolean replaceCustomer(int index,Customer cust){
        if(index<0||index>=total) return false;
        customers[index]=cust;
        return true;
    }
    public boolean deleteCustomer(int index){
        if(index<0||index>=total)return false;
        for(int i=index;i<total-1;i++){
            customers[i]=customers[i+1];
        }
        customers[--total]=null; //删除index位置，index后的数据往前移动，将原最后一位设置为null
        return true;
    }
    public Customer[] getAllCustomers(){
        Customer[] custs=new Customer[total];
        for(int i=0;i<total;i++){
            custs[i]=customers[i]; //只需要查看已保存的即可，后面的空的不显示
        }
        return custs;
    }
    public Customer getCustomer(int index){ //获取指定位置客户
        if(index<0||index>=total) return null;
        return customers[index];
    }
    public int getTotal(){ //获取存储客户数量
        return total;
    }
}

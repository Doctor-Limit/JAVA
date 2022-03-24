package Day10.test2;

import Day05.Customer;

public class Test1 {
    @Override
    public boolean equals(Object obj) {
       if(this==obj){ //若两者地址相同，则内容必定相同
           return true;
       }
       if(obj instanceof Customer){
           Customer cust=(Customer)obj;
           //比较变量的每个属性是否相同
           //return this.name==cust.name&&this.name.equals(cust.name);
       }
       return false;
    }

}

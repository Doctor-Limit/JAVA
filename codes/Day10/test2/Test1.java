package Day10.test2;

import Day05.Customer;

public class Test1 {
    @Override
    public boolean equals(Object obj) {
       if(this==obj){ //�����ߵ�ַ��ͬ�������ݱض���ͬ
           return true;
       }
       if(obj instanceof Customer){
           Customer cust=(Customer)obj;
           //�Ƚϱ�����ÿ�������Ƿ���ͬ
           //return this.name==cust.name&&this.name.equals(cust.name);
       }
       return false;
    }

}

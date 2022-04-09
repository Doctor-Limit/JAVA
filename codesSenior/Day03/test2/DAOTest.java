package Day03.test2;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * ********概述：
 */
public class DAOTest {

    @Test
    public void test1(){
        CustomerDAO c1=new CustomerDAO();
        c1.add(new Customer());
        List<Customer> list=c1.getForList(10);
    }

}

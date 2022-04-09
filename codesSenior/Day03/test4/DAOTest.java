package Day03.test4;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ********概述：
 */
public class DAOTest {
    public static void main(String[] args) {

        DAO<User> u1=new DAO<>();
        u1.setMap(new HashMap<>());
        u1.save("001",new User("1001",34,1));
        u1.save("002",new User("1002",33,2));
        u1.save("003",new User("1003",32,3));
        u1.save("004",new User("1004",31,4));

        u1.update("004",new User("1005",30,5));
        u1.delete("001");

        List<User> list=u1.list();
        list.forEach(System.out::println);

    }
}

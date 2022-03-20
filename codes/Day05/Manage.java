package Day05;

import java.util.Scanner;
import java.util.logging.XMLFormatter;

public class Manage {

private CustomerList customerList=new CustomerList(10); //定义长度为10的客户数组
Scanner scanner=new Scanner(System.in);
    public Manage(){
        Customer customer=new Customer("张三","男",27,"15364782984","3563@qq.com");
        customerList.addCustomer(customer);
    }
    public void view(){
            System.out.println("      客户信息管理系统");
            System.out.println("        1、添加客户");
            System.out.println("        2、修改客户");
            System.out.println("        3、删除客户");
            System.out.println("        4、客户列表");
            System.out.println("        5、退出");
            System.out.print("        请选择1-5：");
    }
    public void addNewCustomer(){
    System.out.println("------------添加客户--------");
    System.out.print("姓名：");
    String name=scanner.next();
    System.out.print("性别：");
    String sex=scanner.next();
    System.out.print("年龄:");
    int age=scanner.nextInt();
    System.out.print("电话：");
    String phone=scanner.next();
    System.out.print("邮箱:");
    String email=scanner.next();

    //将上述对象封装到对象中
        Customer customer=new Customer(name,sex,age,phone,email);
        boolean isSucess=customerList.addCustomer(customer);
        if(isSucess) System.out.println("添加成功");
        else System.out.println("客户目录已满，添加失败");
    }

    private void modifyCustomer(){
    System.out.println("------------修改客户-----------");
    boolean x=true;
    Customer cust;
    int number;
    do{
         System.out.println("请选择修改客户编号(-1退出)");
        number=scanner.nextInt();
        if(number==-1) return;
        cust=customerList.getCustomer(number-1);
        if(cust==null) System.out.println("无法找到指定客户");
        else break;
    }while(x);
    System.out.print("姓名（"+cust.getName()+"):");
    String name=scanner.next();
    System.out.print("性别("+cust.getSex()+"):");
    String sex=scanner.next();
    System.out.print("年龄("+cust.getAge()+"):");
    int age=scanner.nextInt();
    System.out.print("电话("+cust.getPhone()+"):");
    String phone=scanner.next();
    System.out.print("邮箱("+cust.getEmail()+"):");
    String email=scanner.next();

   Customer newCust=new Customer(name,sex,age,phone,email);
   boolean isReplaced=customerList.replaceCustomer(number-1,newCust);
   if(isReplaced) System.out.println("---修改成功---");
   else System.out.println("-----修改失败-------");
    }
    private void deleteCustomer(){
      System.out.println("-------删除客户-------");
      int number;
      for(;;){
          System.out.println("请输入删除客户编号(-1退出):");
          number=scanner.nextInt();
          if(number==-1) return;
          Customer customer=customerList.getCustomer(number-1);
          if(customer==null) System.out.println("无法找到指定客户");
          else break;
      }
      int y=0;
       System.out.println("是否确认删除<y/n>,1代表yes，0代表n");
            y=scanner.nextInt();
       if(y==1) {
           boolean deleteSucess=customerList.deleteCustomer(number-1);
       if(deleteSucess) System.out.println("删除成功");
       else System.out.println("删除失败");
       }
    }
    private void listCustomers(){
       System.out.println("----------客户列表------------\n");
       int total=customerList.getTotal();
       if(total==0) System.out.println("无客户记录");
       else  {
           System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t\t\t邮箱");
           Customer[] custs= customerList.getAllCustomers();
           for(int i=0;i<custs.length;i++){
               System.out.println(i+1+"\t"+custs[i].getName()+ //换行时+在最右边
                       "\t"+custs[i].getSex()+"\t"+custs[i].getAge()+"\t"+
                       custs[i].getPhone()+"\t\t\t"+custs[i].getEmail());
           }
       }
       System.out.println("-----------客户列表完成-----------");
    }
    public static void main(String args[]){
        Manage view=new Manage(); //若非静态方法，通过创建新对象来调用方法
        Scanner scanner=new Scanner(System.in);
        int y=0;
        boolean isFlag=true;
        int selection =0;
        do{
        do{
            view.view();
            selection=scanner.nextInt();
            if(selection<1||selection>5) System.out.println("输入有误，请重新输入：");
        }while(selection<1||selection>5);

        switch (selection){
            case 1:view.addNewCustomer();break;
            case 2:view.modifyCustomer();break;
            case 3:view.deleteCustomer();break;
            case 4: view.listCustomers();break;
            case 5:
                do{
                    if(y!=0&&y!=1) System.out.print("请重新输入：");
                    System.out.println("是否确认退出<y/n>,1代表yes，0代表n");
                y=scanner.nextInt();
            }while (y!=0&&y!=1);
                isFlag=y==1?false:true;
        }
      }while (isFlag);
    }
}

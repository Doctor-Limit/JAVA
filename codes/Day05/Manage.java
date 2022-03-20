package Day05;

import java.util.Scanner;

public class Manage {

private CustomerList customerList=new CustomerList(10); //定义长度为10的客户数组

    public void view(){
        boolean isFlag=true;
        while (isFlag) {
            System.out.println("      客户信息管理系统");
            System.out.println("        1、添加客户");
            System.out.println("        2、修改客户");
            System.out.println("        3、删除客户");
            System.out.println("        4、客户列表");
            System.out.println("        5、退出");
            System.out.print("        请选择1-5：");

        }

    }
    private void addNewCustomer(){

    }
    private void modifyCustomer(){

    }
    private void deleteCustomer(){

    }
    private void listCustomers(){

    }
    public static void main(String args[]){
        Manage view=new Manage(); //若非静态方法，通过创建新对象来调用方法
        Scanner scanner=new Scanner(System.in);

        int selection =0;
        do{
            view.view();
            selection=scanner.nextInt();
            if(selection<1||selection>5) System.out.println("输入有误，请重新输入：");
        }while(selection<1||selection>5);

        switch (selection){
            case 1:

            case 2:
            case 3:
            case 4:
            case 5:
                int y=0;
                do{ System.out.println("是否确认退出<y/n>,1代表yes，0代表n");
                y=scanner.nextInt();
                if(y!=0&&y!=1) System.out.println("请重新输入：");
            }while (y!=0&&y!=1);



        }


    }
}

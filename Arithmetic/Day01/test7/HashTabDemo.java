package Day01.test7;

import java.util.Scanner;

/**
 * ********概述：哈希表的使用
 */
public class HashTabDemo {
    public static void main(String[] args) {
        // 创建哈希表
        HashTab hashTab = new HashTab(7);

        // 写一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("add:添加雇员");
            System.out.println("list:显示雇员");
            System.out.println("exit:退出系统");
            System.out.println("find:查找雇员");
            System.out.println("delete:删除雇员");
            System.out.print("请输入要执行的操作:");
            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入雇员ID");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    // 创建雇员
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list" :
                    hashTab.list();break;
                case "delete":
                    System.out.println("请输入要删除的雇员ID:");
                    id = scanner.nextInt();
                    hashTab.deleteById(id);break;
                case "exit" :
                    scanner.close();
                    System.exit(0);//强制退出系统
                case "find":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                default:
                    System.out.println("输入有误，请重新输入:");
                    break;
            }
        }
    }
}

// 创建hash表
class HashTab {
    private EmpLinkedList[] empLinkedListArray;
    private int size;

    public HashTab(int size) {
        this.size = size;
        // 初始化链表
        empLinkedListArray = new EmpLinkedList[size];// 此时链表里面默认为null，无法使用
        // 需要分别初始化每个链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    public void add(Emp emp) {
        // 根据员工id得到该员工应当添加的位置
        int empLinkedListNo = hashFun(emp.id);
        // 将emp添加到对应的链表中
        empLinkedListArray[empLinkedListNo].add(emp);
    }

    // 编写散列函数，使用一个简单去模法
    public int hashFun(int id) {
        return id % size;
    }
    // 遍历所有的链表，遍历hashtab
    public void list() {
        System.out.println();
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].List(i);
        }
    }

    // 根据输入的ID查找雇员
    public void findEmpById(int id) {
        int empLinkedListNo = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNo].findEmpById(id);
        if (emp != null) {
            System.out.printf("在第%d条链表找到雇员id=%d\n",(empLinkedListNo + 1),id);
        }else {
            System.out.println("未找到该雇员");
        }
    }
    // 根据输入的id删除雇员
    public void deleteById(int id){
        int empLinkedListNo = hashFun(id);
        empLinkedListArray[empLinkedListNo].deleteById(id);
    }
}

// 表示一个成员
class Emp {
    public int id;
    public String name;
    public Emp next;
    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

// 创建EmpLinkedList，表示链表
class EmpLinkedList {
    // 头指针，因此这个链表的head指向第一个head
    private Emp head;// 默认null

    // 添加成员到链表
    // 假定id是自增长，故直接将该雇员直接添加至链表的末尾
    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }
        // 若不是第一个雇员，则使用辅助指针，辅助定位到最后
        Emp curEmp = head;
        while (true) {
            if (curEmp.next == null) { // 说明找到了最后
                break;
            }
            curEmp = curEmp.next;
        }
        // 退出时将emp加入链表
        curEmp.next = emp;
    }

    // 遍历链表的雇员信息
    public void List(int no) {
        if (head == null) {
            System.out.println("第"+(no+1)+"条链表为空");
            return;
        }
        System.out.print("第"+(no+1)+"链表信息为：");
        Emp curEmp = head;// 辅助指针
        while (true) {
            if (curEmp == null) {
                break;
            }
            System.out.printf("=>id=%d name=%s\t", curEmp.id, curEmp.name);
            curEmp = curEmp.next;
        }
        System.out.println();
    }

    // 根据ID查找雇员  找到返回Emp，未找到返回null
    public Emp findEmpById(int id) {
        // 判断链表是否为空
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        // 辅助指针
        Emp curEmp = head;
        while (true) {
            if(curEmp.next == null) {
               return null;
            }
            if (curEmp.id == id) {
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }

    // 根据id删除成员
    public void deleteById(int id) {
       if (head == null) {
           System.out.println("链表为空，无法删除");
           return;
       }
       if (head.id == id) {
           System.out.println("删除成功");
           head = null;
           return;
       }
       Emp curEmp = head;
       boolean flag = false;
       while (true) {
           if (curEmp.next == null) {
               break;
           }
           if (curEmp.next.id == id) {
               flag = true;
               break;
           }
           curEmp = curEmp.next;
       }
       if (flag) {
           curEmp.next = curEmp.next.next;
       }else {
           System.out.printf("要删除的%d号id不存在", id);
       }

    }
}


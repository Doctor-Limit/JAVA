package Project3.View;

import Project3.Domain.*;
import Project3.Service.*;

public class TeamView {
    private NameListService listService=new NameListService();
    private TeamService service=new TeamService();

    public void enterMainMenu(){
        boolean loopFlag=true;
        char menu=0;
        while (loopFlag){
            if(menu!='1'){
            listAllEmployees();
            }
            System.out.print("1-团队列表 2-添加团员 3-删除团队成员 4-退出");
            menu=TSUtility.readMenuSelection();
            switch (menu){
                case '1':getTeam();break;
                case '2':addMember();break;
                case '3':deleteMember();break;
                case '4':System.out.print("确认是否退出<Y/N>:");
               char isExit=TSUtility.readConfirmSelection();
                if(isExit=='Y') loopFlag=false;
                break;
            }
        }
    }
    //显示所有员工信息
    public void listAllEmployees(){
      System.out.println("--------------------------公司成员列表-----------------\n");
        Employee[] employees=listService.getAllEmployees();
        if(employees==null||employees.length==0){
            System.out.println("公司中无员工信息");
        }
        else{
            System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t配套设备");
            for(int i=0;i<employees.length;i++){
                System.out.println(employees[i]);
            }
        }
        System.out.println("----------------------------------------------------");
    }

    public void getTeam(){
       // System.out.println("查看开发团队成员");
        System.out.println("--------------团队成员列表-----------");
        Programmer[] team=service.getTeam();
        if(team==null||team.length==0){
            System.out.println("无团队成员");
        }else{
            System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票\n");
            for(int i=0;i<team.length;i++){
                System.out.println(team[i].getDetailsForTeam());
            }
        }
    }
    public void addMember(){
   //  System.out.println("添加团队成员");
        System.out.println("-------------添加成员------------");
        System.out.print("请输入要添加的员工ID：");
        int id=TSUtility.readInt();
        try{
            Employee emp=listService.getEmployee(id);
            service.addMember(emp);
            System.out.println("添加成功");
        }catch (TeamException e){
           System.out.println("添加失败，原因："+e.getMessage());
        }
        TSUtility.readReturn();
    }

    public void deleteMember(){
      //System.out.println("删除团队成员");
        System.out.println("----------------删除员工---------------");
        System.out.println("输入要删除的员工ID：");
        int memberId=TSUtility.readInt();
        System.out.println("确认是否删除：<Y/N>");
        char isDelete=TSUtility.readConfirmSelection();
        if(isDelete=='N')return;
        try{
           service.removeMember(memberId);
           System.out.println("添加成功");
        }catch (TeamException e){
            System.out.println("删除失败，原因："+e.getMessage());
        }
        TSUtility.readReturn();
    }
    public static void main(String[] args) {
        TeamView view=new TeamView();
        view.enterMainMenu();

    }
}

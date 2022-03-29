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
            System.out.print("1-�Ŷ��б� 2-�����Ա 3-ɾ���Ŷӳ�Ա 4-�˳�");
            menu=TSUtility.readMenuSelection();
            switch (menu){
                case '1':getTeam();break;
                case '2':addMember();break;
                case '3':deleteMember();break;
                case '4':System.out.print("ȷ���Ƿ��˳�<Y/N>:");
               char isExit=TSUtility.readConfirmSelection();
                if(isExit=='Y') loopFlag=false;
                break;
            }
        }
    }
    //��ʾ����Ա����Ϣ
    public void listAllEmployees(){
      System.out.println("--------------------------��˾��Ա�б�-----------------\n");
        Employee[] employees=listService.getAllEmployees();
        if(employees==null||employees.length==0){
            System.out.println("��˾����Ա����Ϣ");
        }
        else{
            System.out.println("ID\t����\t����\t����\tְλ\t״̬\t����\t��Ʊ\t�����豸");
            for(int i=0;i<employees.length;i++){
                System.out.println(employees[i]);
            }
        }
        System.out.println("----------------------------------------------------");
    }

    public void getTeam(){
       // System.out.println("�鿴�����Ŷӳ�Ա");
        System.out.println("--------------�Ŷӳ�Ա�б�-----------");
        Programmer[] team=service.getTeam();
        if(team==null||team.length==0){
            System.out.println("���Ŷӳ�Ա");
        }else{
            System.out.println("TID/ID\t����\t����\t����\tְλ\t����\t��Ʊ\n");
            for(int i=0;i<team.length;i++){
                System.out.println(team[i].getDetailsForTeam());
            }
        }
    }
    public void addMember(){
   //  System.out.println("����Ŷӳ�Ա");
        System.out.println("-------------��ӳ�Ա------------");
        System.out.print("������Ҫ��ӵ�Ա��ID��");
        int id=TSUtility.readInt();
        try{
            Employee emp=listService.getEmployee(id);
            service.addMember(emp);
            System.out.println("��ӳɹ�");
        }catch (TeamException e){
           System.out.println("���ʧ�ܣ�ԭ��"+e.getMessage());
        }
        TSUtility.readReturn();
    }

    public void deleteMember(){
      //System.out.println("ɾ���Ŷӳ�Ա");
        System.out.println("----------------ɾ��Ա��---------------");
        System.out.println("����Ҫɾ����Ա��ID��");
        int memberId=TSUtility.readInt();
        System.out.println("ȷ���Ƿ�ɾ����<Y/N>");
        char isDelete=TSUtility.readConfirmSelection();
        if(isDelete=='N')return;
        try{
           service.removeMember(memberId);
           System.out.println("��ӳɹ�");
        }catch (TeamException e){
            System.out.println("ɾ��ʧ�ܣ�ԭ��"+e.getMessage());
        }
        TSUtility.readReturn();
    }
    public static void main(String[] args) {
        TeamView view=new TeamView();
        view.enterMainMenu();

    }
}

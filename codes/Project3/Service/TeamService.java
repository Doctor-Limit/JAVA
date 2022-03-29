package Project3.Service;

import Project3.Domain.Architect;
import Project3.Domain.Designer;
import Project3.Domain.Employee;
import Project3.Domain.Programmer;

//队伍成员的管理
public class TeamService {
    private static int counter=1; //给memberId赋值
    private final int MAX_MEMBER=5;//限制最大人数
    private Programmer[] team=new Programmer[MAX_MEMBER];//开发团队人数
    private int total;//当前实际团队人数
    public TeamService(){
    }
    //获取开发团队成员
    public Programmer[] getTeam() {
        Programmer[] team=new Programmer[total];
        for(int i=0;i<team.length;i++){
            team[i]=this.team[i];
        }
        return team;
    }
    //添加指定员工
    public void addMember(Employee e)throws TeamException{
         //成员已满，无法添加
        if(total>=MAX_MEMBER)throw new TeamException("成员已满，无法添加");
         //该成员不是开发人员，无法添加
        if(!(e instanceof Programmer)) throw new TeamException("不是开发人员，无法添加");
        //该员工已在开发团队中
        if(isExist(e))throw new TeamException("该成员已在开发团队中");
        //该员工已是某团队成员
        //该员工正在休假，无法添加
        Programmer p=(Programmer) e;
        if("BUSY".equals(p.getStatus().getNAME())) throw new TeamException("已是某团队成员");
        else if("VOCATION".equals(p.getStatus().getNAME())) throw new TeamException("该成员正在休假");
        //团队中至多一名架构师
        //团队中至多两名设计师
        //团队中至多三明程序员
         int numOfArch=0,numOfDes=0,numOfPro=0;
         for(int i=0;i<total;i++){
             if(team[i] instanceof Architect) numOfArch++;
             else if(team[i] instanceof Designer) numOfDes++;
             else if(team[i] instanceof Programmer)numOfPro++;
         }
         if(p instanceof Architect){
             if(numOfArch>=1)throw new TeamException("至多一名架构师");
         }
         else if(p instanceof Designer){
             if(numOfDes>=2)throw new TeamException("至多两名设计师");
         }
         else if(p instanceof Programmer){
             if(numOfPro>=3)throw new TeamException("至多三名架构师");
         }
         //前面都不满足
         team[total++]=p;
         //更改属性
        p.setStatus(Status.Busy);
        p.setMemberId(counter++);
    }
    //团队中删除成员
    public void removeMember(int memberId) throws TeamException{
        int i;
           for( i=0;i<total;i++){
               if(team[i].getMemberId()==memberId){
                 team[i].setStatus(Status.FREE);
                 break;
               }
           }
        if(i==total) throw new TeamException("找不到指定员工，删除失败");
           for(int j=i+1;j<total;j++){
               team[j-1]=team[j];//后一个元素覆盖前一个元素实现删除
           }
           team[--total]=null;

    }
    public boolean isExist(Employee e){
        for(int i=0;i<total;i++){
            if(e.getId()==team[i].getId()) return true;
        }
        return false;
    }
}

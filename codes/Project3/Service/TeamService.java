package Project3.Service;

import Project3.Domain.Architect;
import Project3.Domain.Designer;
import Project3.Domain.Employee;
import Project3.Domain.Programmer;

//�����Ա�Ĺ���
public class TeamService {
    private static int counter=1; //��memberId��ֵ
    private final int MAX_MEMBER=5;//�����������
    private Programmer[] team=new Programmer[MAX_MEMBER];//�����Ŷ�����
    private int total;//��ǰʵ���Ŷ�����
    public TeamService(){
    }
    //��ȡ�����Ŷӳ�Ա
    public Programmer[] getTeam() {
        Programmer[] team=new Programmer[total];
        for(int i=0;i<team.length;i++){
            team[i]=this.team[i];
        }
        return team;
    }
    //���ָ��Ա��
    public void addMember(Employee e)throws TeamException{
         //��Ա�������޷����
        if(total>=MAX_MEMBER)throw new TeamException("��Ա�������޷����");
         //�ó�Ա���ǿ�����Ա���޷����
        if(!(e instanceof Programmer)) throw new TeamException("���ǿ�����Ա���޷����");
        //��Ա�����ڿ����Ŷ���
        if(isExist(e))throw new TeamException("�ó�Ա���ڿ����Ŷ���");
        //��Ա������ĳ�Ŷӳ�Ա
        //��Ա�������ݼ٣��޷����
        Programmer p=(Programmer) e;
        if("BUSY".equals(p.getStatus().getNAME())) throw new TeamException("����ĳ�Ŷӳ�Ա");
        else if("VOCATION".equals(p.getStatus().getNAME())) throw new TeamException("�ó�Ա�����ݼ�");
        //�Ŷ�������һ���ܹ�ʦ
        //�Ŷ��������������ʦ
        //�Ŷ���������������Ա
         int numOfArch=0,numOfDes=0,numOfPro=0;
         for(int i=0;i<total;i++){
             if(team[i] instanceof Architect) numOfArch++;
             else if(team[i] instanceof Designer) numOfDes++;
             else if(team[i] instanceof Programmer)numOfPro++;
         }
         if(p instanceof Architect){
             if(numOfArch>=1)throw new TeamException("����һ���ܹ�ʦ");
         }
         else if(p instanceof Designer){
             if(numOfDes>=2)throw new TeamException("�����������ʦ");
         }
         else if(p instanceof Programmer){
             if(numOfPro>=3)throw new TeamException("���������ܹ�ʦ");
         }
         //ǰ�涼������
         team[total++]=p;
         //��������
        p.setStatus(Status.Busy);
        p.setMemberId(counter++);
    }
    //�Ŷ���ɾ����Ա
    public void removeMember(int memberId) throws TeamException{
        int i;
           for( i=0;i<total;i++){
               if(team[i].getMemberId()==memberId){
                 team[i].setStatus(Status.FREE);
                 break;
               }
           }
        if(i==total) throw new TeamException("�Ҳ���ָ��Ա����ɾ��ʧ��");
           for(int j=i+1;j<total;j++){
               team[j-1]=team[j];//��һ��Ԫ�ظ���ǰһ��Ԫ��ʵ��ɾ��
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

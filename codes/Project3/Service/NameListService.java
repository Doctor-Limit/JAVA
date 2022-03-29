package Project3.Service;

import Project3.Domain.*;

import static Project3.Service.Data.*;


public class NameListService {
    private Employee[] employees;

    public NameListService(){
        //给数组及数组元素进行初始化
        employees=new Employee[EMPLOYEES.length];

        for(int i=0;i<employees.length;i++){
            int type=Integer.parseInt(EMPLOYEES[i][0]);//将数组类型转化为int
            //获取最父类的基本信息
            int id=Integer.parseInt(EMPLOYEES[i][1]);
            String name=EMPLOYEES[i][2];
            int age=Integer.parseInt(EMPLOYEES[i][3]);
            double salary=Double.parseDouble(EMPLOYEES[i][4]);
            Equipment equipment;
            double bonus,stock;

            switch (type){
                case EMPLOYEE :employees[i]=new Employee(id,name,age,salary);break;
                case PROGRAMMER:
                  equipment=createEquipment(i);
                    employees[i]=new Programmer(id,name,age,salary,equipment);break;
                case DESIGNER: equipment=createEquipment(i);
                    bonus=Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i]=new Designer(id,name,age,salary,equipment,bonus);
                    break;
                case ARCHITECT: equipment=createEquipment(i);
                    bonus=Double.parseDouble(EMPLOYEES[i][5]);
                    stock=Double.parseDouble(EMPLOYEES[i][6]);
                    employees[i]=new Architect(id,name,age,salary,equipment,bonus,stock);
                    break;
            }
        }
    }
    //根据后面数组的首端判断设备类型
    private Equipment createEquipment(int index){
       int type=Integer.parseInt(EQUIPMENTS[index][0]);
       String model=EQUIPMENTS[index][1];
        switch (type){
            case PC :String display=EQUIPMENTS[index][2];
            return new Printer(model,display);
            case NOTEBOOK:double price=Double.parseDouble(EQUIPMENTS[index][2]);
            return new NoteBook(model,price);
            case PRINTER:
                return new Printer(EMPLOYEES[index][1],EQUIPMENTS[index][2]);
        }
        return null;
    }
    //获取当前所有员工
    public Employee[] getAllEmployees() {
        return employees;
    }
    public Employee getEmployee(int id) throws TeamException {//在主界面进行操作，方法内只将其抛出
        for(int i=0;i<employees.length;i++){
            if(employees[i].getId()==id)
                return employees[id-1];
        }
       throw new TeamException("未找到指定员工");
    }

}

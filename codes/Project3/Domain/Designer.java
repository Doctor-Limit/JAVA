package Project3.Domain;

public class Designer extends Programmer{
    private double reward;

    public double getReward() {
        return reward;
    }

    public void setReward(double reward) {
        this.reward = reward;
    }
    public Designer(){
    }
    public Designer(int id,String name,int age,double salary,double reward){
        super(id, name, age, salary);
        this.reward=reward;
    }
}

package Project3.Domain;

public class Architect extends Designer {
    private double stock;

    public double getStock() {
        return stock;
    }
    public void setStock(double stock) {
        this.stock = stock;
    }
    public Architect(){
    }
    public Architect(int id,String name,int age,double salary,double reward,double stock){
        super(id, name, age, salary, reward);
        this.stock=stock;
    }
}

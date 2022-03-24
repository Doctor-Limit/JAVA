package Day11.test1;

public class GemoetricObject {
       protected String color;
       protected  double weight;
       public GemoetricObject(){
           this.color="white";
           weight=1.0;
       }
       public GemoetricObject(String color,double weight){
           this.color=color;
           this.weight=weight;
       }
    public double getWeight() {
        return weight;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

}

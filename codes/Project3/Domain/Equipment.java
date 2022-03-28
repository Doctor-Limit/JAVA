package Project3.Domain;

public interface Equipment {
       String getDescription();
}
class PC implements Equipment{

    private String model;
    private String display;

    public String getDisplay() {
        return display;
    }
    public String getModel() {
        return model;
    }
    public void setDisplay(String display) {
        this.display = display;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public PC(){
    }
    public PC(String model,String display){
        this.model=model;
        this.display=display;
    }

    @Override
    public String getDescription() {
        return ""+model+""+display+"";
    }
}
class NoteBook implements Equipment{

    private String model;
    private double price;

    public void setModel(String model) {
        this.model = model;
    }
    public String getModel() {
        return model;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public NoteBook(){
    }
    public NoteBook(String model,double price){
        this.model=model;
        this.price=price;
    }
    @Override
    public String getDescription() {
        return ""+model+price+"";
    }
}
class Printer implements Equipment{

    private String name;
    private String type;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Printer(){
    }
    public Printer(String name,String type){
        this.name=name;
        this.type=type;
    }

    @Override
    public String getDescription() {
        return ""+name+type+"";
    }
}
package Project3.Domain;

 public class NoteBook implements Equipment {

    private String model;//»úÆ÷ÐÍºÅ
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

    public NoteBook() {
    }

    public NoteBook(String model, double price) {
        this.model = model;
        this.price = price;
    }

    @Override
    public String getDescription() {
        return model + "(" + price + ")";
    }
}

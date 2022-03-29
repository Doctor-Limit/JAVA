package Project3.Domain;

public class PC implements Equipment {

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

    public PC() {
    }

    public PC(String model, String display) {
        this.model = model;
        this.display = display;
    }

    @Override
    public String getDescription() {
        return model + "(" + display + ")";
    }
}

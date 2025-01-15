package Model;

public class Medikamente {
    private String name;
    private double price;
    private String krankheit;

    public Medikamente(String name, double price, String krankheit) {
        this.name = name;
        this.price = price;
        this.krankheit = krankheit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getKrankheit() {
        return krankheit;
    }

    public void setKrankheit(String krankheit) {
        this.krankheit = krankheit;
    }
}

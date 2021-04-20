package helpotus;

import java.util.*;

public class Ruokalistaus {

    private String date;
    private String food;
    private int quantity;

    public Ruokalistaus(String date, String food, int quantity) {
        this.date = date;
        this.food = food;
        this.quantity = quantity;
    }

    public Ruokalistaus(String date, String food) {
        this.date = date;
        this.food = food;
        this.quantity = 1;
    }

    public String getFood() {
        return this.food;
    }

    public String getDate() {
        return this.date;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void addQuantity() {
        this.quantity++;
    }

    public void addQuantity(int plus) {
        this.quantity = this.quantity + plus;
    }

    @Override
    public String toString() {
        return "Pvm:" + date + ", ruoka-aine:" + this.food;
    }

}

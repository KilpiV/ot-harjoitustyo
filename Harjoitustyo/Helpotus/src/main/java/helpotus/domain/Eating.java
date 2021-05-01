package helpotus.domain;

/**
 * Lisättävää ruokailua kuvaava luokka
 */

public class Eating {

    private String date;
    private String food;
//    private int quantity;
    private User user;
//
//    public Eating(String date, String food, int quantity, User user) {
//        this.date = date;
//        this.food = food;
//        this.quantity = quantity;
//        this.user = user;
//    }

    public Eating(String date, String food, User user) {
        this.date = date;
        this.food = food;
//        this.quantity = 1;
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

    public String getFood() {
        return this.food;
    }

    public String getDate() {
        return this.date;
    }

//    public int getQuantity() {
//        return this.quantity;
//    }
//
//    public void addQuantity() {
//        this.quantity++;
//    }
//
//    public void addQuantity(int plus) {
//        this.quantity = this.quantity + plus;
//    }

    @Override
    public String toString() {
        return "Pvm:" + date + ", ruoka-aine:" + this.food;
    }

}

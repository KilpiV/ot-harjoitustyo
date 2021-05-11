package helpotus.domain;

/**
 * Lisättävää ruokailua kuvaava luokka.
 */
public class Eating {

    private String date;
    private String food;
    private User user;

    /**
     * Konstruktori, jolla uusi ruokailu luodaan.
     *
     * @param date päiväys
     * @param food lisättävä ruoka
     * @param user kirjautunut käyttäjä
     */
    public Eating(String date, String food, User user) {
        this.date = date;
        this.food = food;
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

    @Override
    public String toString() {
        return "Pvm:" + date + ", ruoka-aine:" + this.food;
    }

}

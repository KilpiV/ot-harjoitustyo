package helpotus.domain;

import java.util.*;
import helpotus.dao.UserDao;
import helpotus.dao.EatingDao;

/**
 * Luokka, joka vastaa sovelluslogiikasta.
 */
public class FoodListings {

    private EatingDao eatingDao;
    private UserDao userDao;
    private User loggedIn;

    /**
     * Konstruktori, jolla luodaan sovelluslogiikasta vastaava listausolio.
     *
     * @param eatingDao ruokailurajapinnan omaava olio
     * @param userDao käyttäjärajapinnan omaava olio
     */
    public FoodListings(EatingDao eatingDao, UserDao userDao) {
        this.eatingDao = eatingDao;
        this.userDao = userDao;
        this.loggedIn = null;
    }

    /**
     * Uuden ruokailun lisääminen käyttäjälle, joka on kirjautuneena sisään.
     *
     * @param date Lisättävän ruokailun päivämäärä
     * @param food Lisättävä ruokailu/ruoka
     *
     * @return true, jos virhettä ei tapahtunut lisäystä tehdessä
     */
    public boolean createEating(String date, String food) {
        Eating eating = new Eating(date, food, loggedIn);
        try {
            eatingDao.create(eating);
        } catch (Exception ee) {
            return false;
        }
        return true;
    }

    /**
     * Kirjautuneen käyttäjän, valitun päivän ruokailut.
     *
     * @param date Kysytyn ruokailun päivämäärä
     *
     * @return Lista ruokailuista kyseiseltä päivältä
     */
    public List<Eating> getDated(String date) {
        if (this.loggedIn == null) {
            return new ArrayList<>();
        }
        List<Eating> dated = eatingDao.getDateAll(date);
        ArrayList<Eating> collected = new ArrayList<>();
        for (int i = 0; i < dated.size(); i++) {
            if (dated.get(i).getUser().getUsername().equals(this.loggedIn.getUsername())) {
                collected.add(dated.get(i));
            }
        }
        return collected;
    }

    /**
     * Sisäänkirjautuminen.
     *
     * @param username käyttäjätunnus
     * @return true jos käyttäjätunnus löytyy, muuten false
     */
    public boolean login(String username) {
        User user = userDao.findByUsername(username);
        if (user == null) {
            return false;
        }
        loggedIn = user;

        return true;
    }

    /**
     * Käyttäjä, joka on kirjautuneena.
     *
     * @return käyttäjä joka on kirjautuneena
     */
    public User getLoggedUser() {
        return loggedIn;
    }

    /**
     * Uloskirjautuminen.
     */
    public void logout() {
        loggedIn = null;
    }

    /**
     * Uuden käyttäjän luominen.
     *
     * @param username käyttäjätunnus
     *
     * @return true jos uusi käyttäjätunnus on luotu onnistuneesti, muuten false
     */
    public boolean createUser(String username) {
        if (userDao.findByUsername(username) != null) {
            return false;
        }
        User user = new User(username);
        try {
            userDao.create(user);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}

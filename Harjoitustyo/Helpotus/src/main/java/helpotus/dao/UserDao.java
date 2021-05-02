package helpotus.dao;

import helpotus.domain.User;
import java.util.*;

/**
 * Rajapinta käyttäjille.
 */
public interface UserDao {

    /**
     * Metodi, jolla luodaan uusi käyttäjä tallennettavaksi.
     * 
     * @param user käyttäjä
     * @return user kyseisen käyttäjän
     * @throws Exception jos lisäys ei onnistu oikein
     */
    User create(User user) throws Exception;

    /**
     * Metodi, joka hakee käyttäjän käyttäjänimen perusteella.
     * 
     * @param username käyttäjänimi
     * @return user käyttäjä
     */
    User findByUsername(String username);

    /**
     * Metodi, joka antaa listan kaikista käyttääjistä.
     * 
     * @return lista käyttäjistä
     */
    List<User> getAll();

}

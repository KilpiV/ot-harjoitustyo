package helpotus.dao;

import java.util.*;
import helpotus.domain.Eating;

/**
 * Rajapinta ruokailuille.
 */
public interface EatingDao {

    /**
     * Metodi, jolla luodaan uusi ruokailu tallennettavaksi.
     *
     * @param eating ruokailu
     * @return eating kyseisen ruokailun
     * @throws Exception jos lisäys ei onnistu oikein
     */
    Eating create(Eating eating) throws Exception;

    /**
     * Metodi joka hakee kaikki listatut ruokailut.
     *
     * @return lista ruokailuista
     */
    List<Eating> getAll();

    /**
     * Metodi joka hakee listalta tietyn päivän ruokailut.
     *
     * @param date päiväys
     * @return lista tietyn päivän ruokailuista
     */
    List<Eating> getDateAll(String date);
}

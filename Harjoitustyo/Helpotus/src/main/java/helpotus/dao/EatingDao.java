package helpotus.dao;

import java.util.*;
import helpotus.domain.Eating;

public interface EatingDao {

    Eating create(Eating eating) throws Exception;

    List<Eating> getAll();

    List<Eating> getDateAll(String date);
}

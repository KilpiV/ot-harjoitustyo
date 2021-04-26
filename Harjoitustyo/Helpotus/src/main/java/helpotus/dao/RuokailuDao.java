package helpotus.dao;

import java.util.*;
import helpotus.domain.Ruokailu;

public interface RuokailuDao {

    Ruokailu create(Ruokailu ruokailu) throws Exception;

    List<Ruokailu> getAll();

    List<Ruokailu> getDateAll(String paivays);
}

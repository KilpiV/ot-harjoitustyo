package helpotus.domain;

import java.util.*;
import helpotus.dao.EatingDao;

public class FakeEatingDao implements EatingDao {

    List<Eating> eatings;

    public FakeEatingDao() {
        eatings = new ArrayList<>();
    }

    @Override
    public Eating create(Eating eating) {
        eatings.add(eating);
        return eating;
    }

    @Override
    public List<Eating> getAll() {
        return eatings;
    }

    @Override
    public List<Eating> getDateAll(String date) {
        List<Eating> dated = new ArrayList<>();
        for (int i = 0; i < eatings.size(); i++) {
            if (eatings.get(i).getDate().equals(date)) {
                dated.add(eatings.get(i));
            }
        }
        return dated;
    }

    public List<Eating> getLoggedInAll(User user) {
        List<Eating> all = new ArrayList<>();
        for (int i = 0; i < eatings.size(); i++) {
            if (eatings.get(i).getUser().getUsername().equals(user.getUsername())) {
                all.add(eatings.get(i));
            }
        }
        return all;
    }

}

package helpotus.domain;

import java.util.*;
import helpotus.dao.UserDao;

public class FakeUserDao implements UserDao {

    List<User> users = new ArrayList<>();

    public FakeUserDao() {
        users.add(new User("tester"));
    }

    @Override
    public User create(User user) {
        users.add(user);
        return user;
    }

    @Override
    public User findByUsername(String username) {
        return users.stream().filter(u -> u.getUsername().equals(username))
                .findFirst().orElse(null);
    }

    @Override
    public List<User> getAll() {
        return users;
    }

}

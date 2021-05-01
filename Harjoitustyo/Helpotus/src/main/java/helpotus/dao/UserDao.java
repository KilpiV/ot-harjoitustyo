package helpotus.dao;

import helpotus.domain.User;
import java.util.*;

public interface UserDao {

    User create(User user) throws Exception;

    User findByUsername(String username);

    List<User> getAll();

}

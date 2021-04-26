package helpotus.domain;

import java.util.*;
import helpotus.dao.RuokailuDao;
import helpotus.dao.UserDao;
import java.util.stream.Collectors;

public class Ruokalistaus {

    private RuokailuDao ruokailuDao;
    private UserDao userDao;
    private User loggedIn;

    public Ruokalistaus(RuokailuDao ruokailuDao, UserDao userDao) {
        this.ruokailuDao = ruokailuDao;
        this.userDao = userDao;
    }

    public boolean createRuokailu(String date, String string) {
        Ruokailu ruokailu = new Ruokailu(date, string, loggedIn);
        try {
            ruokailuDao.create(ruokailu);
        } catch (Exception ee) {
            return false;
        }
        return true;
    }

    public List<Ruokailu> getDated(String date) {
        if (loggedIn == null) {
            return new ArrayList<>();
        }

        return ruokailuDao.getAll().stream()
                .filter(t -> t.getUser().equals(loggedIn))
                .filter(t -> t.getDate().equals(date))
                .collect(Collectors.toList());
    }

    public boolean login(String username) {
        User user = userDao.findByUsername(username);
        
        if (user == null) {
            return false;
        }
        
        loggedIn = user;
        
        return true;
    }
    
    public User getLoggedUser() {
        return loggedIn;
    }
    
    public void logout() {
        loggedIn = null;
    }
    
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

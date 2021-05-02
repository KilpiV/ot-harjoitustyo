package helpotus.dao;

import java.io.File;
import java.io.FileWriter;
import java.util.*;
import helpotus.domain.User;

/**
 * Luokka, joka vastaa käyttäjien pysyväistallennuksesta.
 */
public class FileUserDao implements UserDao {

    private List<User> users;
    private String file;

    public FileUserDao(String file) throws Exception {
        users = new ArrayList<>();
        this.file = file;
        try {
            Scanner scanner = new Scanner(new File(file));
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(";");
                User u = new User(parts[0]);
                users.add(u);
            }
        } catch (Exception e) {
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }
    }

    private void save() throws Exception {
        try (FileWriter writer = new FileWriter(new File(file))) {
            for (User user : users) {
                writer.write(user.getUsername() + "\n");
            }
        }
    }

    @Override
    public User create(User user) throws Exception {
        users.add(user);
        save();
        return user;
    }

    @Override
    public User findByUsername(String username) {
        return users.stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst().orElse(null);
    }

    @Override
    public List<User> getAll() {
        return users;
    }

}

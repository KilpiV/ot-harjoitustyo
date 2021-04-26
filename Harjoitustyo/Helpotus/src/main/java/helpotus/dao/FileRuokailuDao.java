package helpotus.dao;

import java.io.File;
import java.io.FileWriter;
import java.util.*;
import helpotus.domain.Ruokailu;
import helpotus.domain.User;

public class FileRuokailuDao implements RuokailuDao {

    public List<Ruokailu> ruokailut;
    private String file;

    public FileRuokailuDao(String file, UserDao users) throws Exception {
        ruokailut = new ArrayList<>();
        this.file = file;
        try {
            Scanner scanner = new Scanner(new File(file));
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(";");
                String date = parts[0];
                String food = parts[1];
                int quantity = Integer.parseInt(parts[2]);
                User user = users.getAll().stream().filter(u -> u.getUsername()
                        .equals(parts[3])).findFirst().orElse(null);
                Ruokailu ruokailu = new Ruokailu(date, food, quantity, user);
                ruokailut.add(ruokailu);
            }
        } catch (Exception e) {
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }
    }

    private void save() throws Exception {
        try (FileWriter writer = new FileWriter(new File(file))) {
            for (Ruokailu ruokailu : ruokailut) {
                writer.write(ruokailu.getDate() + ";" + ruokailu.getFood() + ";" + ruokailu.getQuantity() + ";" + ruokailu.getUser() + "\n");
            }
        }
    }

    @Override
    public List<Ruokailu> getAll() {
        return ruokailut;
    }
    
    @Override
    public List<Ruokailu> getDateAll(String date) {
        List<Ruokailu> ruokailutPaivays = new ArrayList<>();
        for (int i = 0; i < ruokailut.size(); i++) {
            if (ruokailut.get(i).getDate().equals(date)) {
                ruokailutPaivays.add(ruokailut.get(i));
            }
        }
        return ruokailutPaivays;
    }

    @Override
    public Ruokailu create(Ruokailu ruokailu) throws Exception {
        ruokailut.add(ruokailu);
        save();
        return ruokailu;
    }
}

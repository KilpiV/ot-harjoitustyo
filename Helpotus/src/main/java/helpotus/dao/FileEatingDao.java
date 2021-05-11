package helpotus.dao;

import java.io.File;
import java.io.FileWriter;
import java.util.*;
import helpotus.domain.Eating;
import helpotus.domain.User;

/**
 * Luokka joka vastaa ruokailujen pysyväistallennuksesta.
 */
public class FileEatingDao implements EatingDao {

    public List<Eating> eatings;
    private String file;

    /**
     * Luo olion joka vastaa pysyväistallennuksesta.
     *
     * @param file tiedoston nimi johon tallennetaan
     * @param users käyttäjistä vastaava olio
     * @throws Exception jos luku epäonnistuu
     */
    public FileEatingDao(String file, UserDao users) throws Exception {
        eatings = new ArrayList<>();
        this.file = file;
        try {
            Scanner scanner = new Scanner(new File(file));
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(";");
                String date = parts[0];
                String food = parts[1];
                User user = users.getAll().stream().filter(u -> u.getUsername()
                        .equals(parts[2])).findFirst().orElse(null);
                Eating ruokailu = new Eating(date, food, user);
                eatings.add(ruokailu);
            }
        } catch (Exception e) {
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }
    }

    private void save() throws Exception {
        try (FileWriter writer = new FileWriter(new File(file))) {
            for (Eating eating : eatings) {
                writer.write(eating.getDate() + ";" + eating.getFood() + ";"
                        + eating.getUser().getUsername() + "\n");
            }
        }
    }

    @Override
    public List<Eating> getAll() {
        return eatings;
    }

    @Override
    public List<Eating> getDateAll(String date) {

        List<Eating> datedEatings = new ArrayList<>();
        for (int i = 0; i < eatings.size(); i++) {
            if (eatings.get(i).getDate().equals(date)) {
                datedEatings.add(eatings.get(i));
            }
        }
        return datedEatings;
    }

    @Override
    public Eating create(Eating eating) throws Exception {
        eatings.add(eating);
        save();
        return eating;
    }
}

package helpotus.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import static org.junit.Assert.*;
import java.util.*;
import java.io.FileWriter;
import java.io.File;
import helpotus.domain.Eating;
import helpotus.domain.User;
import helpotus.domain.FakeUserDao;

public class FileEatingDaoTest {

    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();

    File userFile;
    EatingDao dao;
    UserDao userDao;

    @Before
    public void setUp() throws Exception {
        userFile = testFolder.newFile("testfile_users.txt");
        userDao = new FakeUserDao();
        userDao.create(new User("tester"));

        try (FileWriter file = new FileWriter(userFile.getAbsolutePath())) {
            file.write("02-02-2000;banaani;tester\n");
        }

        dao = new FileEatingDao(userFile.getAbsolutePath(), userDao);
    }

    @Test
    public void ruokailuIsCorrectlyReadFromFile() {
        List<Eating> eatings = dao.getAll();
        assertEquals(1, eatings.size());
        Eating eating = eatings.get(0);
        assertEquals("banaani", eating.getFood());
        assertEquals("02-02-2000", eating.getDate());
        assertEquals("tester", eating.getUser().getUsername());
    }

    @Test
    public void getDateAllReturnCorrectlyEmptyList() {
        String date = "02-03-2000";
        List<Eating> eatings = dao.getDateAll(date);
        assertEquals(new ArrayList<>(), eatings);
    }

    @Test
    public void getDateAllReturnCorrectly() {
        String date = "02-02-2000";
        List<Eating> eatings = dao.getDateAll(date);
        assertEquals("[Pvm:02-02-2000, ruoka-aine:banaani]", eatings.toString());
    }

    @Test
    public void eatingSavedIsFound() throws Exception {
        Eating eating = new Eating("02-03-2020", "omena", userDao.findByUsername("tester"));
        dao.create(eating);
        String date = "02-03-2020";
        List<Eating> eatings = dao.getDateAll(date);
        assertEquals("[Pvm:02-03-2020, ruoka-aine:omena]", eatings.toString());
    }

    @After
    public void tearDown() {
        userFile.delete();
    }
}

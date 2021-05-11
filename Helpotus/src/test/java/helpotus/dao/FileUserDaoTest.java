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
import helpotus.domain.User;

public class FileUserDaoTest {

    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();

    File userFile;
    UserDao dao;

    @Before
    public void setUp() throws Exception {
        userFile = testFolder.newFile("testfile_users.txt");

        try (FileWriter file = new FileWriter(userFile.getAbsolutePath())) {
            file.write("tester\n");
        }

        dao = new FileUserDao(userFile.getAbsolutePath());
    }

    @Test
    public void usernamesAreReadCorrectlyFromFile() {
        List<User> users = dao.getAll();
        assertEquals(1, users.size());
        User user = users.get(0);
        assertEquals("tester", user.getUsername());
    }

    @Test
    public void existingUserIsFound() {
        User user = dao.findByUsername("tester");
        assertEquals("tester", user.getUsername());
    }

    @Test
    public void nonExistingUserIsFound() {
        User user = dao.findByUsername("testing");
        assertEquals(null, user);
    }

    @Test
    public void userSavedAndFound() throws Exception {
        User newUser = new User("TelluTester");
        dao.create(newUser);

        User user = dao.findByUsername("TelluTester");
        assertEquals("TelluTester", user.getUsername());
    }

    @After
    public void tearDown() {
        userFile.delete();
    }
}

package helpotus.dao;

import org.junit.After;
//import org.junit.AfterClass;
import org.junit.Before;
//import org.junit.BeforeClass;
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
    
    @Before
    public void setUp() throws Exception {
        userFile = testFolder.newFile("testfile_users.txt");  
        UserDao userDao = new FakeUserDao();
        userDao.create(new User("tester"));
        
        try (FileWriter file = new FileWriter(userFile.getAbsolutePath())) {
            file.write("02-02-2000;banaani;tester\n");
        }
        
        dao = new FileEatingDao(userFile.getAbsolutePath(), userDao);   
    }
   
    @Test
    public void ruokailuIsCorrectlyReadFromFile() {
        List<Eating> ruokailut = dao.getAll();
        assertEquals(1, ruokailut.size());
        Eating ruokailu = ruokailut.get(0);
        assertEquals("banaani", ruokailu.getFood());
        assertEquals("02-02-2000", ruokailu.getDate());
//        assertEquals(1, ruokailu.getQuantity());
        assertEquals("tester", ruokailu.getUser().getUsername());
    } 
    
    @After
    public void tearDown() {
        userFile.delete();
    }
}

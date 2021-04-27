package helpotus.dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import static org.junit.Assert.*;
import java.util.*;
import java.io.FileWriter;
import java.io.File;
import helpotus.domain.Ruokailu;
import helpotus.domain.User;
import helpotus.domain.FakeUserDao;

public class FileRuokailuDaoTest {
    
    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();
    
    File userFile;
    RuokailuDao dao;
    
    @Before
    public void setUp() throws Exception {
        userFile = testFolder.newFile("testfile_users.txt");  
        UserDao userDao = new FakeUserDao();
        userDao.create(new User("tester"));
        
        try (FileWriter file = new FileWriter(userFile.getAbsolutePath())) {
            file.write("02-02-2000;banaani;1;tester\n");
        }
        
        dao = new FileRuokailuDao(userFile.getAbsolutePath(), userDao);   
    }
   
    @Test
    public void ruokailuIsCorrectlyReadFromFile() {
        List<Ruokailu> ruokailut = dao.getAll();
        assertEquals(1, ruokailut.size());
        Ruokailu ruokailu = ruokailut.get(0);
        assertEquals("banaani", ruokailu.getFood());
        assertEquals("02-02-2000", ruokailu.getDate());
        assertEquals(1, ruokailu.getQuantity());
        assertEquals("tester", ruokailu.getUser().getUsername());
    } 
    
    @After
    public void tearDown() {
        userFile.delete();
    }
}

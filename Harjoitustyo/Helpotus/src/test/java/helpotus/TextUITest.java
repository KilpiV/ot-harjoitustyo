package helpotus;


import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;


public class TextUITest {
    TextUI ui;
    String syote;
    RuokalistausDao ruoka;
    Scanner scanner;
    
    public TextUITest() {
    }
    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
    
    @Before
    public void setUp() {
        this.syote="";
        this.scanner = new Scanner(syote);
        this.ruoka = new RuokalistausDao("data");
        this.ui = new TextUI(scanner, ruoka);
    }
//    @Test
//     public void getStarted() throws SQLException {
//         this.ruoka.add(new Ruokalistaus("20-02-2002", "banaani", 1));
////         ui.start();
//         
//     }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
//     @Test
//     public void hello() {}
}

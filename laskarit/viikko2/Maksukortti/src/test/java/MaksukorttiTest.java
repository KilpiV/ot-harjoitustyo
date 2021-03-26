
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MaksukorttiTest {

    Maksukortti kortti;

//    public MaksukorttiTest() {            //suoritetaan ennen testin alkua
//    }
//
//    @BeforeClass
//    public static void setUpClass() {     //suoritetaan ennen testin alkua
//    }
//
//    @AfterClass
//    public static void tearDownClass() {  //suoritetaan testauksen jälkeen
//    }
    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

//    @After
//    public void tearDown() {              //suoritetaan joka testin jälkeen
//    }
//
//    // TODO add test methods here.
//    // The methods must be annotated with annotation @Test. For example:
//    //
//    @Test
//    public void hello() {
//    }
    @Test
    public void konstruktoriAsettaaSaldonOikein() {
//        Maksukortti kortti = new Maksukortti(10);
//
//        String vastaus = kortti.toString();

        assertEquals("Kortilla on rahaa 10.0 euroa", kortti.toString());
    }

    @Test
    public void syoEdullisestiVahentaaSaldoaOikein() {
//        Maksukortti kortti = new Maksukortti(10);

        kortti.syoEdullisesti();

        assertEquals("Kortilla on rahaa 7.5 euroa", kortti.toString());
    }

    @Test
    public void syoMaukkaastiVahentaaSaldoaOikein() {
//        Maksukortti kortti = new Maksukortti(10);

        kortti.syoMaukkaasti();

        assertEquals("Kortilla on rahaa 6.0 euroa", kortti.toString());
    }

    @Test
    public void syoEdullisestiEiVieSaldoaNegatiiviseksi() {
//        Maksukortti kortti = new Maksukortti(10);

        kortti.syoMaukkaasti();
        kortti.syoMaukkaasti();

        kortti.syoEdullisesti();

        assertEquals("Kortilla on rahaa 2.0 euroa", kortti.toString());
    }

    @Test
    public void syoMaukkaastiEiVieSaldoaNegatiiviseksi() {
        kortti.syoMaukkaasti();
        kortti.syoMaukkaasti();
        kortti.syoMaukkaasti();
        assertEquals("Kortilla on rahaa 2.0 euroa", kortti.toString());
    }

    @Test
    public void kortilleVoiLadataRahaa() {
        kortti.lataaRahaa(25);
        assertEquals("Kortilla on rahaa 35.0 euroa", kortti.toString());
    }

    @Test
    public void kortinSaldonEiYlitaMaksimiarvoa() {
        kortti.lataaRahaa(200);
        assertEquals("Kortilla on rahaa 150.0 euroa", kortti.toString());
    }

    @Test
    public void eiSaaLadattuaNegatiivistaArvoa() {
        kortti.lataaRahaa(-10);
        assertEquals("Kortilla on rahaa 10.0 euroa", kortti.toString());
    }

    @Test
    public void syoEdullisestiToimiiKunJuuriOikeaSumma() {

        kortti.syoEdullisesti();    //7.5
        kortti.syoEdullisesti();    //5.0
        kortti.syoEdullisesti();    //2.5

        kortti.syoEdullisesti();

        assertEquals("Kortilla on rahaa 0.0 euroa", kortti.toString());
    }

    @Test
    public void syoMaukkaastiToimiiKunJuuriOikeaSumma() {
        kortti.lataaRahaa(2.0);     //12.0
        kortti.syoMaukkaasti();     //8.0
        kortti.syoMaukkaasti();    //4.0

        kortti.syoMaukkaasti();

        assertEquals("Kortilla on rahaa 0.0 euroa", kortti.toString());
    }
}

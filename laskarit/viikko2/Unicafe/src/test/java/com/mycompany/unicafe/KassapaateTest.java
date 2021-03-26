package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;

public class KassapaateTest {

    Kassapaate kassa;
    Maksukortti korttiTays;
    Maksukortti korttiVajaa;

//    public KassapaateTest() {
//    }
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
    @Before
    public void setUp() {
        kassa = new Kassapaate();
        korttiTays = new Maksukortti(1000);
        korttiVajaa = new Maksukortti(100);
    }

    @Test
    public void kassapaateLuotu() {
        assertTrue(kassa != null);
    }

    @Test
    public void kaikkiOikeinAlussa() {

        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void maukkaatToimiiOikeinIsommallaSummalla() {
        kassa.syoMaukkaasti(500);
        assertEquals(100400, kassa.kassassaRahaa());
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
        assertEquals(100, kassa.syoMaukkaasti(500));
    }

    @Test
    public void edullisetToimiiOikeinIsommallaSummalla() {
        kassa.syoEdullisesti(500);
        assertEquals(100240, kassa.kassassaRahaa());
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
        assertEquals(260, kassa.syoEdullisesti(500));
    }

    @Test
    public void maukkaatToimiiOikeinPienemmallaSummalla() {
        kassa.syoMaukkaasti(300);
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
        assertEquals(300, kassa.syoMaukkaasti(300));
    }

    @Test
    public void edullisetToimiiOikeinPienemmallaSummalla() {
        kassa.syoEdullisesti(200);
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
        assertEquals(200, kassa.syoEdullisesti(200));
    }

    @Test
    public void kortillaMaukkaanOstoToimiiOikeinJosRahaaOn() {
        kassa.syoMaukkaasti(korttiTays);
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(600, korttiTays.saldo());
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());

    }

    @Test
    public void kortillaEdullisenOstoToimiiOikeinJosRahaaOn() {
        kassa.syoEdullisesti(korttiTays);
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(760, korttiTays.saldo());
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void kortillaMaukkaanOstoToimiiOikeinJosRahaaEiOle() {
        kassa.syoMaukkaasti(korttiVajaa);
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(100, korttiVajaa.saldo());
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void kortillaEdullisenOstoToimiiOikeinJosRahaaEiOle() {
        kassa.syoEdullisesti(korttiVajaa);
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(100, korttiVajaa.saldo());
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void kortilleLatausToimiiOikein() {
        kassa.lataaRahaaKortille(korttiTays, 1000);
        assertEquals(101000, kassa.kassassaRahaa());
        assertEquals(2000, korttiTays.saldo());
        
    }

    @Test
    public void kortilleLatausToimiiOikeinNegatiivisellaSummalla() {
        kassa.lataaRahaaKortille(korttiTays, -10);
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(1000, korttiTays.saldo());
        
    }    
//    @After
//    public void tearDown() {
//    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti != null);
    }

    @Test
    public void saldoOikeinAlussa() {
        assertEquals("saldo: 0.10", kortti.toString());
    }

    @Test
    public void saldoKasvaaOikein() {
        kortti.lataaRahaa(90);
        assertEquals("saldo: 1.0", kortti.toString());
    }

    @Test
    public void rahanKayttoToimiiJosRahaaOn() {
        kortti.otaRahaa(9);
        assertEquals("saldo: 0.1", kortti.toString());
    }

    @Test
    public void rahanKayttoEiToimiJosRahaaEiOle() {
        kortti.otaRahaa(12);
        assertEquals("saldo: 0.10", kortti.toString());
    }

    @Test
    public void rahaaOliTarpeeksi() {
        assertTrue(kortti.otaRahaa(5));
    }

    @Test
    public void rahaaEiOllutTarpeeksi() {
        assertFalse(kortti.otaRahaa(12));
    }

    @Test
    public void saldoPalauttaaOikein() {
        assertEquals(10, kortti.saldo());
    }

    @Test
    public void saldoPalauttaaOikeinLisatyn() {
        kortti.lataaRahaa(90);
        assertEquals(100, kortti.saldo());
    }

    @Test
    public void saldoPalauttaaOikeinVahennetyn() {
        kortti.otaRahaa(5);
        assertEquals(5, kortti.saldo());
    }

}

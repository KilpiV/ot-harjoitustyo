# Helpotus

## Vaatimusmäärittely

### Sovelluksen tarkoitus

Sovelluksella voidaan seurata syömisiä, siihen tallennetaan syömisiä eri päiviltä ja näin voidaan esimerkiksi seurata, minkälainen ruokavalio itselle sopii (allergioiden tai ruoka-aineherkkyyksien etsintä), tai vain seurata ruuankulutusta.

### Käyttäjät

Vain peruskäyttäjät

### Toiminnallisuudet

- Voi luoda uuden käyttäjän.
    - Ohjelma huomauttaa, jos valitsemasi nimimerkki on jo käytössä.
- Sisäänkirjautuminen:
    - Tapahtuu yksilöllisellä nimimerkillä.
    - Sovellus ilmoittaa, jos nimimerkki on virheellinen, eli kyseisellä nimimerkillä ei ole käyttäjää.
- Voi olla monta käyttäjää.
- Voi lisätä syömisiään tietylle päivälle.
    - Lisäyksen voi peruuttaa tietojen syötön jälkeen.
- Voi tarkistaa syömisiään tietyltä päivältä.

#### Jatkokehitysideointia

 * Ohjelmaan voidaan lisätä IBS-oireet tai allergiaoireet tietylle päivälle, jolloin ohjelma etsii yhtäläisyyksiä näiden oireiden syöntijaksoilta, *(allergia: kyseinen päivä, IBS: kahden vuorokauden ajalta)* yhtäläisyyksiä ja näin voi saada apua vältettävien ruokien huomaamiseen.
 * Voi lisätä perhekunnat ja tietyt ateriat suoraan koko perheelle. 
 * Voi merkata jonkin ruuan seurattavaksi, jolloin näkee, monestiko sen ruuan jälkeen on ollut allergia- tai IBS-oireita ja monestiko ei (tietokanta voisi toimia paremmin).
 * "Hälytykset" tietyille ruoka-aineille esimerkiksi, ettei sokeria ole liian usein viikolla ruuassa...
 * Graafinen käyttöliittymä 

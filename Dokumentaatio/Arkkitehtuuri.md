# Arkkitehtuurikuvaus

## Pakkausrakenne

Ohjelman rakenne noudattaa kerrosarkkitehtuuria ja koostuu kolmesta kerroksesta seuraavasti:
Pakkauksessa helpotus.ui on tekstikäyttöliittymä TextUI ja ohjelman käynnistyksestä vastaava pääluokka Helpotus. Pakkaus helpotus.domain sisältää sovelluslogiikan kuten User-luokan. Pakkaus helpotus.dao sisältää pysyväistallennuksesta vastaavat koodit.

![pakkausrakenne](https://user-images.githubusercontent.com/74470219/118138849-75469080-b40f-11eb-90bb-0ba304487212.jpeg)

## Käyttöliittymä

Käyttöliittymä sisältää kaksi erilaista tilaa
* *kirjautuminen ja uuden käyttäjän luominen*
* *ruokien lisäys ja niiden tarkastaminen*

Nämä ovat [TextUI](https://github.com/KilpiV/ot-harjoitustyo/blob/master/Helpotus/src/main/java/helpotus/ui/TextUI.java) luokassa, joka vastaa sovelluksen ja käyttäjän välisestä kanssakäymisestä. Se on eriytetty sovelluslogiikasta ja se kutsuu [DateChecking](https://github.com/KilpiV/ot-harjoitustyo/blob/master/Helpotus/src/main/java/helpotus/domain/DateChecking.java)-oliota, joka vastaa päiväyksien oikeellisuuden tarkistuksesta ja [FoodListings](https://github.com/KilpiV/ot-harjoitustyo/blob/master/Helpotus/src/main/java/helpotus/domain/FoodListings.java)-oliota, joka vastaa muusta.

## Sovelluslogiikka

[User](https://github.com/KilpiV/ot-harjoitustyo/blob/master/Helpotus/src/main/java/helpotus/domain/User.java)- ja [Eating](https://github.com/KilpiV/ot-harjoitustyo/blob/master/Helpotus/src/main/java/helpotus/domain/Eating.java)- luokat, kuvaavat käyttäjiä ja heidän ruokailujaan, nämä muodostavat sovelluksen loogisen datamallin.

![User-Eatings](https://user-images.githubusercontent.com/74470219/118142990-90b39a80-b413-11eb-88ef-c71d6e485e1f.JPG)

DateChecking-luokan olio vastaa ainoastaan päiväyksien tarkistuksista.

FoodListings-luokan olio vastaa kaikista muista toiminnallisista kokonaisuuksista. Se tarjoaa kaikille käyttöliittymän toiminnoille oman metodin. 

Esimerkiksi näitä ovat:
 * boolean createEating(String date, String food)
 * List getDated(String date)
 * void logout()
 * boolean login(String username)
 
FoodListings käsittelee käyttäjiä ja ruokailuja helpotus.dao pakkauksessa olevien rajapintojen [UserDao](https://github.com/KilpiV/ot-harjoitustyo/blob/master/Helpotus/src/main/java/helpotus/dao/UserDao.java) ja [EatingDao](https://github.com/KilpiV/ot-harjoitustyo/blob/master/Helpotus/src/main/java/helpotus/dao/EatingDao.java) kautta.

Sovelluslogiikkaa kuvaava luokka/pakkauskaavio:

![Sovelluslogiikka](https://user-images.githubusercontent.com/74470219/118139201-cce4fc00-b40f-11eb-91ae-065238538e11.JPG)

## Tietojen pysyväistallennus

Pysyväistallennuksesta huolehtii [helpotus.dao](https://github.com/KilpiV/ot-harjoitustyo/tree/master/Helpotus/src/main/java/helpotus/dao) pakkauksen sisältö. [FileEatingDao](https://github.com/KilpiV/ot-harjoitustyo/tree/master/Helpotus/src/main/java/helpotus/dao/FileEatingDao) huolehtii ruokailujen tallennuksesta tiedostoon ja [FileUserDao](https://github.com/KilpiV/ot-harjoitustyo/tree/master/Helpotus/src/main/java/helpotus/dao/FileUserDao) taas huolehtii käyttäjien tallennuksesta omaan tiedostoonsa.
Datan tallennus on laitettu Dao-luokkien taakse, jolloin halutessa voidaan tallennusmuotoa helpommin muuttaa, kun sovelluslogiikka ei suoraan käytä näitä luokkia vaan rajapintoja.

Tiedot tallennetaan txt-tiedostoihin.

### Tiedostot
Sovelluksen juureen toteutettu konfiguraatiotiedosto [config.properties](https://github.com/KilpiV/ot-harjoitustyo/blob/master/Helpotus/config.properties) määrittelee tallennettavien tiedostojen nimet.

Tiedostojen sisällöt ovat seuraavan tyyppisiä:

User.txt:
```
hiiri
kissa
```
eli jokainen käyttäjä on omalla rivillään.

Eatings.txt:
```
02-02-2000;juusto;hiiri
02-02-2000;kalaa;kissa
03-02-2000;hiiri;kissa
```
Ruokailujen talletuksen kentät on eroteltu puolipistein. Ensiksi on päivämäärä, toisena ruokailu ja viimeisenä käyttäjän käyttäjätunnus.

## Päätoiminnallisuudet sekvenssikaavioina

Seuraavaksi on kuvattu päätoiminnallisuudet sekvenssikaavioina.

### Kirjautuminen

Kun syötetään ensiksi "1", niin tekstikäyttöliittymä kysyy seuraavaksi nimimerkkiä ja sen saatuaan se kutsuu FoodListing-oliota, joka tarkistaa UserDao-rajapintaa hyödyntäen, onko kyseinen käyttäjätunnus oikein ja jos on, niin palauttaa true ja tekstikäyttöliittymä päästää käyttäjän ruokailukysely-osioon. Jos taas käyttäjätunnus on väärin, eikä kyseistä käyttäjää löydy tiedostosta, niin se palauttaa tekstikäyttöliittymälle false ja tämä ilmoittaa käyttäjälle "Virheellinen nimimerkki".

##### Kontrollin eteneminen:

![Sekvenssikaavio onnistunutLogin](https://user-images.githubusercontent.com/74470219/118138915-898a8d80-b40f-11eb-9a09-a65549b98035.JPG)

![Sekvenssikaavio epäonnistunutLogin](https://user-images.githubusercontent.com/74470219/118138879-7f688f00-b40f-11eb-8ce4-16071e8b22b2.JPG)


### Uuden käyttäjän luominen

Kun syötetään ensiksi "2", niin tekstikäyttöliittymä kysyy seuraavaksi luotavaa nimimerkkiä ja sen saatuaan se kutsuu FoodListing-oliota, joka tarkistaa UserDao-rajapintaa hyödyntäen, onko kyseinen käyttäjätunnus jo olemassa, ja jos ei ole, niin se luo uuden User-olion ja palauttaa true ja tekstikäyttöliittymä ilmoittaa tästä käyttäjälle ja palauttaa kirjautumisnäkymän. Jos taas käyttäjätunnus on jo olemassa, niin se palauttaa tekstikäyttöliittymälle false ja tämä ilmoittaa käyttäjälle "Nimimerkki on jo käytössä, valitse toinen".

##### Kontrollin eteneminen:

![Sekvenssikaavio uusiKayttajaOnnistuneesti](https://user-images.githubusercontent.com/74470219/118139133-bd65b300-b40f-11eb-8a98-f1c99c93290b.JPG)

![Sekvenssikaavio uusiKayttajaEpaonnistuneesti](https://user-images.githubusercontent.com/74470219/118139127-ba6ac280-b40f-11eb-9966-202b1d5768f9.JPG)


### Päivämäärän antaminen

Uuden ruokailun lisäämisen ja tarkastelun yhteydessä annetaan päivämäärä, joka tapahtuu vastaavanlaisesti.
Tekstikäyttöliittymä pyytää lisättävän (tai haettavan) ruokailun päivämäärää, ja pyytää ensiksi vuoden. Kun käyttäjä kirjoittaa vuosiluvun, käyttöliittymä kutsuu DateChecking-oliota, joka tarkistaa jokaisen päivämäärän osan vuorollaan ja palauttaa käyttöliittymälle kyseisen ajan tai sopivan virheilmoituksen, jos se ei ole kelvollinen, esim. "Vuosiluku ei ole kelvollinen, valitse vuosi väliltä 1990-2100" tai "kaikki merkit eivät olleet numeroita". Tämän viestin tekstikäyttöliittymä välittää edelleen käyttäjälle. Sama tapahtuu kuukauden ja päivän kanssa. Kun ne on annettu oikein, tekstikäyttöliittymä palauttaa päivämäärän kokonaisuudessaan.

##### Kontrollin eteneminen:

![Sekvenssikaavio päivämääränKysely](https://user-images.githubusercontent.com/74470219/118138945-927b5f00-b40f-11eb-9282-6e8ee9bc75ed.JPG)


### Uuden ruokailun luominen

Päivämäärän syöttämisen ja tarkistuksen jälkeen tekstikäyttöliittymä kysyy käyttäjältä lisättävän ruokailun, ja varmistaa sitten kokonaisuuden vielä käyttäjältä. Hyväksytyssä tapauksessa se kutsuu FoodListing-oliota, joka luo uuden Eating-olion, jonka se tallentaa EatingDao-rajapinnan create avulla. Sitten se palauttaa käyttöliittymälle true ja tämä ilmoittaa käyttäjälle, että lisättiin ruokailu. Hylätyssä tapauksessa käyttöliittymä ei ollenkaan kutsu FoodListing-oliota, vaan ilmoittaa vain, että ruokailua ei lisätty ja siirtyy ruokailujen tilaan.

##### Kontrollin eteneminen:

![Sekvenssikaavio ruokailun lisäys päivämäärän jälkeen](https://user-images.githubusercontent.com/74470219/118139078-ae7f0080-b40f-11eb-9464-a267a7b99650.JPG)

![Sekvenssikaavio ruokailunKyselyPeruutus](https://user-images.githubusercontent.com/74470219/118139060-aaeb7980-b40f-11eb-9ef5-ab7a24f86594.JPG)


### Ruokailujen tarkasteleminen

Kun käyttäjä on syöttänyt kelvollisen päivämäärän, tekstikäyttöliittymä kutsuu FoodListing-oliota, joka hakee kaikki kyseisen päivän tiedot ja kerää käyttäjän ruokailut siltä päivältä listaan ja palauttaa käyttöliittymälle listan, jonka se tulostaa käyttäjälle.

![Sekvenssikaavio ruokailunKyselyPaivamaaranJalkeen](https://user-images.githubusercontent.com/74470219/118138993-9c9d5d80-b40f-11eb-9bef-db0abdd8e693.JPG)


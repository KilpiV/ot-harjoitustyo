# Testausdokumentti

Ohjelmaa on testattu JUnitin automaattisilla testeillä ja manuaalisesti.

## JUnit

### Sovelluslogiikka

[FoodListingsEatingsTest](https://github.com/KilpiV/ot-harjoitustyo/blob/master/Helpotus/src/test/java/helpotus/domain/FoodListingsEatingsTest.java) ja [FoodListingsTest](https://github.com/KilpiV/ot-harjoitustyo/blob/master/Helpotus/src/test/java/helpotus/domain/FoodListingsTest.java) muodostavat sovelluslogiikan integraatiotestit, jotka testaavat [FoodListing](https://github.com/KilpiV/ot-harjoitustyo/blob/master/Helpotus/src/main/java/helpotus/domain/FoodListings.java)-olion toiminnallisuuksia, käyttöliittymää simuloimalla.

Integraatio testeissä on käytetty pysyväistallennukseen [FakeEatingDao](https://github.com/KilpiV/ot-harjoitustyo/blob/master/Helpotus/src/test/java/helpotus/domain/FakeEatingDao.java) ja [FakeUserDao](https://github.com/KilpiV/ot-harjoitustyo/blob/master/Helpotus/src/test/java/helpotus/domain/FakeUserDao.java), jotka käyttävät Dao-rajapintoja, mutta tallentavat koneen keskusmuistiin, erillisten tiedostojen sijaan.

[User](https://github.com/KilpiV/ot-harjoitustyo/blob/master/Helpotus/src/main/java/helpotus/domain/User.java) ja [Eating](https://github.com/KilpiV/ot-harjoitustyo/blob/master/Helpotus/src/main/java/helpotus/domain/Eating.java) on tehty muutama yksikkötesti esim. equals-metodille. [DateChecking](https://github.com/KilpiV/ot-harjoitustyo/blob/master/Helpotus/src/main/java/helpotus/domain/DateChecking.java)-luokka toimii itsenäisesti, joten sen testit ovat myös erilliset yksikkötestit.

### DAO-luokat

Dao-luokkien toiminnallisuus on testattu väliaikaiset tiedostot TemporaryFolder-ruleja apuna käyttäen.

### Testauskattavuus

Käyttöliittymästä vastaava pakkaus [helpotus.ui](https://github.com/KilpiV/ot-harjoitustyo/tree/master/Helpotus/src/main/java/helpotus/ui) pois lukien, testauksen rivikattavuus oli 95% ja haarautumakattavuus 92%.

![jacocoTestReport](https://user-images.githubusercontent.com/74470219/118283094-aa1e1a80-b4d7-11eb-94de-1d7169c0ff12.JPG)


Testaamatta jäivät tilanteet, missä ohjelmalla ei ole lukuoikeutta tai lukemisen kanssa esiintyy jokin ongelma, nämä olivat kaikki [Dao-pakkauksen](https://github.com/KilpiV/ot-harjoitustyo/tree/master/Helpotus/src/main/java/helpotus/dao) vastuualueella.
 
Missed brances:

![createEatingMissedBranch](https://user-images.githubusercontent.com/74470219/118283129-b4d8af80-b4d7-11eb-84c8-9d052181067b.JPG)

![createUserMissedBranch](https://user-images.githubusercontent.com/74470219/118283140-b7d3a000-b4d7-11eb-8d3f-ff16951a0629.JPG)

![FileEatingDaoMissedBranch](https://user-images.githubusercontent.com/74470219/118283154-bbffbd80-b4d7-11eb-994e-f2341d75dc9e.JPG)

![FileUserDaoMissedBranch](https://user-images.githubusercontent.com/74470219/118283167-be621780-b4d7-11eb-9e24-b0f98a3806c1.JPG)


Ei testattu myöskään jokaisella mahdollisella merkillä ja luvulla päivämäärä ja kuukausi tarkistuksia, vaan erilaisilla ääripäillä ja mahdollisilla ongelmatapauksilla. Nämä taas olivat kaikki [DateChecking](https://github.com/KilpiV/ot-harjoitustyo/blob/master/Helpotus/src/main/java/helpotus/domain/DateChecking.java)-luokan metodeja.

Missed lines:

![jacocoDaysByMonthLines](https://user-images.githubusercontent.com/74470219/118283253-d0dc5100-b4d7-11eb-9574-d2e7544e53fd.JPG)

![jacocoDaysLine](https://user-images.githubusercontent.com/74470219/118283258-d33eab00-b4d7-11eb-8ce6-951268768769.JPG)


## Järjestelmätestaus

Järjestelmätestaus ohjelmalle on suoritettu manuaalisesti.

### Asennus ja konfigurointi

Sovellus on testattu asentaa ja ajaa käyttöohjeen mukaisesti ja onnistuu hyvin. Ohjelman jar-tiedosto on myös onnistuneesti saatu suoritettua komentoriviltä käsin, sekä macilla, että etätyöpöydällä. Ajamista on testattu myös niin että config.properties puuttuu, joka antaa virheilmoituksen puuttumisesta ja sulkee ohjelman, mutta ei kaada ohjelmaa.

### Toiminnallisuudet

Määrittelydokumentin mukaiset toiminnallisuudet on testattu läpi. Kaikkien niiden kohdalla on syötteiksi yritetty antaa myös virheellisiä syötteitä, kuten tyhjiä tai päiväyksien kohdalla muita kuin numeroita, tai virheellisiä päiviä, kuten esimerkiksi 30 helmikuuta, ja ohjelma antoi järkeviä virheilmoituksia, eikä kaatunut.

## Sovellukseen jääneet laatuongelmat

 * Luku/kirjoitusoikeuksien puutteellisuutta ei olla testattu kunnolla ja nämä eivät siksi anna järkeviä virheilmoituksia.

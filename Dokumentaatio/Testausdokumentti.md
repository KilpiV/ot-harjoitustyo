# Testausdokumentti

Ohjelmaa on testattu JUnitin automaattisilla testeillä ja manuaalisesti.

## JUnit

### Sovelluslogiikka

[FoodListingsEatingsTest]... ja [FoodListingsTest]... muodostavat sovelluslogiikan integraatiotestit, jotka testaavat [FoodListing]...-olion toiminnallisuuksia, käyttöliittymää simuloimalla.

Integraatio testeissä on käytetty pysyväistallennukseen [FakeEatingDao]... ja [FakeUserDao]..., jotka käyttävät Dao-rajapintoja, mutta tallentavat koneen keskusmuistiin, erillisten tiedostojen sijaan.

[User]... ja [Eating]... on tehty muutama yksikkötesti esim. equals-metodille. [DateChecking]...-luokka toimii itsenäisesti joten sen testit ovat myös erilliset yksikkötestit.

### DAO-luokat

Dao-luokkien toiminnallisuus on testattu väliaikaiset tiedostot TemporaryFolder-ruleja apuna käyttäen.

### Testauskattavuus

Käyttöliittymästä vastaava pakkaus helpotus.ui pois lukien, testauksen rivikattavuus oli 95% ja haarautumakattavuus 92%.

![jacocoTestReport.JPG]...

Testaamatta jäivät tilanteet, missä ohjelmalla ei ole lukuoikeutta tai lukemisen kanssa esiintyy jokin ongelma, nämä olivat kaikki Dao-pakkauksen vastuualueella.
 
Missed brances:

[createEatingMissedBranch.JPG]...
[createUserMissedBranch.JPG]...
[FileEatingDaoMissedBranch.JPG]...
[FileUserDaoMissedBranch.JPG]...

Ei testattu myöskään jokaisella mahdollisella merkillä ja luvulla päivämäärä ja kuukausi tarkistuksia, vaan erilaisilla ääripäillä ja mahdollisilla ongelmatapauksilla. Nämä taas olivat kaikki DateChecking-luokan metodeja.

Missed lines:

[jacocoDaysByMonthLines.JPG]...
[jacocoDaysLine.JPG]...

## Järjestelmätestaus

Järjestelmätestaus ohjelmalle on suoritettu manuaalisesti.

### Asennus ja konfigurointi

Sovellus on testattu asentaa ja ajaa käyttöohjeen mukaisesti ja onnistuu hyvin. Ohjelman jar-tiedosto on myös onnistuneesti saatu suoritettua komentoriviltä käsin, sekä macilla, että etätyöpöydällä. Ajamista on testattu myös niin että config.properties puuttuu, joka antaa virheilmoituksen puuttumisesta ja sulkee ohjelman, mutta ei kaada ohjelmaa.

### Toiminnallisuudet

Määrittelydokumentin mukaiset toiminnallisuudet on testattu läpi. Kaikkien niiden kohdalla on syötteiksi yritetty antaa myös virheellisiä syötteitä, kuten tyhjiä tai päiväyksien kohdalla muita kuin numeroita, tai virheellisiä päiviä kuten esimerkiksi 30 helmikuuta ja ohjelma antoi järkeviä virheilmoituksia eikä kaatunut.

## Sovellukseen jääneet laatuongelmat

 * Luku/kirjoitusoikeuksien puutteellisuutta ei olla testattu kunnolla ja nämä eivät siksi anna järkeviä virheilmoituksia.

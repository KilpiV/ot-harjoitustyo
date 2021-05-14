# Harjoitustyö

## Helpotus-ruokailulista

Sovellus, jolla voidaan seurata syömisiä eri päiviltä. Helpottamaan sopivan ruokavalion löytymistä esim. allergioiden, ruoka-aineyliherkkyyksien ja IBS-oireiden kanssa. 
Ohjelmalla useampi käyttäjä voi seurata syömisiään. Siihen voidaan tallentaa syömisiä eri päiviltä ja näitä voidaan myöhemmin hakea päivämäärän perusteella. Näin esimerkiksi käyttäjä voi seurata, minkälainen ruokavalio hänelle sopii, tai vain seurata ruuankulutustaan.

Lataa [Releasen](https://github.com/KilpiV/ot-harjoitustyo/releases/tag/loppupalautus) kautta löytyvä Helpotus-1.0-SNAPSHOT.jar tiedosto.
Sovellus olettaa, että samasta kansiosta löytyy lisäksi tiedosto config.properties (tämä löytyy myös uusimman Releasen kautta), jonka sisältö on:
```
userFile = users.txt
eatingsFile = eatings.txt
```
Hae nämä tiedostot (tai luo).

Tekstitiedostot: users.txt ja eatings.txt, luodaan automaattisesti ohjelmassa, jos niitä ei ole valmiina. 

Avaa ohjelma komennolla
```
java -jar Helpotus-1.0-SNAPSHOT.jar
```

### Dokumentaatio

[Vaatimusmäärittely](https://github.com/KilpiV/ot-harjoitustyo/blob/master/Dokumentaatio/Vaatimusm%C3%A4%C3%A4rittely_Helpotus.md)

[Käyttöohje](https://github.com/KilpiV/ot-harjoitustyo/blob/master/Dokumentaatio/K%C3%A4ytt%C3%B6ohje.md)

[Arkkitehtuuri](https://github.com/KilpiV/ot-harjoitustyo/blob/master/Dokumentaatio/Arkkitehtuuri.md)

[Testausdokumentti](https://github.com/KilpiV/ot-harjoitustyo/blob/master/Dokumentaatio/Testausdokumentti.md)

[Työaikakirjanpito](https://github.com/KilpiV/ot-harjoitustyo/blob/master/Dokumentaatio/Ty%C3%B6aikakirjanpito.md)


### Komentorivitoiminnot

Kun ohjelma on ladattu koneelle, voi sovelluksen suorittaa komennolla
```
mvn compile exec:java -Dexec.mainClass=helpotus.ui.Helpotus
```

#### Testaus

Testit suoritetaan komennolla

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn jacoco:report
```
Kattavuusraportti löytyy avaamalla selaimella tiedosto *target/site/jacoco/index.html*


#### Suoritettavan jar-tiedoston generointi

Saadaan komennolla

```
mvn package
```
generoi *target* -hakemistoon jar-tiedoston Helpotus-1.0-SNAPSHOT.jar


#### Checkstyle

Tiedostoon checkstyle.xml määrittelemät tarkistukset suoritetaan komennolla

```
mvn jxr:jxr checkstyle:checkstyle
```

Virheilmoitukset löytyvät avaamalla selaimella tiedosto *target/site/checkstyle.html*

#### Javadoc

JavaDoc generoidaan komennolla

```
mvn javadoc:javadoc
```

JavaDocia pääsee tarkastelemaan selaimella avaamalla tiedosto *target/site/apidocs/index.html*


### Releaset
[Release 5](https://github.com/KilpiV/ot-harjoitustyo/releases/tag/viikko5)

[Release 6](https://github.com/KilpiV/ot-harjoitustyo/releases/tag/viikko6)

[loppupalautus](https://github.com/KilpiV/ot-harjoitustyo/releases/tag/loppupalautus)


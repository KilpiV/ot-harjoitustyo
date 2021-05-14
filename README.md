# Harjoitustyö

Ohjelmalla useampi käyttäjä voi seurata syömisiänä. Siihen voidaan tallentaa syömisiä eri päiviltä ja näitä voidaan myöhemmin hakea päivämäärän perusteella, näin esimerkiksi, voidaan seurata minkälainen ruokavalio itselle sopii tai vain seurata ruuankulutustaan. Esimerkiksi allergia- ja IBS-oireiden syiden selvittämiseen apuväline.

### Releaset
[Release 5](https://github.com/KilpiV/ot-harjoitustyo/releases/tag/viikko5)

[Release 6](https://github.com/KilpiV/ot-harjoitustyo/releases/tag/viikko6)

[loppupalautus]....

Lataa Releasen kautta löytyvä Helpotus-1.0-SNAPSHOT.jar tiedosto.
Sovellus olettaa, että löytyy tiedosto config.properties (tämä löytyy myös Release 6 kautta), jonka sisältö on:
```
userFile = users.txt
eatingsFile = eatings.txt
```
Hae nämä tiedostot (tai luo).

Tekstitiedostot: users.txt ja eatings.txt
Luodaan automaattisesti ohjelmassa, jos niitä ei ole valmiina. 

Avaa ohjelma komennolla
```
java -jar Helpotus-1.0-SNAPSHOT.jar
```

## Helpotus-ruokailulista

Sovellus jolla voidaan seurata syömisiä eri päiviltä. Helpottamaan sopivan ruokavalion löytymistä esim. allergioiden, ruoka-aineyliherkkyyksien ja IBS-oireiden kanssa. 


### Dokumentaatio

[Vaatimusmäärittely](https://github.com/KilpiV/ot-harjoitustyo/blob/master/Dokumentaatio/Vaatimusm%C3%A4%C3%A4rittely_Helpotus.md)

[Työaikakirjanpito](https://github.com/KilpiV/ot-harjoitustyo/blob/master/Dokumentaatio/Ty%C3%B6aikakirjanpito.md)

[Arkkitehtuuri](https://github.com/KilpiV/ot-harjoitustyo/blob/master/Dokumentaatio/Arkkitehtuuri.md)

[Käyttöohje](https://github.com/KilpiV/ot-harjoitustyo/blob/master/Dokumentaatio/K%C3%A4ytt%C3%B6ohje.md)

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


# Harjoitustyö

### Viikko 5 release
[Release](https://github.com/KilpiV/ot-harjoitustyo/releases/tag/viikko5)

### Viikko 6 release
[Release6](https://github.com/KilpiV/ot-harjoitustyo/releases/tag/viikko6)

Lataa Releasen kautta löytyvä Helpotus-1.0-SNAPSHOT.jar tiedosto.
Sovellus olettaa, että löytyy tiedosto config.properties (tämä löytyy myös Release6 kautta), jonka sisältö on:
```
userFile = users.txt
ruokailuFile = ruokailut.txt
```
ja tekstitiedostot: users.txt ja ruokailut.txt
Luo nämä tiedostot ja avaa ohjelma komennolla

```
java -jar Helpotus-1.0-SNAPSHOT.jar
```

## Helpotus-ruokailulista

Sovellus jolla voidaan seurata syömisiä eri päiviltä. Helpottamaan sopivan ruokavalion löytymistä esim. allergioiden ja aineuliherkkyyksien kanssa. 


### Dokumentaatio

[Vaatimusmäärittely](https://github.com/KilpiV/ot-harjoitustyo/blob/master/Dokumentaatio/Vaatimusm%C3%A4%C3%A4rittely_Helpotus.md)

[Työaikakirjanpito](https://github.com/KilpiV/ot-harjoitustyo/blob/master/Dokumentaatio/Ty%C3%B6aikakirjanpito.md)

[Arkkitehtuuri](https://github.com/KilpiV/ot-harjoitustyo/blob/master/Dokumentaatio/arkkitehtuuri.md)

[Käyttöohje](https://github.com/KilpiV/ot-harjoitustyo/blob/master/Dokumentaatio/K%C3%A4ytt%C3%B6ohje.md)
### Komentorivitoiminnot

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


#### Suoritettavan jarin generointi

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


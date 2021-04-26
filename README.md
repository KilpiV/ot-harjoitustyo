# Harjoitustyö

## Helpotus-ruokailulista

Sovellus jolla voidaan seurata syömisiä eri päiviltä. Helpottamaan sopivan ruokavalion löytymistä esim. allergioiden ja aineuliherkkyyksien kanssa. 

### Dokumentaatio

[Vaatimusmäärittely](https://github.com/KilpiV/ot-harjoitustyo/blob/master/Harjoitustyo/Vaatimusm%C3%A4%C3%A4rittely_Helpotus.md)

[Työaikakirjanpito](https://github.com/KilpiV/ot-harjoitustyo/blob/master/Harjoitustyo/Ty%C3%B6aikakirjanpito.md)

[Arkkitehtuuri]...tulossa

[Käyttöohje]...tulossa

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

Komennolla

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


### Käyttöohje

Lataa tiedosto [Helpotus-1.0-SNAPSHOT.jar]...

## Konfigurointi

Sovellus olettaa, että sen käynnistymishakemistossa on konfiguraatiotiedosto config.properties, joka määrittelee tiedostojen nimet, joihin käyttäjät ja ruokailut tallennetaan.
Tiedoston config.properties sisältö on seuraava
```
userFile = users.txt
eatingsFile = eatings.txt
```
## Ohjelman käynnistys

Ohjelma käynnistetään komennolla

```
java -jar Helpotus-1.0-SNAPSHOT.jar
```
## Ohjelman käynnistyessä
Ohjelman käynnistyessä ensin tulevat seuraavat tekstit

```

Hello user!!!
Tervetuloa Helpotukseen

---
Syötä käsky
(1) Kirjaudu
(2) Luo uusi käyttäjä
(x) Poistu
>>
```

# Kirjautuminen
Kirjautuminen tapahtuu syöttämällä ensin "1" ja sitten jo luotu nimimerkkisi koneelle. Muuten ohjelma tulostaa "Virheellinen nimimerkki".
```
>> 1
Anna nimimerkkisi
>>
```

# Uuden käyttäjän luominen
Uuden käyttäjän luominen tapahtuu syöttämällä ensin "2" ja sitten luotava nimimerkkisi koneelle, jos nimimerkki ei jo ollut käytössä, ohjelma tulostaa "Uusi käyttäjä  on nyt luotu" ja näkymä palaa edelliseen vaiheeseen. Muuten ohjelma tulostaa "Nimimerkki on jo käytössä, valitse toinen" ja palaa takaisin.
```
>> 2
Anna haluamasi nimimerkki
>> "nimimerkki"
Uusi käyttäjä "nimimerkki" on nyt luotu
```
# Kirjautumisen jälkeen
Avautuu uusi näkymä
```

---
Syötä käsky
(1) Lisää ruokia
(2) Tarkasta syömisiä
(x) Poistu
>>
```
# Uuden ruokailun lisääminen
Uuden ruokailun lisääminen tapahtuu syöttämällä ensin "1", sitten päivämäärän lisättävälle ruokailulle (vuosi yyyy, kuukausi, mm tai m, ja päivä dd tai d) ja lopuksi ruuan.
```
>> 1
Anna lisättävän ruokailun päivämäärä
Anna ensin vuosi
>> 2000
Anna seuraavaksi kuukausi
>> 02
Anna vielä päivämäärä
>> 02
Annoit päivämäärän 02-02-2000
Anna lisättävä ruoka
>> juusto

```
# Ruokailujen tarkasteleminen
Ruokailujen tarkastelu tapahtuu syöttämällä ensin "2" ja sitten haettavan ruokailun päivämäärän. Jolloin ohjelma tulostaa listan kyseisen päivän ruokailuista.
```
>> 2
Anna haettavan ruokailun päivämäärä
Anna ensin vuosi
>> 2000
Anna seuraavaksi kuukausi
>> 02
Anna vielä päivämäärä
>> 02
Annoit päivämäärän 02-02-2000

Päivän ruokailut:
[Pvm:02-02-2000, ruoka-aine:juusto]

```

# Poistuminen
Ohjelmasta kirjaudutaan ulos ja poistutaan syöttämällä "x"
```
>> x
Kiitos ja tervetuloa uudelleen
```

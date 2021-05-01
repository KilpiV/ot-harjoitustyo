#### Arkkitehtuurikuvaus

### Pakkausrakenne

Ohjelman rakenne noudattaa kerrosarkkitehtuuria ja koostuu kolmesta kerroksesta seuraavasti:
Pakkauksessa helpotus.ui on tekstikäyttöliittymä TextUI ja ohjelman käynnistyksestä vastaava pääluokka Helpotus. Pakkaus helpotus.domain sisältää sovelluslogiikan kuten käyttäjä luokan. Pakkaus helpotus.dao sisältää pysyväistallennuksesta vastaavat koodit.
![pakkausrakenne](https://user-images.githubusercontent.com/74470219/116072664-14415d80-a698-11eb-9cf8-46cf193d9079.jpeg)

### Käyttöliittymä

Käyttöliittymä sisältää kaksi erilaista tilaa
* kirjautuminen ja uuden käyttäjän luominen
* ruokien lisäys ja niiden tarkastaminen
Nämä ovat TextUI luokassa, joka vastaa sovelluksen ja käyttäjän välisestä kanssakäymisestä. Se on eriytetty sovelluslogiikasta ja se kutsuu FoodListings

### Sovelluslogiikka
### Tietojen pysyväistallennus
## Tiedostot
Tiedostojen sisältö on seuraavanlainen:
```
hiiri
kissa
```
eli jokainen käyttäjä on omalla rivillään.
```
02-02-2000;juusto;hiiri
02-02-2000;kalaa;kissa
03-02-2000;hiiri;kissa
```
Ruokailujen talletuksen kentät on eroteltu puolipistein. Ensiksi on päivämäärä, toisena ruokailu ja viimeisenä käyttäjän käyttäjätunnus.

# Päätoiminnallisuudet
# Kirjautuminen
![Sekvenssikaavio onnistunutLogin](https://user-images.githubusercontent.com/74470219/116127312-58505480-a6d0-11eb-939a-16dc8693846b.JPG)

[Sekvenssikaavio epäonnistunutLogin]

# Uuden käyttäjän luominen
# Uuden ruokailun luominen
# Ruokailujen tarkasteleminen


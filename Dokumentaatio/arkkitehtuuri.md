# Arkkitehtuurikuvaus

## Pakkausrakenne

Ohjelman rakenne noudattaa kerrosarkkitehtuuria ja koostuu kolmesta kerroksesta seuraavasti:
Pakkauksessa helpotus.ui on tekstikäyttöliittymä TextUI ja ohjelman käynnistyksestä vastaava pääluokka Helpotus. Pakkaus helpotus.domain sisältää sovelluslogiikan kuten käyttäjä luokan. Pakkaus helpotus.dao sisältää pysyväistallennuksesta vastaavat koodit.
![pakkausrakenne](https://user-images.githubusercontent.com/74470219/116072664-14415d80-a698-11eb-9cf8-46cf193d9079.jpeg)

## Käyttöliittymä

Käyttöliittymä sisältää kaksi erilaista tilaa
* kirjautuminen ja uuden käyttäjän luominen
* ruokien lisäys ja niiden tarkastaminen
Nämä ovat TextUI luokassa, joka vastaa sovelluksen ja käyttäjän välisestä kanssakäymisestä. Se on eriytetty sovelluslogiikasta ja se kutsuu DateChecking-oliota, joka vastaa päiväyksien oikeellisuuden tarkistuksesta ja FoodListings-oliota, joka vastaa muusta.

## Sovelluslogiikka
![Sovelluslogiikka](https://user-images.githubusercontent.com/74470219/117823842-9627ae00-b276-11eb-9106-40bc637d9a43.JPG)

## Tietojen pysyväistallennus
Tiedot tallennetaan txt-tiedostoihin

### Tiedostot
Tiedostojen sisällöt ovat seuraavan tyyppisiä:
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

#### Päätoiminnallisuudet sekvenssikaavioina
#### Kirjautuminen
![Sekvenssikaavio onnistunutLogin](https://user-images.githubusercontent.com/74470219/117824625-52817400-b277-11eb-912b-ecfd3f9295f4.JPG)

![Sekvenssikaavio epäonnistunutLogin](https://user-images.githubusercontent.com/74470219/117824588-485f7580-b277-11eb-83cb-e02797013515.JPG)

#### Uuden käyttäjän luominen
![Sekvenssikaavio uusiKayttajaOnnistuneesti](https://user-images.githubusercontent.com/74470219/117824730-6331ea00-b277-11eb-982b-6a9b61553380.JPG)
![Sekvenssikaavio uusiKayttajaEpäonnistuneesti](https://user-images.githubusercontent.com/74470219/117824747-65944400-b277-11eb-8ea8-e7adbaf15c69.JPG)

#### Päivämäärän antaminen
![Sekvenssikaavio päivämääränKysely](https://user-images.githubusercontent.com/74470219/117824492-34b40f00-b277-11eb-975a-54f8b1b0c859.JPG)

#### Uuden ruokailun luominen
![Sekvenssikaavio ruokailunLisaysPaivämaaranJalkeen](https://user-images.githubusercontent.com/74470219/117824784-70e76f80-b277-11eb-80dc-472285df8ee0.JPG)

#### Ruokailujen tarkasteleminen
![Sekvenssikaavio ruokailunKyselyPaivamaaranJalkeen](https://user-images.githubusercontent.com/74470219/117824826-780e7d80-b277-11eb-8048-d4a622924c21.JPG)

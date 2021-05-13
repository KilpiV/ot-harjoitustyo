# Testausdokumentti

Ohjelmaa on testattu automaattisilla testeillä JUnitilla ja manuaalisesti.

## JUnit

### Sovelluslogiikka
Automatisoitujen testien 

### DAO-luokat
temporaryfolders

### Testauskattavuus
![jacocoTestReport.JPG]...
testaamatta jääneet
testaamatta jäivät jos ohjelmalla ei ollut lukuoikeutta 
missed brances
[createEatingMissedBranch.JPG]...
[createUserMissedBranch.JPG]...
[FileEatingDaoMissedBranch.JPG]...
[FileUserDaoMissedBranch.JPG]...

missed lines
[jacocoDaysByMonthLines.JPG]...
[jacocoDaysLine.JPG]...

## Järjestelmätestaus
Järjestelmätestaus ohjelmalle on suoritettu manuaalisesti.

### Asennus ja konfigurointi
Sovellus on testattu asentaa ja ajaa käyttöohjeen mukaisesti ja onnistuu terminaalin kautta hyvin, sekä macilla, että etätyöpöydällä.

### Toiminnallisuudet
Määrittelydokumentin mukaiset toiminnallisuudet on testattu läpi. Kaikkien niiden kohdalla on syötteiksi yritetty antaa myös virheellisiä syötteitä, kuten tyhjiä tai päiväyksien kohdalla muita kuin numeroita, tai virheellisiä päiviä kuten esim 30 helmikuuta.

## Sovellukseen jääneet laatuongelmat
 * Jos luku/kirjoitusoikeudet ovat puutteelliset, ei tule järkeviä virheilmoituksia.

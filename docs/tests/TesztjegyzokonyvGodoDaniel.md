# Tesztjegyzőkönyv-Főoldal

Az alábbi tesztdokumentum a film projekthez tartozó Főoldal és színész hozzáadása funkcióihoz készült. Felelőse: Godó Dániel

## 1. Teszteljárások (TP)

### 1.1. Navbár tesztelése a főoldalra
- Azonosító: TP-01
- Tesztesetek: TC-01
- Leírás: Föoldal elem tesztelése a navigációban
    0. lépés: Nyissuk meg az alkalmazást
    1. lépés: Ha a főoldalon vagyunk éppen, akkor vátsunk egy másik oldalra a legfelül lévő navigáció segítségével. Ilyenkor látjuk, hogy a navigáción is jelzi, hogy elhagytuk a főoldalt
    2. lépés: Kattintsunk vissza a navigáción a Főoldalra elemre
    3. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: Főoldal megjelenítése

### 1.2. Top 10 film megjelenítése
- Azonosító: TP-02
- Tesztesetek: TC-02, TC-03
- Leírás: Filmek megjelenítésének tesztelése
    0. lépés: A Top 10 film cím alatt láthatunk pár filmet
    1. lépés: Az egér húzásával vagy amegfelelő oldalon lévő (bal és jobb oldal) nyilak kattintásával tudjuk a többi filmet megnézni
    2. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: Összesen 10 db filmet látunk értékelés alapján csökkenő sorrendben a filmek húzás vagy a nyilak megfelelő irányába kattintássa után

### 1.3. Film interakció
- Azonosító: TP-03
- Tesztesetek: TC-04, TC-05
- Leírás: Kiválasztott film interakciójának tesztelése
    0. lépés: Válasszunk ki egy filmet a listából és vigyük rá az egeret
    1. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: Zoom efektus és szöveg szín változása az adott filmen
    2. lépés: Ezután kattintsunk rá a filmre
    3. lépés. Ellenőrizzük az eredményt. Elvárt eredmény: Megnyitja a kiválasztott filmet egy másik oldalon. A fenti navigáción a Filmek elem fehér szöveggel jelzi, hogy meg van nyitva a film.

### 1.4. Top 10 sorozat megjelenítése
- Azonosító: TP-04
- Tesztesetek: TC-06, TC-07
- Leírás: Sorozatok megjelenítésének tesztelése
    0. lépés: A Top 10 sorozat cím alatt láthatunk pár sorozatot
    1. lépés: Az egér húzásával vagy amegfelelő oldalon lévő (bal és jobb oldal) nyilak kattintásával tudjuk a többi sorozatot megnézni
    2. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: Összesen 10 db sorozatot látunk értékelés alapján csökkenő sorrendben húzás vagy a nyilak megfelelő irányába kattintássa után

### 1.5. Sorozat interakció
- Azonosító: TP-05
- Tesztesetek: TC-08, TC-09
- Leírás: Kiválasztott sorozat interakciójának tesztelése
    0. lépés: Válasszunk ki egy sorozatot a listából és vigyük rá az egeret
    1. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: Zoom efektus és szöveg szín változása az adott sorozaton
    2. lépés: Ezután kattintsunk rá a sorozatra
    3. lépés. Ellenőrizzük az eredményt. Elvárt eredmény: Megnyitja a kiválasztott sorozatot egy másik oldalon. A fenti navigáción a Sorozatok elem fehér szöveggel jelzi, hogy meg van nyitva a sorozat.

### 1.6. Footer megjelenítése
- Azonosító: TP-06
- Tesztesetek: TC-10
- Leírás: Footer megjelenítésének tesztelése
    0. lépés: Görgessünk le az oldal legaljára
    1. lépés: Itt láthatunk a weboldal készítőiről információkat
    2. lépés. Ellenőrizzük az eredményt. Elvárt eredmény: 5 név és 5 email cím látható, valamint a copyright

### 1.7. Értékelés hozzáadása filmhez
- Azonosító: TP-07
- Tesztesetek: TC-11
- Leírás: Értékelés hozzáadása
    0. lépés: Lépjünk be egy fiókba
    1. lépés: Kattintsunk egy filmre amit még nem értékeltünk a filmek oldalon
    2. lépés: Kattintsukn az értékelés hozzáadása gombra
    3. lépés: Válassza ki a számára megfelelő csillag mennyiséget.
    5. lépés: Kattintson a kék mentés gombra
    6. lépés. Ellenőrizzük az eredményt. Elvárt eredmény: Felül megjelenik egy zöld csík, benne ezzel a szöveggel: "Sikeresen értékelted a filmet!"

### 1.8. Értékelés törlése filmnél
- Azonosító: TP-08
- Tesztesetek: TC-12
- Leírás: Értékelés törlése
    0. lépés: Lépjünk be egy fiókba
    1. lépés: Kattintsunk egy filmre amit már értékeltünk a filmek oldalon
    2. lépés: Kattintsunk az értékelés hozzáadása gombra
    3. lépés: Kattintson a piros értékelés törlése gombra
    4. lépés. Ellenőrizzük az eredményt. Elvárt eredmény: Felül megjelenik egy zöld csík, benne ezzel a szöveggel: "Sikeresen törölted az értékelést!"

### 1.9. Értékelés módosítása filmnél
- Azonosító: TP-09
- Tesztesetek: TC-13
- Leírás: Értékelés módosítása
    0. lépés: Lépjünk be egy fiókba
    1. lépés: Kattintsunk egy filmre amit már értékeltünk a filmek oldalon
    2. lépés: Kattintsunk az értékelés hozzáadása gombra
    3. lépés: Változtassunk a csillagokon kattintással
    4. lépés: Kattintsunk a kék mentés gombra
    4. lépés. Ellenőrizzük az eredményt. Elvárt eredmény: Felül megjelenik egy zöld csík, benne ezzel a szöveggel: "Sikeresen módosítottad az értékelést!"

## 2. Teszesetek (TC)

### 2.1. Navbár tesztesete

#### 2.1.1 TC-01
- TP: TP-01
- Leírás: Navbár funkció tesztelése
- Bemenet: Kattintás
- Művelet: Nyomjuk meg az Főoldal elemet
- Elvárt kimenet: Főoldal megjelenítése és a navigáción fehér szövegszínnel jelzi, hogy a Főoldalon vagyunk

### 2.2. Top 10 film megjelenítésének tesztesetei

#### 2.2.1 TC-02
- TP: TP-02
- Leírás: Top 10 film megjelenítés húzásának tesztelése
- Bemenet: Kattintás és húzás
- Művelet: Kattintsunk és húzzuk az elemet jobbra vagy balra 
- Elvárt kimenet: További filmek megjelenése (10 film van összesen)

#### 2.2.2 TC-03
- TP: TP-02
- Leírás: Top 10 film megjelenítés kattintásának tesztelése
- Bemenet: Kattintás
- Művelet: Kattintsunk a jobb vagy bal oldali nyílra 
- Elvárt kimenet: További filmek megjelenése (10 film van összesen)

### 2.3. Film interakció tesztesetei

#### 2.3.1 TC-04
- TP: TP-03
- Leírás: Film egér ráhúzás tesztelése
- Bemenet: Egér húzás
- Művelet: Vigyük rá az egeret egy filmre
- Elvárt kimenet: Zoom efekt és szöveg szín váltás az adott filmen

#### 2.3.2 TC-05
- TP: TP-03
- Leírás: Film megnyitásának tesztelése
- Bemenet: Kattintás
- Művelet: Kattintsunk rá egy filmre
- Elvárt kimenet: Új oldalon megjelenik az adott film és annak információi

### 2.4. Top 10 sorozat megjelenítésének tesztesetei

#### 2.4.1 TC-06
- TP: TP-04
- Leírás: Top 10 sorozat megjelenítés húzásának tesztelése
- Bemenet: Kattintás és húzás
- Művelet: Kattintsunk és húzzuk az elemet jobbra vagy balra 
- Elvárt kimenet: További sorozatok megjelenése (10 sorozat van összesen)

#### 2.4.2 TC-07
- TP: TP-04
- Leírás: Top 10 sorozat megjelenítés kattintásának tesztelése
- Bemenet: Kattintás
- Művelet: Kattintsunk a jobb vagy bal oldali nyílra 
- Elvárt kimenet: További sorozatok megjelenése (10 sorozat van összesen)

### 2.5. Sorozat interakció tesztesetei

#### 2.5.1 TC-08
- TP: TP-05
- Leírás: Film egér ráhúzás tesztelése
- Bemenet: Egér húzás
- Művelet: Vigyük rá az egeret egy sorozatra
- Elvárt kimenet: Zoom efekt és szöveg szín váltás az adott sorozaton

#### 2.5.2 TC-09
- TP: TP-05
- Leírás: Sorozat megnyitásának tesztelése
- Bemenet: Kattintás
- Művelet: Kattintsunk rá egy sorozatra
- Elvárt kimenet: Új oldalon megjelenik az adott sorozat és annak információi

### 2.6. Footer megjelenítése tesztesete

#### 2.6.1 TC-10
- TP: TP-06
- Leírás: Footer megjelenésének tesztelése
- Bemenet: Görgetés
- Művelet: Görgessünk le az oldal legaljára
- Elvárt kimenet: Látjuk a weboldal készítőit és adatait, valamint a copyrightot

### 2.7. Értékelések tesztesete

#### 2.7.1 TC-11
- TP: TP-07
- Leírás: Értékelés hozzáadásának tesztelése
- Bemenet: kattintás
- Művelet: kattintsunk a csillagra, majd a kék mentés gombra
- Elvárt kimenet: Zöld üzenet felül, benne ezzel a szöveggel: "Sikeresen értékelted a filmet!"

#### 2.7.2 TC-12
- TP: TP-08
- Leírás: Értékelés törlésének tesztelése
- Bemenet: kattintás
- Művelet: kattintsunk a törlés gombra
- Elvárt kimenet: Zöld üzenet felül, benne ezzel a szöveggel: "Sikeresen törölted az értékelést!"

#### 2.7.3 TC-13
- TP: TP-09
- Leírás: Értékelés módosításának tesztelése
- Bemenet: kattintás
- Művelet: kattintsunk egy csilalgra, majd a kék mentés gombra
- Elvárt kimenet: Zöld üzenet felül, benne ezzel a szöveggel: "Sikeresen törölted az értékelést!"

## 3. Tesztriportok (TR)

### 3.1. Navbár a főoldalra tesztriportja

#### 3.1.1. TR-01 (TC-01)
- TP: TP-01
    1. lépés: Másik oldalra váltottam a főoldalról a navigáción
    2. lépés: Vissza váltottam a Főoldalra a navigáción
    3. lépés: Megnyílt a Főoldal és a navigáción fehér szöveggel jelezte, hogy a Főoldalon tartózkodom
    4. lépés: Helyes eredményt kaptam (Főoldal megjelenítése)

### 3.2. Top 10 film megjelenítésének tesztriportjai

#### 3.2.1. TR-02 (TC-02)
- TP: TP-02
    1. lépés: Kattintottam és húztam a listát 
    2. lépés: Helyes eredményt kaptam (10 film volt)

#### 3.2.2. TR-03 (TC-03)
- TP: TP-02
    1. lépés: Rákattintottam a nyilakra 
    2. lépés: Helyes eredményt kaptam (10 film volt)

### 3.3. Film interakció tesztriportjai

#### 3.3.1. TR-04 (TC-04)
- TP: TP-03
    1. lépés: Rávittem az egeret egy filmre 
    2. lépés: Helyes eredményt kaptam (Zoom efekt és szöveg szín változás)

#### 3.3.2. TR-05 (TC-05)
- TP: TP-03
    1. lépés: Rákattintottam egy filmre 
    2. lépés: Helyes eredményt kaptam (új oldalon megnyílt a film és annak információi)

### 3.4. Top 10 sorozat megjelenítésének tesztriportjai

#### 3.4.1. TR-06 (TC-06)
- TP: TP-04
    1. lépés: Kattintottam és húztam a listát 
    2. lépés: Helyes eredményt kaptam (10 sorozat volt)

#### 3.4.2. TR-07 (TC-07)
- TP: TP-04
    1. lépés: Rákattintottam a nyilakra 
    2. lépés: Helyes eredményt kaptam (10 sorozat volt)

### 3.5. Sorozat interakció tesztriportjai

#### 3.5.1. TR-08 (TC-08)
- TP: TP-05
    1. lépés: Rávittem az egeret egy sorozatra 
    2. lépés: Helyes eredményt kaptam (Zoom efekt és szöveg szín változás)

#### 3.5.2. TR-09 (TC-09)
- TP: TP-05
    1. lépés: Rákattintottam egy sorozatra 
    2. lépés: Helyes eredményt kaptam (új oldalon megnyílt a sorozat és annak információi)

### 3.6. Footer megjelenítése tesztriportja

#### 3.6.1. TR-10 (TC-10)
- TP: TP-06
    1. lépés: Legörgettem az oldal legaljára
    2. lépés: Helyes eredményt kaptam (Láttam a készítőket és adatait, valamint a copyrightot)

### 3.7. Értékelések tesztriportja

#### 3.7.1. TR-11 (TC-11)
- TP: TP-07
    1. lépés: Kattintottam a gombra, csilalgra, majd a mentés gombra
    2. lépés: Helyes eredményt kaptam (Láttam a zöld csíkot és a "Sikeresen értékelted a filmet!" üzenetet)

#### 3.7.2. TR-12 (TC-12)
- TP: TP-08
    1. lépés: Kattintottam a gombra, majd az értékelés törlése gombra
    2. lépés: Helyes eredményt kaptam (Láttam a zöld csíkot és a "Sikeresen törölted az értékelést!" üzenetet)

#### 3.7.3. TR-13 (TC-13)
- TP: TP-09
    1. lépés: Kattintottam a gombra, módosítottam a csilalgon, majd kattintottam a mentés gombra
    2. lépés: Helyes eredményt kaptam (Láttam a zöld csíkot és a "Sikeresen törölted az értékelést!" üzenetet)
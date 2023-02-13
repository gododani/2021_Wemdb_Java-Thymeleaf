# Tesztjegyzőkönyv-Film

Az alábbi tesztdokumentum a film projekthez tartozó film oldal gombjaihoz és műfajok szerinti szűrés funkcióikhoz készült. Felelőse: Lengyel Norbert Péter 

## 1. Teszteljárások (TP)

### 1.1. Értékelés hozzáadása gomb megjelenítése belépés nélkül funkció tesztelése
- Azonosító: TP-01
- Tesztesetek: TC-01
- Leírás: Értékelés hozzáadása gomb megjelenítése belépés nélkül funkció tesztelése
    0. lépés: a kívánt film oldal megjelenítése
    1. lépés: a film index képe alatt az Értékelés hozzáadása gomb nem jelenik meg
    2. lépés: Elvárt eredmény: jogosultság miatt nem jelenik meg az Értékelés hozzáadása gomb

### 1.2. Értékelés hozzáadása gomb megjelenítése belépéssel funkció tesztelése
- Azonosító: TP-02
- Tesztesetek: TC-02
- Leírás: Értékelés hozzáadása gomb megjelenítése belépéssel funkció tesztelése
    0. lépés: a belépés fülre kattintva lépjünk be a saját felhasználónév jelszó párosunkkal
    1. lépés: a kívánt film oldal megjelenítése
    2. lépés: a film index képe alatt az Értékelés hozzáadása gomb megjelenik
    3. lépés: Elvárt eredmény: jogosultság hiánya miatt megjelenik meg az Értékelés hozzáadása gomb

### 1.3. Kritika írása gomb megjelenítése belépés nélkül funkció tesztelése
- Azonosító: TP-03
- Tesztesetek: TC-03
- Leírás: Kritika írása gomb megjelenítése belépés nélkül funkció tesztelése
    0. lépés: a kívánt film oldal megjelenítése
    1. lépés: a film index képe alatt az Kritika írása gomb nem jelenik meg
    2. lépés: Elvárt eredmény: jogosultság hiánya miatt nem jelenik meg az Kritika írása gomb

### 1.4. Kritika írása gomb megjelenítése sima felhasználós belépéssel funkció tesztelése
- Azonosító: TP-04
- Tesztesetek: TC-04
- Leírás: Kritika írása gomb megjelenítése sima felhasználós belépéssel funkció tesztelése
    0. lépés: a belépés fülre kattintva lépjünk be a saját felhasználónév jelszó párosunkkal
    1. lépés: a kívánt film oldal megjelenítése
    2. lépés: a film index képe alatt az Kritika írása gomb nem jelenik meg
    3. lépés: Elvárt eredmény: a sima felhasználóknak nincs jogosultsága a kritika írásához ezért a Kritika írása gomb nem jelenik meg

### 1.5. Kritika írása gomb megjelenítése admin és kritikus felhasználós belépéssel funkció tesztelése
- Azonosító: TP-05
- Tesztesetek: TC-05, TC-06
- Leírás: Kritika írása gomb megjelenítése admin és kritikus felhasználós belépéssel funkció tesztelése
    0. lépés: a belépés fülre kattintva lépjünk be a saját felhasználónév jelszó párosunkkal
    1. lépés: a kívánt film oldal megjelenítése
    2. lépés: a film index képe alatt az Kritika írása gomb megjelenik
    3. lépés: Elvárt eredmény: az admin és kritikus felhasználóknak van jogosultsága a kritika írásához ezért a Kritika írása gomb megjelenik

### 1.6. Műfajok szerinti szűrés funkció tesztelése
- Azonosító: TP-06
- Tesztesetek: TC-07, TC-08
- Leírás: Kritika írása gomb megjelenítése admin és kritikus felhasználós belépéssel funkció tesztelése
    0. lépés: olyan oldal megnyitása, ahol a navigációs bár elérhető
    1. lépés: szűrés lenyíló fülre kíttintunk
    2. lépés: kiválasztjuk a kívánt műfajt
    3. lépés: Elvárt eredmény: filmek listázása, amennyiben van az adott műfajjal rendelkező film/sorozat

## 2. Teszesetek (TC)

### 2.1. Értékelés hozzáadása gomb megjelenítése belépés nélkül funkció tesztesetei

#### 2.1.1. TC-01
- TP: TP-01
- Leírás: Értékelés hozzáadása gomb megjelenítése belépés nélkül funkció tesztelése
- Bemenet: kattint
- Művelet: kattint egy filmre
- Elvárt kimenet: Értékelés hozzáadása gomb rejtve marad


### 2.2. Értékelés hozzáadása gomb megjelenítése belépéssel funkció tesztesetei

#### 2.2.1. TC-02
- TP: TP-02
- Leírás: Értékelés hozzáadása gomb megjelenítése belépéssel funkció tesztelése
- Bemenet: kattint
- Művelet: kattint egy filmre
- Elvárt kimenet: Értékelés hozzáadása gomb megjelenik

### 2.3. Kritika írása gomb megjelenítése belépés nélkül funkció tesztesetei

#### 2.3.1. TC-03
- TP: TP-03
- Leírás: Kritika írása gomb megjelenítése belépés nélkül funkció tesztelése
- Bemenet: kattint
- Művelet: kattint egy filmre
- Elvárt kimenet: Kritika írása gomb rejtve marad

### 2.4. Kritika írása gomb megjelenítése sima felhasználós belépéssel funkció tesztesetei

#### 2.4.1. TC-04
- TP: TP-04
- Leírás: Kritika írása gomb megjelenítése sima felhasználós belépéssel funkció tesztelése
- Bemenet: kattint
- Művelet: kattint egy filmre
- Elvárt kimenet: Kritika írása gomb rejtve marad

### 2.5. Kritika írása gomb megjelenítése admin és kritikus felhasználós belépéssel funkció tesztesetei

#### 2.5.1. TC-05
- TP: TP-05
- Leírás: Kritika írása gomb megjelenítése admin felhasználós belépéssel funkció tesztelése
- Bemenet: kattint
- Művelet: kattint egy filmre
- Elvárt kimenet: Kritika írása gomb megjelenik

#### 2.5.2. TC-06
- TP: TP-05
- Leírás: Kritika írása gomb megjelenítése kritikus felhasználós belépéssel funkció tesztelése
- Bemenet: kattint
- Művelet: kattint egy filmre
- Elvárt kimenet: Kritika írása gomb megjelenik

### 2.6. Műfajok szerinti szűrés funkció tesztesetei

#### 2.6.1. TC-07
- TP: TP-06
- Leírás: Műfajok szerinti szűrés, ha nincs film/sorozat a keresett műfajjal funkció tesztelése
- Bemenet: kattint
- Művelet: kattint a szűrés gombra, majd egy műfajra
- Elvárt kimenet: A következő üzenet jelenik meg: "Ezzel a feltétellel egy film vagy sorozat sincs a rendszerben. Próbálj más feltétellel keresni."

#### 2.6.2. TC-08
- TP: TP-06
- Leírás: Műfajok szerinti szűrés, ha van film/sorozat a keresett műfajjal funkció tesztelése
- Bemenet: kattint
- Művelet: kattint a szűrés gombra, majd egy műfajra
- Elvárt kimenet: Filmek/Sorozatok listázása az adott műfajjal

## 3. Tesztriportok (TR)

### 3.1. Értékelés hozzáadása gomb megjelenítése belépés nélkül funkció tesztriportjai

#### 3.1.1. TR-01 (TC-01)
- TP: TP-01
    1. lépés: filmek oldalon endgame További információk gombra kattintottam
    2. lépés: az Értékelés hozzáadása gomb nem jelent meg
    
### 3.2. Értékelés hozzáadása gomb megjelenítése belépéssel funkció tesztriportjai

#### 3.2.1. TR-02 (TC-02)
- TP: TP-02
    1. lépés: bejelentkeztem a belépés oldalon
    2. lépés: filmek oldalon endgame További információk gombra kattintottam
    3. lépés: az Értékelés hozzáadása gomb megjelent

### 3.3. Kritika írása gomb megjelenítése belépés nélkül funkció tesztriportjai

#### 3.3.1. TR-03 (TC-03)
- TP: TP-03
    1. lépés: filmek oldalon endgame További információk gombra kattintottam
    2. lépés: az Kritika írása gomb nem jelent meg

### 3.4. Kritika írása gomb megjelenítése sima felhasználós belépéssel funkció tesztriportjai

#### 3.4.1. TR-04 (TC-04)
- TP: TP-04
    1. lépés: bejelentkeztem a belépés oldalon (sima felhasználóval)
    2. lépés: filmek oldalon endgame További információk gombra kattintottam
    3. lépés: a Kritika írása gomb nem jelent meg

### 3.5. Kritika írása gomb megjelenítése admin és kritikus felhasználós belépéssel funkció tesztriportjai

#### 3.5.1. TR-05 (TC-05)
- TP: TP-05
    1. lépés: bejelentkeztem a belépés oldalon (admin felhasználóval)
    2. lépés: filmek oldalon endgame További információk gombra kattintottam
    3. lépés: a Kritika írása gomb megjelent

#### 3.5.2. TR-06 (TC-06)
- TP: TP-05
    1. lépés: bejelentkeztem a belépés oldalon (kritikus felhasználóval)
    2. lépés: filmek oldalon endgame További információk gombra kattintottam
    3. lépés: a Kritika írása gomb megjelent

### 3.6. Műfajok szerinti szűrés funkció tesztriportjai

#### 3.6.1. TR-07 (TC-07)
- TP: TP-06
    1. lépés: rákattintottam a szűrés gombra
    2. lépés: kiválasztottam a dokumentum műfajt
    3. lépés: a következő üzenet jelent meg: "Ezzel a feltétellel egy film vagy sorozat sincs a rendszerben. Próbálj más feltétellel keresni."

#### 3.6.2. TR-08 (TC-08)
- TP: TP-06
    1. lépés: rákattintottam a szűrés gombra
    2. lépés: kiválasztottam az akció műfajt
    3. lépés: az akció műfajjal rendelkező filmek/sorozatok listázásra kerültek
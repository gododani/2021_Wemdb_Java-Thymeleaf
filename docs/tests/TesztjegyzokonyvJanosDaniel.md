# Tesztjegyzőkönyv-Felhasználó létrehozása

Az alábbi tesztdokumentum a Film projekthez tartozó 9.3.1. Felhasználó létrehozása és filmek keresése funkciókhoz készült. Felelőse: János Dániel

## 1. Teszteljárások (TP)

### 1.1. Felhasználó létrehozása funkció tesztelése 
- Azonosító: TP-01
- Tesztesetek: TC-01, TC-02, TC-03
- Leírás: Felhasználó létrehozása funkció tesztelése
    0. lépés: Nyissuk meg az alkalmazást, majd kattintsunk a belépésre végül a regisztráljon itt feliratra
    1. lépés: Az Felhasználónév szövegbeviteli mezőbe írjunk be a $felhasználónév szöveget
    2. lépés: Az Email szövegbeviteli mezőbe írjunk be a $email szöveget
    3. lépés: Az Jelsó szövegbeviteli mezőbe írjunk be a $jelszó szöveget
    4. lépés: Az Jelszó újra szövegbeviteli mezőbe írjunk be a $jelszó2 szöveget
    5. lépés: Nyomjuk meg az Regisztráció gombot 
    6. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: $visszajelzes

### 1.2. Filmek keresése funkció tesztelése 
- Azonosító: TP-02
- Tesztesetek: TC-01, TC-02, TC-03
- Leírás: Filmek keresése funkció tesztelése
    0. lépés: Nyissuk meg az alkalmazást, majd a kereső mezőbe gépeljük be a $szöveg szöveget
    1. lépés: Nyomjuk meg az Keresés gombot 
    2. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: $visszajelzes    

## 2. Teszesetek (TC)

### 2.1. Felhasználó létrehozása tesztesetei

#### 2.1.1. TC-01
- TP: TP-01
- Leírás: Felhasználó létrehozása funkció tesztelése 
- Bemenet: $felhasználónév = tesztuser ; $email = tesztuser@mail.com ; $jelszó = Test1234 ; $jelszó2 = Test1234
- Művelet: nyomjuk meg az Regisztracio gombot 
- Elvárt kimenet: az eredmény mező tartalma: $visszajelzes = Sikeres regisztráció

#### 2.1.2. TC-02
- TP: TP-01
- Leírás: Felhasználó létrehozása funkció tesztelése 
- Bemenet: $felhasználónév = tesztuser2 ; $email = tesztuser2@mail.com ; $jelszó = Test1234 ; $jelszó2 = Test1235
- Művelet: nyomjuk meg az Regisztracio gombot
- Elvárt kimenet: az eredmény mező tartalma: $visszajelzes = HIBA (Jelszónak egyeznie kell!)

#### 2.1.3. TC-03
- TP: TP-01
- Leírás: Felhasználó létrehozása funkció tesztelése  
- Bemenet: $felhasználónév = tesztuser2 ; $email = (üres input) ; $jelszó = Test1234 ; $jelszó2 = Test1234
- Művelet: nyomjuk meg az Regisztracio gombot
- Elvárt kimenet: az eredmény mező tartalma: $visszajelzes = HIBA ($email = Email nem lehet üres!)

#### 2.2.1. TC-01
- TP: TP-02
- Leírás: Filmek keresése funkció tesztelése  
- Bemenet: $szöveg = venom
- Művelet: nyomjuk meg az Keresés gombot
- Elvárt kimenet: az eredmény oldal tartalma: Olyan film vagy sorozatok listája aminek része a venom szó. SIKER

#### 2.2.2. TC-02
- TP: TP-02
- Leírás: Filmek keresése funkció tesztelése  
- Bemenet: $szöveg = la
- Művelet: nyomjuk meg az Keresés gombot
- Elvárt kimenet: az eredmény mező tartalma: $visszajelzes = HIBA ($szöveg = Legalább 3 karakternek kell lennie az szövegnek))

#### 2.2.3. TC-03
- TP: TP-02
- Leírás: Filmek keresése funkció tesztelése  
- Bemenet: $szöveg = pesti
- Művelet: nyomjuk meg az Keresés gombot
- Elvárt kimenet: az eredmény oldal tartalma: Visszajelzés, hogy nem található ilyen rész szöveggel egyetlen film vagy sorozat sem. SIKER


## 3. Tesztriportok (TR)

### 3.1. Felhasználó létrehozása tesztriportjai

#### 3.1.1. TR-01 (TC-01)
- TP: TP-01
    1. lépés: tesztuser-t beírtam
    2. lépés: tesztuser@mail.com-t beírtam 
    3. lépés: Test1234-t beírtam 
    4. lépés: Test1234-t beírtam 
    5. lépés: a gomb egyszeri megnyomás után feldolgozta az adatokat
    6. lépés: helyes eredményt kaptam (Sikeres regisztráció)
    
#### 3.1.2. TR-01 (TC-02)
- TP: TP-01
    1. lépés: tesztuser2-t beírtam
    2. lépés: tesztuser2@mail.com-t beírtam 
    3. lépés: Test1234-t beírtam 
    4. lépés: Test125-t beírtam 
    5. lépés: a gomb egyszeri megnyomás után feldolgozta az adatokat
    6. lépés: helyes eredményt kaptam (Jelszónak egyeznie kell!)

#### 3.1.3. TR-01 (TC-03)
- TP: TP-01
    1. lépés: tesztuser2-t beírtam
    2. lépés: a mezőt üresen hagytam
    3. lépés: Test1234-t beírtam 
    4. lépés: Test1234-t beírtam 
    5. lépés: a gomb egyszeri megnyomás után feldolgozta az adatokat
    6. lépés: helyes eredményt kaptam (Email nem lehet üres!)

#### 3.2.1. TR-02 (TC-01)
- TP: TP-02
    1. lépés: beírtam a venom szót
    2. lépés: a gomb egyszeri megnyomás után átnavigált az oldalra
    3. lépés: helyes eredményt kaptam (Kilistázta azokat a filmeket vagy sorozatokat, aminek a címében szerepel a venom!)

#### 3.2.2. TR-02 (TC-02)
- TP: TP-02
    1. lépés: beírtam a la szót
    2. lépés: a gomb egyszeri megnyomás után megjelent a hibaüzenet
    3. lépés: helyes eredményt kaptam (Nem történt keresés, további karaktert várt az input mezőbe)

#### 3.2.3. TR-02 (TC-03)
- TP: TP-02
    1. lépés: beírtam a pesti szót
    2. lépés: a gomb egyszeri megnyomás után átnavigált az oldalra
    3. lépés: helyes eredményt kaptam (Nem listázott filmeket, ugyanis nem szerepel ilyen rész szöveg egyetlen film címben sem)
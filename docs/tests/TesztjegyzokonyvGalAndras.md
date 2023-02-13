# Tesztjegyzőkönyv-FilmHozzaadasa

Az alábbi tesztdokumentum a FILM projekthez tartozó Film hozzáadás, illetve felhasználó kezelés funkcióihoz készült. Felelőse: Gál András 

 

 

## 1. Teszteljárások (TP)

### 1.1. Film, sorozat 
- Azonosító: TP-01
- Tesztesetek: TC-01
- Leírás: 
    0. lépés: Nyissuk meg az alkalmazást, lépjünk be adminként, és indítsuk el a FilmAdd funkciót
    1. lépés: Írjuk be a cim textboxba a $CIM stringet
    2. indexkep textboxba a $INDEXKEP stringet, amely tartalmazza az indexkép URLjét
    3. leiras textboxba a $LEIRAS stringet
    4. hossz textboxba a $HOSSZ integert percben
    5. mufaj textboxba a $MUFAJ stringet
    6. a premier dátummezőbe a $DATUM dátumot válasszuk ki
    7. a besorolas textboxba a $BESOROLAS stringet
    8. az evad és az epizodok inputokat hagyjuk üresen ha filmet írunk, ellekező esetben töltsük ki
    9. a tipus mezőbe írjuk be a $TIPUS stringet, ami film esetén "Film", sorozat esetén "Sorozat"
    10. nyomjuk meg a $FELVISZ gombot
    11. ellenőrizzük az eredményt: a film/sorozat megjelenik az adatbázisban, illetve a dilmek és sorozatok között.

### 1.2. Regisztráció
- Azonosító: TP-02
- Tesztesetek: TC-02, TC-03
- Leírás:
  0. lépés: Nyissuk meg az alkalmazást, és indítsuk el a Belépés funkcióban található Regisztráljon itt funkciót
  1. lépés: Írjuk be a felhasználónév textboxba a $FELHASZNALONEV stringet (legalább 3 karakter)
  2. email textboxba a $EMAIL stringet (email formátum)
  3. jelszo és jelszoujra textboxba a $JELSZO stringet, amelynek egyeznie kell (8 karakter legalább, kis és nagybetű, szám)
  4. nyomjuk meg a $FELVISZ gombot
  6. ellenőrizzük az eredményt: átirányít a belépés oldalra "Sikeres regisztráció" felirattal

### 1.2. Bejelentkezés
- Azonosító: TP-03
- Tesztesetek: TC-04
- Leírás:
  0. lépés: Nyissuk meg az alkalmazást,  és indítsuk el a Belépés funkciót
  1. lépés: Írjuk be a felhasználónév textboxba a $FELHASZNALONEV stringet (legalább 3 karakter)
  2. email textboxba a $EMAIL stringet (email formátum)
  3. jelszo textboxba a $JELSZO stringet (8 karakter legalább, kis és nagybetű, szám)
  4. nyomjuk meg a $FELVISZ gombot
  6. ellenőrizzük az eredményt: Főoldalra átirányít, jobb felső sarokban "Kijelentkezés" gomb megjelenik, profil ikon kattintható.

### 1.3. Profil
- Azonosító: TP-04
- Tesztesetek: TC-05, TC-06
- Leírás:
  0. lépés: Nyissuk meg az alkalmazást, lépjünk be, és indítsuk el a Profil funkciót
  1. lépés: Ellenőrizzük a Felhasználónév és Email mezőben feltűnő adatok helyességét
  2. írjuk be a felhasználónév textboxba az új $FELHASZNÁLÓNÉV stringet
  3. email textboxba a $EMAIL stringet (email formátum)
  4. jelszo és jelszoujra textboxba a $JELSZO stringet, egyezniük kell(8 karakter legalább, kis és nagybetű, szám)
  5. nyomjuk meg a $FELVISZ gombot
  6. ellenőrizzük az eredményt: Sikeres adatmódosítás után bejelentkezésre átirányít, újból belépve a profil a frissített
      adatokat jeleníti meg



## 2. Teszesetek (TC)

### 2.1. FilmAdd funkció tesztesetei

#### 2.1.1. TC-01
- TP: TP-01
- Leírás: Film Hozzáadás funkció tesztelése
- Bemenet: CIM = Ponyvaregény; HOSSZ = 155; MUFAJ = Crime Drama; stb;
- Művelet: nyomjuk meg az FELVISZ gombot 
- Elvárt kimenet: A film megjelent az adatbázisban illetve a Filmek között

### 2.2. Felhasználókezelés funkció tesztesetei

#### 2.1.1. TC-02
- TP: TP-02
- Leírás: Regisztráció funkció tesztelése
- Bemenet: FELHASZNALONEV: Andris013; EMAIL: galandras013@gmail.com; JELSZO: *titkosított*;
- Művelet: nyomjuk meg az FELVISZ gombot
- Elvárt kimenet: Az oldal átirányít a belépésre "Sikeres regisztráció" szöveggel

#### 2.1.2. TC-03
- TP: TP-02
- Leírás: Regisztráció funkció tesztelése már létező felhasználóra
- Bemenet: FELHASZNALONEV: Ismetles1; EMAIL: galandras013@gmail.com; JELSZO: *titkosított*;
- Művelet: nyomjuk meg az FELVISZ gombot
- Elvárt kimenet: Az oldal nem irányít át, "Már létezik felh. ezzel az emaillel" hibaüzenetet kapunk

#### 2.1.3. TC-04
- TP: TP-03
- Leírás: Bejelentkezés funkció tesztelése
- Bemenet: FELHASZNALONEV: Andris013; JELSZO: *titkosított*;
- Művelet: nyomjuk meg az FELVISZ gombot
- Elvárt kimenet: Átirányít a Főoldalra, "Kijelentkezés" menüpont megjelenik, Profil ikon kattintható

#### 2.1.4. TC-05
- TP: TP-04
- Leírás: Profil funkció tesztelése
- Bemenet: FELHASZNALONEV: Andris0131; EMAIL: gal.andras.gd@gmail.com; JELSZO: *titkosított*;
- Művelet: nyomjuk meg az FELVISZ gombot
- Elvárt kimenet: Átirányít a Bejelentkezésre, újból belépve, és profilt megnyitva a frissített adatokat látom

#### 2.1.5. TC-06
- TP: TP-04
- Leírás: Profil funkció tesztelése
- Bemenet: FELHASZNALONEV: Andris0131; EMAIL: gal.andras.gd@gmail.com; JELSZO: *titkosított*; (ismétlődő adatokkal)
- Művelet: nyomjuk meg az FELVISZ gombot
- Elvárt kimenet: Egy hibaüzenetet dob, nem irányít át sehova, régi adatokat látjuk



## 3. Tesztriportok (TR)

### 3.1. FilmAdd funkció tesztriportjai

#### 3.1.1. TR-01 (TC-01)
- TP: TP-01
    1. lépés: Mezőkbe a megfelelő értékeket beírtam
    2. FELVISZ gombot megnyomtam
    3. A gomb egyszeri megnyomás után inaktív lett
    4. A form felett "SIKERES HOZZÁADÁS" szöveg megjelent
    5. Helyes eredményt kaptam

### 3.2. Felhasználükezelés funkció tesztriportjai

#### 3.2.1. TR-02 (TC-02)
- TP: TP-02
  1. lépés: Mezőkbe a megfelelő értékeket beírtam
  2. FELVISZ gombot megnyomtam
  3. A gomb egyszeri megnyomás után inaktív lett
  4. Belépésre átirányított, "Sikeres regisztráció" szöveget megkaptam
  5. Helyes eredményt kaptam

#### 3.2.2. TR-03 (TC-03)
- TP: TP-02
  1. lépés: Mezőkbe a megfelelő értékeket beírtam
  2. FELVISZ gombot megnyomtam
  3. A gomb egyszeri megnyomás után inaktív lett
  4. Nem irányított át a belépésre,"Már létezik felh. ezzel az emaillel" szöveget megkaptam
  5. Helyes eredményt kaptam

#### 3.2.3. TR-04 (TC-04)
- TP: TP-03
  1. lépés: Mezőkbe a megfelelő értékeket beírtam
  2. FELVISZ gombot megnyomtam
  3. A gomb egyszeri megnyomás után inaktív lett
  4. Átirányított a föoldalra, "Kijelentkezés" menüpont megjelent, profil ikon kattintható
  5. Helyes eredményt kaptam

#### 3.2.4. TR-05 (TC-05)
- TP: TP-04
  1. lépés: Mezőkbe a megfelelő értékeket beírtam
  2. FELVISZ gombot megnyomtam
  3. A gomb egyszeri megnyomás után inaktív lett
  4. Átirányított a bejelentkezésre, beléptem, profilt megnyitottam, frissített adatokat láttam
  5. Helyes eredményt kaptam

#### 3.2.6. TR-06 (TC-06)
- TP: TP-04
  1. lépés: Mezőkbe a megfelelő értékeket beírtam
  2. FELVISZ gombot megnyomtam
  3. A gomb egyszeri megnyomás után inaktív lett
  4. Nem irányított át, hibaüzenetet kaptam az adatok hibásságáról, régi adatokat láttam az oldalon megjelenve
  5. Helyes eredményt kaptam
    



    
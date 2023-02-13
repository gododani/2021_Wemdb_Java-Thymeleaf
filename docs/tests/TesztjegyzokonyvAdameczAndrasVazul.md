# Tesztjegyzőkönyv-FilmHozzaadasa

Az alábbi tesztdokumentum a filmek kezelésének és tesztelése. Felelőse: Adamecz Andras Vazul





## 1. Teszteljárások (TP)

### 1.1. Filmek listazasa tesztelése
- Azonosító: TP-01
- Tesztesetek: TC-01
- Leírás:
    0. lépés: Nyissuk meg az alkalmazást (bejelentkezés nem kell most)
    1. lépés: Ellenőrizzük hogy a Top 10 film és sorozat az értékelések alapján jelenek meg.
    2. lépés: Navigáljunk a Filmek menü pontra
    3. lépés: Ellenőrizzük hogy csak filmek jelenek meg.
    4. lépés: Vigyük az egeret valamelyik filmre és ellenőrizzük hogy a filmnek jók a leírása.
    5. lépés: Vigyük az egeret valamelyik filmre és menyünk a További Információra leírása.
    6. lépés: Ellenőrizzük hogy jó filmen vagyunk és az oldalon jók a leírások.



### 1.2.Sorozatok listazasa tesztelése
- Azonosító: TP-02
- Tesztesetek: TC-02, TC-03
- Leírás:
  0. lépés: Nyissuk meg az alkalmazást (bejelentkezés nem kell most)
  1. lépés: Ellenőrizzük hogy a Top 10 film és sorozat az értékelések alapján jelenek meg és a leírásuk is jók-e.
  2. lépés: Navigáljunk a sorozatok menü pontra
  3. lépés: Ellenőrizzük hogy csak sorozatok jelenek meg.
  4. lépés: Vigyük az egeret valamelyik sorozatok és ellenőrizzük hogy a sorozatok jók a leírása.
  5. lépés: Vigyük az egeret valamelyik sorozatok és menyünk a További Információra leírása.
  6. lépés: Ellenőrizzük hogy jó sorozatok vagyunk és az oldalon jók a leírások.


## 2. Tesztesetek (TC)
#### 2.1.1. TC-01
- TP: TP-01
- Top 10 film: Last Night in Soho, Endgame, The Green Mile....
- Leírás: Csillag=5,4,2.3;Hossz=120,180,188;Besorolas=PG-16,PG-16,PG-16;
- Művelet: Navigáljunk a Filmek menü pontra
- Elvárt kimenet: https://film-ib153l-1-2021.herokuapp.com/filmek
- Művelet: Vigyük az egeret Endgame és menyünk a További Információra leírása.
- Elvárt kimenet: https://film-ib153l-1-2021.herokuapp.com/film/8
### 2.2. Felhasználókezelés funkció tesztesetei

#### 2.1.1. TC-02
- TP: TP-02
- Top 10 sorozat: Csernobil,The Punisher, Breaking Bad
- Leírás: Csillag=4.7,4.3,4.7;Évad Szám=1,2,5;Besorolas=PG-18,PG-18,PG-16;
- Művelet: Navigáljunk a Sorozatok menü pontra
- Elvárt kimenet: https://film-ib153l-1-2021.herokuapp.com/sorozatok
- Művelet: Vigyük az egeret a Csernobilra és menyünk a További Információra leírása.
- Elvárt kimenet: https://film-ib153l-1-2021.herokuapp.com/sorozat/20

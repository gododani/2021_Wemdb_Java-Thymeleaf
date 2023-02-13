package com.example.film.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Data

@Entity
@Table(name = "film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long FilmId;
    @NotEmpty(message = "Cím nem lehet üres!")
    @Size(max = 255, message = "Maximum 255 karakter lehet a cím!")
    private String cim;
    @NotEmpty(message = "Indexkép nem lehet üres!")
    @Size(max = 255, message = "Maximum 255 karakter lehet az indexkép!")
    private String indexKep;
    @Column(length = 999)
    @NotEmpty(message = "Leírás nem lehet üres!")
    //@Size(max = 255, message = "Maximum 999 karakter lehet a leírás!")
    private String leiras;
    //@Size(min = 1, max = 600, message = "Minimum 1 és maximum 600 perc közötti intervallumot adj meg!")
    @Min(value = 1, message = "Minimum 1 és maximum 600 perc közötti intervallumot adj meg!")
    @Max(value = 600, message = "Minimum 1 és maximum 600 perc közötti intervallumot adj meg!")
    private long hossz;
    @NotEmpty(message = "Műfaj nem lehet üres!")
    @Size(max = 255, message = "Maximum 255 karakter lehet a műfaj!")
    private String mufaj;
    private Date premier;
    private Date befejezes;
    @NotEmpty(message = "Besorolas nem lehet üres!")
    @Size(min = 5, max = 15, message = "Minimum 5, maximum 15 karakter.")
    private String besorolas;
    @Min(value = 0, message = "0 és 100 közötti számot adj meg! (A filmek esetében 0)")
    @Max(value = 100, message = "0 és 100 közötti számot adj meg! (A filmek esetében 0)")
    private int evad;
    @Min(value = 0, message = "0 és 1000 közötti számot adj meg! (A filmek esetében 0)")
    @Max(value = 1000, message = "0 és 1000 közötti számot adj meg! (A filmek esetében 0)")
    private int epizodok;
    @NotEmpty(message = "A típus nem lehet üres!")
    private String tipus;
    @ManyToMany(mappedBy = "directedFilm")
    private List<Director> directors = new ArrayList<>();
    @ManyToMany(mappedBy = "writtenFilm")
    private List<Writer> writers = new ArrayList<>();

    @ManyToMany
    private List<Actor> actors;

    public void addDirector(Director director) { directors.add(director); }

    public void addWriter(Writer writer) { writers.add(writer); }

    public int getPremierYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(premier);
        return calendar.get(Calendar.YEAR);
    }

    public int getBefejezesYear() {
        if(befejezes == null) return 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(befejezes);
        return calendar.get(Calendar.YEAR);
    }
}

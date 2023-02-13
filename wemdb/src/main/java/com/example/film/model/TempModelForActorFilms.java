package com.example.film.model;

import lombok.Data;

@Data
public class TempModelForActorFilms {
    private String partName;
    private Long actorName;

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public Long getActorName() {
        return actorName;
    }

    public void setActorName(Long actorName) {
        this.actorName = actorName;
    }
}

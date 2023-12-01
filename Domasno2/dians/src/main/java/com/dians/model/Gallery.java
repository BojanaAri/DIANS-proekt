package com.dians.model;

import lombok.Data;

@Data
public class Gallery {
    double lat;
    double lon;
    String name;
    String address;
    String working_hours;

    public Gallery(double lat, double lon, String name, String address, String working_hours) {
        this.lat = lat;
        this.lon = lon;
        this.name = name;
        this.address = address;
        this.working_hours = working_hours;
    }
}

//        "lat": "42.0062442315",
//        "lon": "20.9674207726",
//        "name": "Национална Установа Уметничка Галерија",
//        "adress": "Адреса: Илинденска б.б.",
//        "working hours": "нема"

package com.dians.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.lang.reflect.Type;

@Data
@Entity
public class Gallery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String lat;
    String lon;
    String name;
    String city;
    String address;
    String working_hours;
    public Gallery() {}
    @JsonCreator
        public Gallery(@JsonProperty("lat") String lat, @JsonProperty("lon") String lon, @JsonProperty("name") String name,
                       @JsonProperty("address") String  address,@JsonProperty("working_hours") String working_hours, @JsonProperty("city") String city ) {
            // constructor logic
            this.lat = lat;
            this.lon = lon;
            this.name = name;
            this.address = address;
            this.working_hours = working_hours;
            this.city =city;
        }
    }

//        "lat": "42.0062442315",
//        "lon": "20.9674207726",
//        "name": "Национална Установа Уметничка Галерија",
//        "adress": "Адреса: Илинденска б.б.",
//        "working hours": "нема"


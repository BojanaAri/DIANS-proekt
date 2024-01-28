package org.example.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Gallery {
    // Primary key for the gallery entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    // Latitude of the gallery location
    String lat;

    // Longitude of the gallery location
    String lon;

    // Name of the gallery
    String name;

    // City where the gallery is located
    String city;

    // Address of the gallery
    String address;

    // Website of the gallery
    String website;

    // Working hours of the gallery
    String working_hours;

    // Image URL of the gallery, with increased column length for storage
    @Column(length = 4000)
    String image;

    // One-to-Many relationship with Comment entity, mappedBy the "gallery" field in Comment

    // Default constructor (no-args) required for JPA
    public Gallery() {
    }

    // JsonCreator constructor to deserialize JSON into Gallery object
    @JsonCreator
    public Gallery(@JsonProperty("lat") String lat, @JsonProperty("lon") String lon,
                   @JsonProperty("name") String name, @JsonProperty("address") String address,
                   @JsonProperty("website") String website, @JsonProperty("working_hours") String working_hours,
                   @JsonProperty("city") String city, @JsonProperty("image") String image) {
        // constructor logic
        this.lat = lat;
        this.lon = lon;
        this.name = name;
        this.address = address;
        this.working_hours = working_hours;
        this.city = city;
        this.website = website;
        this.image = image;
    }
}



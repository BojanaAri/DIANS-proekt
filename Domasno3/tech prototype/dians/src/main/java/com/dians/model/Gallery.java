package com.dians.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Gallery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lat;
    private String lon;
    private String name;
    private String city;
    private String address;
    private String website;
    private String workingHours;

    // Default constructor (used by JPA)
    public Gallery() {}

    // Constructor with JSON properties to create a Gallery object
    @JsonCreator
    public Gallery(
            @JsonProperty("lat") String lat,
            @JsonProperty("lon") String lon,
            @JsonProperty("name") String name,
            @JsonProperty("address") String address,
            @JsonProperty("website") String website,
            @JsonProperty("working_hours") String workingHours,
            @JsonProperty("city") String city
    ) {
        this.lat = lat;
        this.lon = lon;
        this.name = name;
        this.address = address;
        this.website = website;
        this.workingHours = workingHours;
        this.city = city;
    }
}



/*
package com.dians.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
// Represents a Gallery entity with associated metadata
@Data
@Entity
public class Gallery {
    // Unique identifier for the gallery (auto-generated)
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
    // Website URL of the gallery
    String website;
    // Working hours of the gallery
    String working_hours;
    // Default constructor (used by JPA)
    public Gallery() {}
    // Constructor with JSON properties to create a Gallery object
    @JsonCreator
    public Gallery(@JsonProperty("lat") String lat, @JsonProperty("lon") String lon, @JsonProperty("name") String name,
                   @JsonProperty("address") String  address, @JsonProperty("website") String website,
                   @JsonProperty("working_hours") String working_hours, @JsonProperty("city") String city) {
        // Set properties with provided values
        this.lat = lat;
        this.lon = lon;
        this.name = name;
        this.address = address;
        this.working_hours = working_hours;
        this.city = city;
        this.website = website;
    }
}
*/
package com.dians.repository.jpa;

import com.dians.model.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// JPA repository interface for Gallery entities
public interface JpaGalleryRepository extends JpaRepository<Gallery, Long> {

    // Custom query method to search galleries by both address and name
    List<Gallery> searchAllByAddressAndName(String address, String name);

    // Custom query method to search galleries by city
    List<Gallery> searchAllByCity(String city);
}

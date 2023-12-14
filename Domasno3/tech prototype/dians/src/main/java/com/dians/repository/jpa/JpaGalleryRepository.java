package com.dians.repository.jpa;

import com.dians.model.Gallery;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaGalleryRepository extends JpaRepository<Gallery, Long> {
    List<Gallery> searchAllByAddressAndName(String address, String name);
    List<Gallery> searchAllByCity(String city);

}

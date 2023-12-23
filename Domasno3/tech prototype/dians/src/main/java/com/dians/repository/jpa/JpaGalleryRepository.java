package com.dians.repository.jpa;

import com.dians.model.Gallery;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaGalleryRepository extends JpaRepository<Gallery, Long> {

    List<Gallery> findAllByCityOrName(String text,String empty);
    @Query(value = "SELECT * FROM gallery g WHERE LOWER(g.city) LIKE LOWER( %:city%)", nativeQuery = true)
    List<Gallery> findAllByCity(@Param("city") String city);

}

package org.example.repository;

import org.example.model.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaGalleryRepository extends JpaRepository<Gallery, Long> {

    @Query("SELECT g FROM Gallery g WHERE LOWER(g.city) LIKE %:text% OR LOWER(g.name) LIKE %:text%")
    List<Gallery> findAllByCityOrName(@Param("text") String text);
    @Query(value = "SELECT * FROM gallery g WHERE LOWER(g.city) LIKE LOWER( %:city%)", nativeQuery = true)
    List<Gallery> findAllByCity(@Param("city") String city);

}

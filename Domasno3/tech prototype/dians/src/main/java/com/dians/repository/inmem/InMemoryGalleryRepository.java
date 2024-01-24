package com.dians.repository.inmem;

import com.dians.bootstrap.DataHolder;
import com.dians.model.Gallery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InMemoryGalleryRepository {

    // Method to retrieve all galleries from the in-memory data holder
    public List<Gallery> findAll() {
        return DataHolder.galleries;
    }

    // Method to search galleries based on a text query
    public List<Gallery> search(String text) {
        return DataHolder.galleries.stream()
                .filter(g -> g.getName().contains(text) || g.getAddress().contains(text))
                .collect(Collectors.toList());
    }
}

package com.dians.bootstrap;

import com.dians.model.Gallery;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Gallery> galleries;

    @PostConstruct
    public void init() {
        galleries = new ArrayList<>();
        this.galleries = readJsonFile("src/main/resources/results.json");
    }

    private List<Gallery> readJsonFile(String filepath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(new File(filepath),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Gallery.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}


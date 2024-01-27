package com.dians.service.impl;

import com.dians.model.Comment;
import com.dians.model.Gallery;
import com.dians.repository.jpa.JpaCommentRepository;
import com.dians.repository.jpa.JpaGalleryRepository;
import com.dians.service.GalleryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GalleryServiceImplementation implements GalleryService {


    private final JpaGalleryRepository galleryRepository;
    private final JpaCommentRepository commentRepository;

    public GalleryServiceImplementation(JpaGalleryRepository galleryRepository, JpaCommentRepository commentRepository) {
        this.galleryRepository = galleryRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Gallery> listAll() {
        return galleryRepository.findAll();
    }

    @Override
    public List<Gallery> searchByCity(String city) {
        return galleryRepository.findAllByCity(city);
    }


    @Override
    public List<Gallery> search(String text) {
        return galleryRepository.findAllByCityOrName(text);
    }

    @Override
    public Optional<Gallery> getGalleryById(Long id) {
        return galleryRepository.findById(id);
}

    @Override
    public String getUpcomingEventTextForGalleryId(long id) {
        switch ((int)id) {
            case 1:
                return "Почеток: декември 7 @ 19:30     Крај: јануари 14, 2024 @ 18:00     Cost: MKD100";
            case 19:
                return "Почеток: декември 20 @ 12:00     Крај: февруари 4, 2024 @ 18:00     Cost: MKD100";
            case 2:
                return "Почеток: декември 24 @ 19:00     Крај: јануари 15 @ 18:00     Cost: MKD100";
            default:
                return "Нема следни настани во наредниот период";
        }
    }
}


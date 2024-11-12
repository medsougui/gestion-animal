package com.med.ani.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import com.med.ani.entities.Image;
public interface ImageRepository extends JpaRepository<Image , Long> {
}
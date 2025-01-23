package com.example.samuraitravel.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.samuraitravel.entity.House;
import com.example.samuraitravel.entity.Review;
import com.example.samuraitravel.entity.User;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
	          List<Review> findTop6ByHouseOrderByCreatedAtDesc(House house);
	          Optional<Review> findByHouseAndUser(House house, User user);
	          long countByHouse(House house);
	          Page<Review> findByHouseOrderByCreatedAtDesc(House house, Pageable pageable);
}
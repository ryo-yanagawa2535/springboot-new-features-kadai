 package com.example.samuraitravel.service;
 
 import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.samuraitravel.entity.Favorite;
import com.example.samuraitravel.entity.House;
import com.example.samuraitravel.entity.User;
import com.example.samuraitravel.repository.FavoriteRepository;
 
 @Service
 public class FavoriteService {
     private final FavoriteRepository favoriteRepository;        
     
     public FavoriteService(FavoriteRepository favoriteRepository) {        
         this.favoriteRepository = favoriteRepository;        
     }     
     
     @Transactional
     public void create(House house, User user) {
    	    Favorite favorite = new Favorite();
    	    favorite.setHouse(house);
    	    favorite.setUser(user);
    	    favoriteRepository.save(favorite);
     }
     
     public boolean isFavorite(House house, User user) {
    	 if (favoriteRepository.findByHouseAndUser(house, user).isPresent()) {
             return true; // 条件を満たす場合：trueを返却
            }
             return false; // 条件を満たさない場合：falseを返却
            }
     
     public void delete(Integer favoriteId) {
         favoriteRepository.deleteById(favoriteId);
     }
     
     }    


 

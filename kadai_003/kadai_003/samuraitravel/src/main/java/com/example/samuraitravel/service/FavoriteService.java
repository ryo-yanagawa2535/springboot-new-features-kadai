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
         // Favoriteクラスのfavoriteインスタンスを作成(コンストラクタの引数は無し)
    	    Favorite favorite = new Favorite();
         // favoriteインスタンスのsetHouseメソッドを使用(引数はhouse)
    	    favorite.setHouse(house);
         // favoriteインスタンスのsetUserメソッドを使用(引数はuser)
    	    favorite.setUser(user);
         // favoriteRepositoryインスタンスのsaveメソッドを使用(引数はfavorite)
    	    favoriteRepository.save(favorite);
     }
     
     public boolean isFavorite(House house, User user) {
    	 if (favoriteRepository.findByHouseAndUser(house, user).isPresent()) {
             return true; // 条件を満たす場合：trueを返却
            }
             return false; // 条件を満たさない場合：falseを返却
            }
     }    


 

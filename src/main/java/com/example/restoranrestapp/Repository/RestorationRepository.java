package com.example.restoranrestapp.Repository;

import com.example.restoranrestapp.Model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestorationRepository extends JpaRepository<Restaurant,Long> {
//    Restaurant findByOneByName(String name) ;
//    List<Restaurant> findAllByName (String string) ;
}

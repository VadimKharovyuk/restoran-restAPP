package com.example.restoranrestapp.Repository;

import com.example.restoranrestapp.Model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestorationRepository extends JpaRepository<Restaurant,Long> {
}

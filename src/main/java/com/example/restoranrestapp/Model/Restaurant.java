package com.example.restoranrestapp.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @OneToMany(fetch = FetchType.EAGER,
    targetEntity = MenuItem.class,
    cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_id")
    private List<MenuItem> menuItems;
}

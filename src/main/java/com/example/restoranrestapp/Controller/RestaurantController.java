package com.example.restoranrestapp.Controller;

import com.example.restoranrestapp.Model.MenuItem;
import com.example.restoranrestapp.Model.Restaurant;
import com.example.restoranrestapp.Repository.RestorationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/restaurants")
@AllArgsConstructor
public class RestaurantController {
    private final RestorationRepository restorationRepository ;


    @GetMapping("/{id}")
    public String vievResporaunt(@PathVariable (name = "id") Long id, Model model){
        var restorant = restorationRepository.findById(id).orElseThrow();
        model.addAttribute("restaurant" ,restorant);

        return "restoraunt-viev";

    }

}

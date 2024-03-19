package com.example.restoranrestapp.Controller;

import com.example.restoranrestapp.Model.MenuItem;
import com.example.restoranrestapp.Model.Restaurant;
import com.example.restoranrestapp.Repository.RestorationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/create")
    public String vievCreateREstoraunt(Model model){
        model.addAttribute("restaurant", new Restaurant());
        return "create-restaurant-view";

    }
    @PostMapping("/save")
    public String saveRestoraunt(@ModelAttribute Restaurant restaurant ,Model model){
      var saveResporaunt =  restorationRepository.save(restaurant);
      model.addAttribute("restaurant",saveResporaunt);
        return "restoraunt-viev";
    }

    @GetMapping("/{id}/create-menu-item")
    public String craeteMenuItem(@PathVariable (name = "id") Long id ,Model model){
        var menuItem= new MenuItem();
        menuItem.setRestaurantId(id);
        model.addAttribute("menuItem", menuItem);
        return "create-menu-item-view";
    }
    @PostMapping("/menu-item/save")
    public String saveItem(@ModelAttribute MenuItem menuItem ,Model model){
      var restaurant =  restorationRepository.findById(menuItem.getRestaurantId()).orElseThrow();
      restaurant.getMenuItems().add(menuItem);
      restaurant =restorationRepository.save(restaurant);
      model.addAttribute("restaurant",restaurant);
        return "restoraunt-viev";

    }

}

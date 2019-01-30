package com.ben.project.PetShop;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetShopController {

    private List<Animals> listAnimals = Arrays.asList(new Animals(1, "Bijou", 25), new Animals(2, "Milou", 60), new Animals(3, "Ragou", 70));

    @GetMapping("/Animals/{id}")

    public String getAnimalsById(@PathVariable int id) {
        for (int j = 0; j < listAnimals.size(); j++) {
            if (id == listAnimals.get(j).getId()) {
                return listAnimals.get(j).getName();
            }
        }
        return null;
    }
}

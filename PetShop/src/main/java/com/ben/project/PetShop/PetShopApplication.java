package com.ben.project.PetShop;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PetShopApplication {

    private List<Animals> listAnimals = Arrays.asList(new Animals(1, "Bijou", 25), new Animals(2, "Milou", 60), new Animals(3, "Ragou", 70));

    public static void main(String[] args) {
        SpringApplication.run(PetShopApplication.class, args);
    }

    //
    @GetMapping
    public String getAnimalsById(@Value(value = "id") int id) {
        for (int j = 0; j < listAnimals.size(); j++) {
            if (id == listAnimals.get(j).getId()) {
                return listAnimals.get(j).getName();
            }
        }
        return null;
    }

}

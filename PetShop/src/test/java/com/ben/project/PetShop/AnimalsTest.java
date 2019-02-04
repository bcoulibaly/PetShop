package com.ben.project.PetShop;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.boot.test.context.TestComponent;

@TestComponent
public class AnimalsTest {

    Animals animal = new Animals();

    @Test
    public void testInitAnimal() {
        animal.getAnimals().add(new Animals(1, "Katze", 15));
        animal.getAnimals().add(new Animals(2, "Hunde", 60));
        animal.getAnimals().add(new Animals(3, "Vögel", 10));
        animal.getAnimals().add(new Animals(4, "Maus", 5));
        animal.getAnimals().add(new Animals(5, "Fische", 5));

        Assertions.assertThat(animal.getAnimals().isEmpty()).isEqualTo(false);
        Assertions.assertThat(animal.getAnimals().size()).isEqualTo(5);
    }

    @Test
    public void testEqualMethod() {

        animal.getAnimals().add(new Animals(1, "Katze", 15));
        animal.getAnimals().add(new Animals(2, "Hunde", 60));
        animal.getAnimals().add(new Animals(3, "Vögel", 10));
        animal.getAnimals().add(new Animals(4, "Maus", 5));
        animal.getAnimals().add(new Animals(5, "Fische", 5));

        Assertions.assertThat(animal.getAnimals().get(1).equals(new Animals(2, "Hunde", 60))).isEqualTo(true);
    }

    @Test
    public void testEqualMethodByNull() {

        animal.getAnimals().add(new Animals(1, "Katze", 15));
        animal.getAnimals().add(new Animals(2, "Hunde", 60));
        animal.getAnimals().add(new Animals(3, "Vögel", 10));
        animal.getAnimals().add(new Animals(4, "Maus", 5));
        animal.getAnimals().add(new Animals(5, "Fische", 5));

        Assertions.assertThat(animal.getAnimals().get(2).equals(null)).isEqualTo(false);
    }

    @Test
    public void testEqualMethodByChangeName() {

        animal.getAnimals().add(new Animals(1, "Katze", 15));
        animal.getAnimals().add(new Animals(2, "Hunde", 60));
        animal.getAnimals().add(new Animals(3, "Vögel", 10));
        animal.getAnimals().add(new Animals(4, "Maus", 5));
        animal.getAnimals().add(new Animals(5, "Fische", 5));

        Assertions.assertThat(animal.getAnimals().get(1).equals(new Animals(2, "Hande", 60))).isEqualTo(false);
    }

}

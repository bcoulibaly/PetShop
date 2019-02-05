package com.ben.project.PetShop;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.boot.test.context.TestComponent;

@TestComponent
public class AnimalsTest {

    ControllerService cService = new ControllerService();

    @Test
    public void testInitAnimal() {
        cService.getAnimalList().add(new Animals(1, "Katze", 15));
        cService.getAnimalList().add(new Animals(2, "Hunde", 60));
        cService.getAnimalList().add(new Animals(3, "Vögel", 10));
        cService.getAnimalList().add(new Animals(4, "Maus", 5));
        cService.getAnimalList().add(new Animals(5, "Fische", 5));

        Assertions.assertThat(cService.getAnimalList().isEmpty()).isEqualTo(false);
        Assertions.assertThat(cService.getAnimalList().size()).isEqualTo(5);
    }

    @Test
    public void testEqualMethod() {

        cService.getAnimalList().add(new Animals(1, "Katze", 15));
        cService.getAnimalList().add(new Animals(2, "Hunde", 60));
        cService.getAnimalList().add(new Animals(3, "Vögel", 10));
        cService.getAnimalList().add(new Animals(4, "Maus", 5));
        cService.getAnimalList().add(new Animals(5, "Fische", 5));

        Assertions.assertThat(cService.getAnimalList().get(1).equals(new Animals(2, "Hunde", 60))).isEqualTo(true);
    }

    @Test
    public void testEqualMethodByNull() {

        cService.getAnimalList().add(new Animals(1, "Katze", 15));
        cService.getAnimalList().add(new Animals(2, "Hunde", 60));
        cService.getAnimalList().add(new Animals(3, "Vögel", 10));
        cService.getAnimalList().add(new Animals(4, "Maus", 5));
        cService.getAnimalList().add(new Animals(5, "Fische", 5));

        Assertions.assertThat(cService.getAnimalList().get(2).equals(null)).isEqualTo(false);
    }

    @Test
    public void testEqualMethodByChangeName() {

        cService.getAnimalList().add(new Animals(1, "Katze", 15));
        cService.getAnimalList().add(new Animals(2, "Hunde", 60));
        cService.getAnimalList().add(new Animals(3, "Vögel", 10));
        cService.getAnimalList().add(new Animals(4, "Maus", 5));
        cService.getAnimalList().add(new Animals(5, "Fische", 5));

        Assertions.assertThat(cService.getAnimalList().get(1).equals(new Animals(2, "Hande", 60))).isEqualTo(false);
    }

}

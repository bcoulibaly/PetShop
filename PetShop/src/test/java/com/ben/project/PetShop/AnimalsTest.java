package com.ben.project.PetShop;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.boot.test.context.TestComponent;

@TestComponent
public class AnimalsTest {

    @Test
    public void testGetKunde() {
        Animals testAnimal = new Animals();
        testAnimal.setId(2);
        testAnimal.setName("Hai");
        testAnimal.setGroße(150);
        Assertions.assertThat(testAnimal).hasFieldOrPropertyWithValue("id", 2)
                .hasFieldOrPropertyWithValue("name", "Hai")
                .hasFieldOrPropertyWithValue("große", 150);
    }

    @Test
    public void testEqualsMethode() {

        Animals testAnimal = new Animals();
        testAnimal.setId(2);
        testAnimal.setName("Hai");
        testAnimal.setGroße(150);

        Animals testAnimal2 = new Animals();
        testAnimal2.setId(2);
        testAnimal2.setName("Hai");
        testAnimal2.setGroße(150);

        assertThat(testAnimal).isEqualTo(testAnimal2);
    }

}

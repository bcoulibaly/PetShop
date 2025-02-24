package com.ben.project.PetShop;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.boot.test.context.TestComponent;

@TestComponent
public class AnimalsTest {

    @Test
    public void testGetKunde() {
        Animal testAnimal = new Animal();
        testAnimal.setId(2);
        testAnimal.setName("Hai");
        testAnimal.setGroße(150);
        Assertions.assertThat(testAnimal).hasFieldOrPropertyWithValue("id", 2)
                .hasFieldOrPropertyWithValue("name", "Hai")
                .hasFieldOrPropertyWithValue("große", 150);
    }

    @Test
    public void testEqualsMethode() {

        Animal testAnimal = new Animal();
        testAnimal.setId(2);
        testAnimal.setName("Hai");
        testAnimal.setGroße(150);

        Animal testAnimal2 = new Animal();
        testAnimal2.setId(2);
        testAnimal2.setName("Hai");
        testAnimal2.setGroße(150);

        assertThat(testAnimal).isEqualTo(testAnimal2);
    }

}

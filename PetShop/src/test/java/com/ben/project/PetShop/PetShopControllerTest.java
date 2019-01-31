package com.ben.project.PetShop;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.boot.test.context.TestComponent;

@TestComponent
public class PetShopControllerTest {

    @Test
    public void testGetNameById2() {
        PetShopController ps = new PetShopController();
        Animals result = ps.getAnimalsById(2);
        Assertions.assertThat(result).isEqualTo(new Animals(2, "Milou", 60));
    }

    @Test
    public void testGetNameById42() {
        PetShopController psc = new PetShopController();
        Animals result = psc.getAnimalsById(42);
        Assertions.assertThat(result).isEqualTo(null);
    }

    @Test
    public void testPostMethode() {
        PetShopController ptc = new PetShopController();
        Animals ani = ptc.changeAnimalId(2, 8);
        Assertions.assertThat(ani).isEqualTo(new Animals(8, "Milou", 60));
    }

}

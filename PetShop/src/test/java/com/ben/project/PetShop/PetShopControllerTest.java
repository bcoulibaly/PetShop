package com.ben.project.PetShop;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.boot.test.context.TestComponent;

@TestComponent
public class PetShopControllerTest {

    @Test
    public void testGetNameById2() {
        PetShopController ps = new PetShopController();
        String result = ps.getAnimalsById(1);
        Assertions.assertThat(result).isEqualTo("Bijou");
    }

    @Test
    public void testGetNameById45() {
        PetShopController psc = new PetShopController();
        String result = psc.getAnimalsById(42);
        Assertions.assertThat(result).isEqualTo(null);
    }
}

package com.ben.project.PetShop;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.boot.test.context.TestComponent;

@TestComponent
public class KundeTest {
    
    @Test
    public void testGetKunde() {
        PetShopController pt = new PetShopController();
        Kunde value = pt.getKundeByName("Marina");
        Assertions.assertThat(value.equals(new Kunde("Marina", 12, "Helvetik Straße 45"))).isEqualTo(true);
    }

}

package com.ben.project.PetShop;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PetShopApplicationTests {

    @Test
    public void testGetNameById2() {
        PetShopApplication ps = new PetShopApplication();
        String result = ps.getAnimalsById(2);
        Assertions.assertThat(result).isEqualTo("Milou");
    }
}

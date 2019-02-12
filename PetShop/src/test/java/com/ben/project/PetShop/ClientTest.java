package com.ben.project.PetShop;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.boot.test.context.TestComponent;

@TestComponent
public class ClientTest {

    @Test
    public void testGetKunde() {
        Client testKunde = new Client();
        testKunde.setId(2);
        testKunde.setName("Bile");
        testKunde.setAnschrift("Walle Heerstraße 50");
        Assertions.assertThat(testKunde).hasFieldOrPropertyWithValue("kId", 2)
                .hasFieldOrPropertyWithValue("kName", "Bile")
                .hasFieldOrPropertyWithValue("kAnschrift", "Walle Heerstraße 50");
    }

    @Test
    public void testEqualsMethode() {

        Client testClient = new Client();
        testClient.setId(2);
        testClient.setName("Bile");
        testClient.setAnschrift("Walle Heerstraße 50");

        Client testClient2 = new Client();
        testClient2.setId(2);
        testClient2.setName("Bile");
        testClient2.setAnschrift("Walle Heerstraße 50");

        assertThat(testClient).isEqualTo(testClient2);
    }

}

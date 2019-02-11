package com.ben.project.PetShop;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.boot.test.context.TestComponent;

@TestComponent
public class KundeTest {

    @Test
    public void testGetKunde() {
        Kunde testKunde = new Kunde();
        testKunde.setkNr(2);
        testKunde.setkName("Bile");
        testKunde.setkAnschrift("Walle Heerstraße 50");
        Assertions.assertThat(testKunde).hasFieldOrPropertyWithValue("kId", 2)
                .hasFieldOrPropertyWithValue("kName", "Bile")
                .hasFieldOrPropertyWithValue("kAnschrift", "Walle Heerstraße 50");
    }

    @Test
    public void testEqualsMethode() {

        Kunde testKunde = new Kunde();
        testKunde.setkNr(2);
        testKunde.setkName("Bile");
        testKunde.setkAnschrift("Walle Heerstraße 50");

        Kunde testKunde2 = new Kunde();
        testKunde2.setkNr(2);
        testKunde2.setkName("Bile");
        testKunde2.setkAnschrift("Walle Heerstraße 50");

        assertThat(testKunde).isEqualTo(testKunde2);
    }

}

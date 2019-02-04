package com.ben.project.PetShop;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.boot.test.context.TestComponent;

@TestComponent
public class KundeTest {

    ControllerService cService = new ControllerService();

    @Test
    public void testIntitKundeList() {
        cService.getKundeList().add(new Kunde("Marina", 12, "Helvetik Straße 45"));
        cService.getKundeList().add(new Kunde("Ole", 14, "Buschhöhe 2"));
        cService.getKundeList().add(new Kunde("Engbert", 30, "Walle Herrstr. 6"));
        cService.getKundeList().add(new Kunde("Sasha", 80, "Vechta Heerstr. 56"));

        Assertions.assertThat(cService.getKundeList().isEmpty()).isEqualTo(false);
        Assertions.assertThat(cService.getKundeList().size()).isEqualTo(4);
    }

    @Test
    public void testGetKunde() {
        cService.getKundeList().add(new Kunde("Marina", 12, "Helvetik Straße 45"));
        cService.getKundeList().add(new Kunde("Ole", 14, "Buschhöhe 2"));
        cService.getKundeList().add(new Kunde("Engbert", 30, "Walle Herrstr. 6"));
        cService.getKundeList().add(new Kunde("Sasha", 80, "Vechta Heerstr. 56"));

        Kunde tmpKunde = new Kunde("Marina", 12, "Helvetik Straße 45");
        Assertions.assertThat(tmpKunde.equals(cService.getKundeList().get(0))).isEqualTo(true);
    }

    @Test
    public void testGetKundeFalse() {
        cService.getKundeList().add(new Kunde("Marina", 12, "Helvetik Straße 45"));
        cService.getKundeList().add(new Kunde("Ole", 14, "Buschhöhe 2"));
        cService.getKundeList().add(new Kunde("Engbert", 30, "Walle Herrstr. 6"));
        cService.getKundeList().add(new Kunde("Sasha", 80, "Vechta Heerstr. 56"));

        Kunde tmpKunde = new Kunde("Marina", 30, "Helvetik Straße 45");
        Assertions.assertThat(tmpKunde.equals(cService.getKundeList().get(0))).isEqualTo(false);
    }

}

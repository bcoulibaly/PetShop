package com.ben.project.PetShop;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestComponent;

@TestComponent
public class KundeControllerTest {

    KundenRepository kundeRepo = Mockito.mock(KundenRepository.class);

    KundeController kundeCtrl;

    @Test
    public void testGetKundeById() {

        Kunde kunde = new Kunde();
        kunde.setkNr(1);
        kunde.setkName("Egbert");
        kunde.setkAnschrift("Walle Str.50");

        kunde = kundeRepo.save(kunde);
    }

}

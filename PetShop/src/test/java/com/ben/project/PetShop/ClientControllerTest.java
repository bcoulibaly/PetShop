package com.ben.project.PetShop;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.TestComponent;

@TestComponent
public class ClientControllerTest {

    @Mock
    private ClientService clientService;

    @InjectMocks
    private ClientController clientCntrl;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetKundeById() throws Exception {

        ClientDTO client = new ClientDTO();
        client.setId(1);
        client.setName("Marina");
        client.setAnschrift("Waller Heerstr. 27");

        when(clientCntrl.convertToClientDTO(clientService.getClientById(1))).thenReturn(client);

        ClientDTO client2 = clientCntrl.getClientById(1);
        assertThat(client).isEqualTo(client2);
    }

    @Test
    public void testGetAllClient() {
        Client client1 = new Client();
        Client client2 = new Client();
        Client client3 = new Client();

        client1.setId(1);
        client1.setName("Egbert");
        client1.setAnschrift("Walle Heerstraße 3");

        client2.setId(2);
        client2.setName("marinar");
        client2.setAnschrift("Walle  3");

        client3.setId(1);
        client3.setName("Roland");
        client3.setAnschrift("Ritherhude Heerstraße 3");

    }

}

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

        Client client = new Client();
        client.setId(1);
        client.setName("Marina");
        client.setAnschrift("Waller Heerstr. 27");

        when(clientService.getClientById(1)).thenReturn(client);

        Client client2 = clientCntrl.getClientById(1);
        assertThat(client).isEqualTo(client2);
    }

    @Test
    public void testGetAllClient() {

    }

}

package ch.vd.spring.repo;

import ch.vd.spring.model.Client;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest

@Transactional
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void save(){
        Client c = new Client();
        c.setNom("Test Nom");
        c.setPrenom("Test Prenom");
        c.setEmail("Test Email");
        clientRepository.save(c);

        assertNotNull(c.getId());
    }

}

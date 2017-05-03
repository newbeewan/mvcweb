package ch.vd.spring.rest;

import ch.vd.spring.model.Client;
import ch.vd.spring.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "client")
public class ClientRestController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public List<Client> list(){
        return clientRepository.findClientList();
    }

}

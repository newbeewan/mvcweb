package ch.vd.spring.rest;

import ch.vd.spring.model.Client;
import ch.vd.spring.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "client")
public class ClientRestController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Client> list(){
        return clientRepository.findClientList();
    }

    @GetMapping(path = "/{id}")
    public Client getOne(@PathVariable Integer id){
        return clientRepository.findOne(id);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Client saveClient(@RequestBody Client client){
        clientRepository.save(client);
        return client;
    }

    @DeleteMapping(path = "/{id}")
    public String deleteClient(@PathVariable Integer id){
        clientRepository.delete(id);
        return "OK";
    }

}

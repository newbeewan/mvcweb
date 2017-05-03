package ch.vd.spring;

import ch.vd.spring.model.Client;
import ch.vd.spring.repo.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RepositoryConfig {

    @Bean
    public CommandLineRunner initDb(final ClientRepository repository) {
        return (args) -> {
            Client client = new Client("Client1 nom", "Client1 prenom", "Client1 email");
            repository.save(client);

        };
    }
}

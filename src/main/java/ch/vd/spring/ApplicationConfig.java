package ch.vd.spring;

import ch.vd.spring.model.Client;
import ch.vd.spring.repo.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApplicationConfig {

    @Bean
    public CommandLineRunner initDb(final ClientRepository repository) {
        return (args) -> {
            Client client = new Client("Client1 nom", "Client1 prenom", "Client1 email");
            Client client2 = new Client("Client2 nom", "Client2 prenom", "Client2 email");
            repository.save(client);
            repository.save(client2);

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationConfig.class, args);
    }
}

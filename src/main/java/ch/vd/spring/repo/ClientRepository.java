package ch.vd.spring.repo;

import ch.vd.spring.model.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ClientRepository extends PagingAndSortingRepository<Client, Integer> {

    @Query
    List<Client> findClientList();
}

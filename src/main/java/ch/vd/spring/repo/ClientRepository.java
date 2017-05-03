package ch.vd.spring.repo;

import ch.vd.spring.model.Client;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClientRepository extends PagingAndSortingRepository<Client, Integer> {
}

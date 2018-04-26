package kz.kaznitu.dancer.repositories;

import kz.kaznitu.dancer.models.Dancer;
import org.springframework.data.repository.CrudRepository;

public interface DancerRepository extends CrudRepository<Dancer, Long> {
}

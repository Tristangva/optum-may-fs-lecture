package net.yorksolutions.myfirstjavaproject;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CacheRepository extends CrudRepository<Cache, Long> {
    Optional<Cache> findByInput(Integer input);
}

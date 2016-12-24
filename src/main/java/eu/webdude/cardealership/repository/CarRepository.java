package eu.webdude.cardealership.repository;

import eu.webdude.cardealership.entity.Car;
import eu.webdude.cardealership.entity.Status;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CarRepository extends PagingAndSortingRepository<Car, Long> {

	Iterable<Car> findByStatus(Status status);
}

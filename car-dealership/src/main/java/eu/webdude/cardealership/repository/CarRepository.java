package eu.webdude.cardealership.repository;

import eu.webdude.cardealership.domain.entity.Car;
import eu.webdude.cardealership.domain.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.stream.Stream;

public interface CarRepository extends JpaRepository<Car, Long> {

	Stream<Car> findByStatus(Status status);
}

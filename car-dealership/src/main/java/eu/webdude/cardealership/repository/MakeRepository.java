package eu.webdude.cardealership.repository;

import eu.webdude.cardealership.domain.entity.Make;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MakeRepository extends JpaRepository<Make, Long> {
	Make findByNameEquals(String makeName);
}

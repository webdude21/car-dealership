package eu.webdude.cardealership.repository;

import eu.webdude.cardealership.domain.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {
	Model findByNameEquals(String modelName);
}

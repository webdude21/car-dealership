package eu.webdude.cardealership.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EntityRepository<T> extends JpaRepository<T, Long> {
}

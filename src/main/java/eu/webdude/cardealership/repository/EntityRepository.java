package eu.webdude.cardealership.repository;

import eu.webdude.cardealership.domain.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface EntityRepository<T extends BaseEntity> extends JpaRepository<T, Long> {
}

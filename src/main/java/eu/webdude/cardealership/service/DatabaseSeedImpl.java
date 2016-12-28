package eu.webdude.cardealership.service;

import eu.webdude.cardealership.domain.entity.BaseEntity;
import eu.webdude.cardealership.domain.entity.Color;
import eu.webdude.cardealership.domain.entity.Make;
import eu.webdude.cardealership.domain.entity.Model;
import eu.webdude.cardealership.domain.factory.DomainObjectFactory;
import eu.webdude.cardealership.repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseSeedImpl implements DatabaseSeed {

	private final EntityRepository<BaseEntity> repo;

	private final DomainObjectFactory objectFactory;

	@Autowired
	DatabaseSeedImpl(EntityRepository<BaseEntity> baseEntity, DomainObjectFactory objectFactory) {
		this.repo = baseEntity;
		this.objectFactory = objectFactory;
	}

	@Override
	public void seed() {
		Make ford = objectFactory.crateMake("Ford", 1903);
		Model mondeo = objectFactory.createModel("Mondeo", ford, 2001, 2007);
		Model fiesta = objectFactory.createModel("Fiesta", ford, 1994, 2001);
		repo.save(ford);
		repo.save(mondeo);
		repo.save(fiesta);
		repo.save(objectFactory.createCar(120_224, 1996, fiesta, Color.CYAN));
		repo.save(objectFactory.createCar(260_000, 2002, mondeo, Color.BLUE));
	}
}

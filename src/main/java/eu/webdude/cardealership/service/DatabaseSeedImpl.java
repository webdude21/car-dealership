package eu.webdude.cardealership.service;

import eu.webdude.cardealership.entity.Car;
import eu.webdude.cardealership.entity.Make;
import eu.webdude.cardealership.repository.EntityRepository;
import org.springframework.ui.Model;

public class DatabaseSeedImpl implements DatabaseSeed {

	private final EntityRepository<Car> carRepository;

	private final EntityRepository<Model> modelRepository;

	private final EntityRepository<Make> makeRepository;

	DatabaseSeedImpl(EntityRepository<Car> carRepository, EntityRepository<Model> modelRepository, EntityRepository<Make> makeRepository) {
		this.carRepository = carRepository;
		this.modelRepository = modelRepository;
		this.makeRepository = makeRepository;
	}

	@Override
	public void seed() {
	}
}

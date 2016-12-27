package eu.webdude.cardealership.service;

import eu.webdude.cardealership.domain.entity.Car;
import eu.webdude.cardealership.domain.entity.Color;
import eu.webdude.cardealership.domain.entity.Make;
import eu.webdude.cardealership.domain.entity.Model;
import eu.webdude.cardealership.repository.EntityRepository;
import eu.webdude.cardealership.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseSeedImpl implements DatabaseSeed {

	private final EntityRepository<Car> carRepository;

	private final EntityRepository<Model> modelRepository;

	private final EntityRepository<Make> makeRepository;

	@Autowired
	DatabaseSeedImpl(EntityRepository<Car> carRepository, EntityRepository<Model> modelRepository, EntityRepository<Make> makeRepository) {
		this.carRepository = carRepository;
		this.modelRepository = modelRepository;
		this.makeRepository = makeRepository;
	}

	@Override
	public void seed() {
		Make ford = new Make("Ford", DateTimeUtil.fromYear(1903));
		Model mondeo = new Model("Mondeo", ford, 2001, 2007);
		Car myCar = new Car(260_000, 2002, mondeo, Color.BLUE);
		makeRepository.saveAndFlush(ford);
		modelRepository.saveAndFlush(mondeo);
		carRepository.saveAndFlush(myCar);
	}
}

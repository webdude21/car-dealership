package eu.webdude.cardealership.service;

import eu.webdude.cardealership.domain.entity.Car;
import eu.webdude.cardealership.domain.entity.Status;
import eu.webdude.cardealership.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

	private CarRepository carRepo;

	@Autowired
	public CarServiceImpl(CarRepository carRepository) {
		this.carRepo = carRepository;
	}

	@Override
	public Iterable<Car> getCarsAvailableForPurchase() {
		return carRepo.findByStatus(Status.FOR_SALE);
	}
}

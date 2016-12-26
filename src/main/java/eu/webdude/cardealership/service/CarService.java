package eu.webdude.cardealership.service;

import eu.webdude.cardealership.domain.entity.Car;

public interface CarService {
	Iterable<Car> getCarsAvailableForPurchase();
}

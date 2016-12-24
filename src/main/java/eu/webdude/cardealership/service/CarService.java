package eu.webdude.cardealership.service;

import eu.webdude.cardealership.entity.Car;

public interface CarService {
	Iterable<Car> getCarsAvailableForPurchase();
}

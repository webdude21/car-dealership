package eu.webdude.cardealership.service;

import eu.webdude.cardealership.domain.dto.CarDto;
import eu.webdude.cardealership.domain.dto.CreateCarDto;

public interface CarService {
	Iterable<CarDto> getCarsAvailableForPurchase();

	CarDto createCar(CreateCarDto carForCreation);

	CarDto getCar(long id);
}

package eu.webdude.cardealership.service;

import eu.webdude.cardealership.domain.dto.CarDto;
import eu.webdude.cardealership.domain.dto.CreateCarDto;
import eu.webdude.cardealership.domain.entity.Status;

public interface CarService {
	CarDto createCar(CreateCarDto carForCreation);

	CarDto getCar(long id);

	Iterable<CarDto> getCarsByStatus(Status status);
}

package eu.webdude.cardealership.service;

import eu.webdude.cardealership.domain.dto.CarDto;
import eu.webdude.cardealership.domain.dto.InputCarDto;
import eu.webdude.cardealership.domain.entity.Status;

public interface CarService {
	CarDto createCar(InputCarDto carForCreation);

	CarDto getCar(long id);

	void deleteCar(long id);

	Iterable<CarDto> getCarsByStatus(Status status);

	void editCar(long id, InputCarDto carToEdit);
}

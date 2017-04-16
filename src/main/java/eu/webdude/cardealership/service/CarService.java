package eu.webdude.cardealership.service;

import eu.webdude.cardealership.domain.dto.CarDto;
import eu.webdude.cardealership.domain.dto.InputCarDto;
import eu.webdude.cardealership.domain.entity.Car;
import eu.webdude.cardealership.domain.entity.Status;

import java.util.concurrent.Future;

public interface CarService {
	Car createCar(InputCarDto carForCreation);

	CarDto getCar(long id);

	void deleteCar(long id);

	Future<Iterable<CarDto>> getCarsByStatus(Status status);

	void editCar(long id, InputCarDto carToEdit);
}

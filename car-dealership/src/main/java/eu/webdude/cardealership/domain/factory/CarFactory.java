package eu.webdude.cardealership.domain.factory;

import eu.webdude.CarMessageDto;
import eu.webdude.cardealership.domain.dto.CarDto;
import eu.webdude.cardealership.domain.dto.InputCarDto;
import eu.webdude.cardealership.domain.entity.Car;
import eu.webdude.cardealership.domain.entity.Color;
import eu.webdude.cardealership.domain.entity.Make;
import eu.webdude.cardealership.domain.entity.Model;

public interface CarFactory {
	Car createCar(long odometerReading, int yearOfManufacture, Model model, Color color);

	Car createCar(InputCarDto carDto, Model model);

	Car createCar(long id, InputCarDto carDto, Model model);

	Car createCar(long id, long odometerReading, int yearOfManufacture, Model model, Color color);

	CarDto createCarDto(Car car);

	Make crateMake(String makeName, int foundingYear);

	Model createModel(String modelName, Make ford, int productionStartYear, int productionEndYear);

	CarMessageDto createMessageDto(CarDto carDto);
}

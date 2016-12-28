package eu.webdude.cardealership.domain.factory;

import eu.webdude.cardealership.domain.dto.CreateCarDto;
import eu.webdude.cardealership.domain.entity.Car;
import eu.webdude.cardealership.domain.entity.Color;
import eu.webdude.cardealership.domain.entity.Make;
import eu.webdude.cardealership.domain.entity.Model;

public interface DomainObjectFactory {
	Car createCar(long odometerReading, int yearOfManufacture, Model model, Color color);

	Car createCar(CreateCarDto carDto, Model model);

	Make crateMake(String makeName, int foundingYear);

	Model createModel(String modelName, Make ford, int productionStartYear, int productionEndYear);
}

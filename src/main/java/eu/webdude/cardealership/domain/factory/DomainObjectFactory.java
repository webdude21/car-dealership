package eu.webdude.cardealership.domain.factory;

import eu.webdude.cardealership.domain.entity.Car;
import eu.webdude.cardealership.domain.entity.Color;
import eu.webdude.cardealership.domain.entity.Make;
import eu.webdude.cardealership.domain.entity.Model;

public interface DomainObjectFactory {
	Car createCar(int odometerReading, int yearOfManufacture, Model model, Color color);

	Make crateMake(String makeName, int foundingYear);

	Model createModel(String modelName, Make ford, int productionStartYear, int productionEndYear);
}

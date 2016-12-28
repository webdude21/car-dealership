package eu.webdude.cardealership.domain.factory;

import eu.webdude.cardealership.domain.dto.CreateCarDto;
import eu.webdude.cardealership.domain.entity.Car;
import eu.webdude.cardealership.domain.entity.Color;
import eu.webdude.cardealership.domain.entity.Make;
import eu.webdude.cardealership.domain.entity.Model;
import eu.webdude.cardealership.util.DateTimeUtil;
import org.springframework.stereotype.Component;

@Component
public class DomainObjectFactoryImpl implements DomainObjectFactory {

	@Override
	public Car createCar(long odometerReading, int yearOfManufacture, Model model, Color color) {
		return new Car(odometerReading, yearOfManufacture, model, color);
	}

	@Override
	public Car createCar(CreateCarDto carDto, Model model) {
		return createCar(carDto.getOdometerReading(), carDto.getManufacturedAtYear(), model, carDto.getColor());
	}

	@Override
	public Make crateMake(String makeName, int foundingYear) {
		return new Make(makeName, DateTimeUtil.fromYear(foundingYear));
	}

	@Override
	public Model createModel(String modelName, Make make, int productionStartYear, int productionEndYear) {
		return new Model(modelName, make, productionStartYear, productionEndYear);
	}
}

package eu.webdude.cardealership.domain.factory;

import eu.webdude.CarMessageDto;
import eu.webdude.cardealership.domain.dto.CarDto;
import eu.webdude.cardealership.domain.dto.InputCarDto;
import eu.webdude.cardealership.domain.entity.Car;
import eu.webdude.cardealership.domain.entity.Color;
import eu.webdude.cardealership.domain.entity.Make;
import eu.webdude.cardealership.domain.entity.Model;
import eu.webdude.cardealership.util.DateTimeUtil;
import org.springframework.stereotype.Component;

@Component
public class CarFactoryImpl implements CarFactory {

	@Override
	public Car createCar(long odometerReading, int yearOfManufacture, Model model, Color color) {
		return new Car(odometerReading, yearOfManufacture, model, color);
	}

	@Override
	public Car createCar(InputCarDto carDto, Model model) {
		return createCar(carDto.getOdometerReading(), carDto.getManufacturedAtYear(), model, carDto.getColor());
	}

	@Override
	public Car createCar(long id, InputCarDto carDto, Model model) {
		Car resultCar = createCar(carDto, model);
		resultCar.setId(id);
		return resultCar;
	}

	@Override
	public Car createCar(long id, long odometerReading, int yearOfManufacture, Model model, Color color) {
		Car resultCar = createCar(odometerReading, yearOfManufacture, model, color);
		resultCar.setId(id);
		return resultCar;
	}

	@Override
	public CarDto createCarDto(Car car) {
		return new CarDto(car);
	}

	@Override
	public Make crateMake(String makeName, int foundingYear) {
		return new Make(makeName, DateTimeUtil.fromYear(foundingYear));
	}

	@Override
	public Model createModel(String modelName, Make make, int productionStartYear, int productionEndYear) {
		return new Model(modelName, make, productionStartYear, productionEndYear);
	}

	@Override
	public CarMessageDto createMessageDto(CarDto carDto) {
		return new CarMessageDto(carDto.getManufacturedAt(), carDto.getModel(), carDto.getOdometerReading(), carDto.getMake());
	}
}

package eu.webdude.cardealership.service;

import eu.webdude.cardealership.domain.dto.CarDto;
import eu.webdude.cardealership.domain.dto.CreateCarDto;
import eu.webdude.cardealership.domain.entity.Car;
import eu.webdude.cardealership.domain.entity.Model;
import eu.webdude.cardealership.domain.entity.Status;
import eu.webdude.cardealership.domain.factory.DomainObjectFactory;
import eu.webdude.cardealership.repository.CarRepository;
import eu.webdude.cardealership.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CarServiceImpl implements CarService {

	private CarRepository carRepo;

	private ModelRepository modelRepo;

	private DomainObjectFactory domainObjectFactory;

	@Autowired
	public CarServiceImpl(CarRepository carRepo, ModelRepository modelRepo, DomainObjectFactory domainObjectFactory) {
		this.carRepo = carRepo;
		this.modelRepo = modelRepo;
		this.domainObjectFactory = domainObjectFactory;
	}

	@Override
	@Cacheable("getCarsByStatus")
	public Iterable<CarDto> getCarsByStatus(Status status) {
		return carRepo.findByStatus(status)
			.stream()
			.map(CarDto::new)
			.collect(Collectors.toList());
	}

	@Override
	public CarDto createCar(CreateCarDto carForCreation) {
		Model model = modelRepo.findByNameEquals(carForCreation.getModelName());
		checkIfModelExists(carForCreation.getModelName(), model);
		Car createdCar = carRepo.save(domainObjectFactory.createCar(carForCreation, model));
		return new CarDto(createdCar);
	}

	@Override
	@Cacheable("getCarById")
	public CarDto getCar(long id) {
		Car car = carRepo.findOne(id);
		checkIfCarExists(id, car);
		return new CarDto(car);
	}

	@Override
	public void deleteCar(long id) {
		carRepo.delete(id);
	}

	private void checkIfModelExists(String modelName, Model model) {
		if (model == null) {
			throw new EntityNotFoundException(String.format("No car with the name '%s' exists. Please create one first", modelName));
		}
	}

	private void checkIfCarExists(long id, Car car) {
		if (car == null) {
			throw new EntityNotFoundException(String.format("No car with id '%d' can be found", id));
		}
	}
}

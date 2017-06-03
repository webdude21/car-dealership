package eu.webdude.cardealership.service;

import eu.webdude.cardealership.domain.dto.CarDto;
import eu.webdude.cardealership.domain.dto.InputCarDto;
import eu.webdude.cardealership.domain.entity.Car;
import eu.webdude.cardealership.domain.entity.Model;
import eu.webdude.cardealership.domain.entity.Status;
import eu.webdude.cardealership.domain.factory.CarFactory;
import eu.webdude.cardealership.repository.CarRepository;
import eu.webdude.cardealership.repository.ModelRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CarServiceImpl implements CarService {

	private CarRepository carRepo;

	private ModelRepository modelRepo;

	private CarFactory carFactory;

	@Inject
	public CarServiceImpl(CarRepository carRepo, ModelRepository modelRepo, CarFactory carFactory) {
		this.carRepo = carRepo;
		this.modelRepo = modelRepo;
		this.carFactory = carFactory;
	}

	@Override
	@Cacheable("getCarsByStatus")
	public Iterable<CarDto> getCarsByStatus(Status status) {
		return carRepo.findByStatus(status)
			.map(carFactory::createCarDto)
			.collect(Collectors.toList());
	}

	@Override
	@CacheEvict(cacheNames = {"getCarsByStatus", "getCarById"}, allEntries = true)
	public void editCar(long id, InputCarDto editedCar) {
		checkIfCarExists(id);
		Model model = modelRepo.findByNameEquals(editedCar.getModelName());
		checkIfModelExists(editedCar.getModelName(), model);
		carRepo.save(carFactory.createCar(id, editedCar, model));
	}

	@Override
	@CacheEvict(cacheNames = {"getCarsByStatus", "getCarById"}, allEntries = true)
	public Car createCar(InputCarDto carForCreation) {
		Model model = modelRepo.findByNameEquals(carForCreation.getModelName());
		checkIfModelExists(carForCreation.getModelName(), model);
		return carRepo.save(carFactory.createCar(carForCreation, model));
	}

	@Override
	@Cacheable("getCarById")
	public CarDto getCar(long id) {
		checkIfCarExists(id);
		return carFactory.createCarDto(carRepo.findOne(id));
	}

	@Override
	@CacheEvict(cacheNames = {"getCarsByStatus", "getCarById"}, allEntries = true)
	public void deleteCar(long id) {
		checkIfCarExists(id);
		carRepo.delete(id);
	}

	private void checkIfModelExists(String modelName, Model model) {
		if (model == null) {
			throw new EntityNotFoundException(String.format("No car with the name '%s' exists. Please create one first", modelName));
		}
	}

	private void checkIfCarExists(long id) {
		if (!carRepo.exists(id)) {
			throw new EntityNotFoundException(String.format("No car with id '%d' can be found", id));
		}
	}
}

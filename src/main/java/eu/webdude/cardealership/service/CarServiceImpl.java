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
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
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
	public Iterable<CarDto> getCarsAvailableForPurchase() {
		return carRepo.findByStatus(Status.FOR_SALE)
			.stream()
			.map(CarDto::new)
			.collect(Collectors.toList());
	}

	@Override
	public CarDto createCar(CreateCarDto carForCreation) {
		Model model = modelRepo.findByNameEquals(carForCreation.getModelName());
		Car createdCar = carRepo.save(domainObjectFactory.createCar(carForCreation, model));
		return new CarDto(createdCar);
	}
}

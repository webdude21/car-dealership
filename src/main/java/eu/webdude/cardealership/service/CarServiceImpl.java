package eu.webdude.cardealership.service;

import eu.webdude.cardealership.domain.entity.Status;
import eu.webdude.cardealership.domain.viewmodel.CarViewModel;
import eu.webdude.cardealership.parser.ModelParser;
import eu.webdude.cardealership.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

	private ModelParser modelParser;

	private CarRepository carRepo;

	@Autowired
	public CarServiceImpl(CarRepository carRepository, ModelParser modelParser) {
		this.carRepo = carRepository;
		this.modelParser = modelParser;
	}

	@Override
	public Iterable<CarViewModel> getCarsAvailableForPurchase() {
		return modelParser.convert(carRepo.findByStatus(Status.FOR_SALE), CarViewModel.class);
	}
}

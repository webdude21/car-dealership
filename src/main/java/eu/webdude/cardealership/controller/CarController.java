package eu.webdude.cardealership.controller;

import eu.webdude.cardealership.entity.Car;
import eu.webdude.cardealership.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "cars")
public class CarController {

	private CarService carService;

	@Autowired
	CarController(CarService carService) {
		this.carService = carService;
	}

	@RequestMapping(value = "/forsale", method = {RequestMethod.GET})
	public Iterable<Car> tickets() {
		return carService.getCarsAvailableForPurchase();
	}

}

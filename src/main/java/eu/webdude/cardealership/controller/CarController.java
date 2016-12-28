package eu.webdude.cardealership.controller;

import eu.webdude.cardealership.domain.dto.CarDto;
import eu.webdude.cardealership.domain.dto.CreateCarDto;
import eu.webdude.cardealership.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
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
	public Iterable<CarDto> tickets() {
		return carService.getCarsAvailableForPurchase();
	}

	@RequestMapping(value = "/add", method = {RequestMethod.POST})
	public ResponseEntity<CarDto> add(@RequestBody CreateCarDto carForCreation) {
		return new ResponseEntity<>(carService.createCar(carForCreation), HttpStatus.CREATED);
	}
}

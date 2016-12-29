package eu.webdude.cardealership.controller;

import eu.webdude.cardealership.domain.dto.CarDto;
import eu.webdude.cardealership.domain.dto.CreateCarDto;
import eu.webdude.cardealership.domain.entity.Status;
import eu.webdude.cardealership.errorhandling.ResponseMessage;
import eu.webdude.cardealership.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "cars")
public class CarController {

	private CarService carService;

	@Autowired
	CarController(CarService carService) {
		this.carService = carService;
	}

	@RequestMapping(value = "/{id}", method = {RequestMethod.GET})
	public CarDto getCar(@PathVariable long id) {
		return carService.getCar(id);
	}

	@RequestMapping(value = "/list", method = {RequestMethod.GET})
	public Iterable<CarDto> carsByStatus(@RequestParam(required = false, defaultValue = "FOR_SALE") Status status) {
		return carService.getCarsByStatus(status);
	}

	@RequestMapping(value = "/{id}", method = {RequestMethod.DELETE})
	public ResponseEntity<ResponseMessage> deleteCar(@PathVariable long id) {
		carService.deleteCar(id);
		return new ResponseEntity<>(new ResponseMessage("Car has been successfully deleted."), HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/add", method = {RequestMethod.POST})
	public ResponseEntity<CarDto> add(@RequestBody CreateCarDto carForCreation) {
		return new ResponseEntity<>(carService.createCar(carForCreation), HttpStatus.CREATED);
	}
}

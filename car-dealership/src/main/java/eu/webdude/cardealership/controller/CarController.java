package eu.webdude.cardealership.controller;

import eu.webdude.cardealership.domain.dto.CarDto;
import eu.webdude.cardealership.domain.dto.InputCarDto;
import eu.webdude.cardealership.domain.entity.Car;
import eu.webdude.cardealership.domain.entity.Status;
import eu.webdude.cardealership.errorhandling.ResponseMessage;
import eu.webdude.cardealership.messaging.JmsTemplateConfig;
import eu.webdude.cardealership.service.CarService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.concurrent.Callable;

@RestController
@RequestMapping(value = "cars")
public class CarController {

	private final JmsTemplate jmsTemplate;

	private final CarService carService;

	@Inject
	CarController(CarService carService, JmsTemplate jmsTemplate) {
		this.carService = carService;
		this.jmsTemplate = jmsTemplate;
	}

	@RequestMapping(value = "/{id}", method = {RequestMethod.GET})
	public Callable<CarDto> getCar(@PathVariable long id) {
		return () -> carService.getCar(id);
	}

	@RequestMapping(value = "/{id}", method = {RequestMethod.PUT})
	public ResponseEntity<ResponseMessage> editCar(@PathVariable long id, @Valid @RequestBody InputCarDto idForEdit) {
		carService.editCar(id, idForEdit);
		return new ResponseEntity<>(new ResponseMessage("Car has been successfully updated."), HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/list", method = {RequestMethod.GET})
	public Callable<Iterable<CarDto>> carsByStatus(@RequestParam(required = false, defaultValue = "FOR_SALE") Status status) {
		return () -> carService.getCarsByStatus(status);
	}

	@RequestMapping(value = "/{id}", method = {RequestMethod.DELETE})
	public Callable<ResponseEntity<ResponseMessage>> deleteCar(@PathVariable long id) {
		return () -> {
			carService.deleteCar(id);
			postCarDeleteMessage(id);
			return new ResponseEntity<>(new ResponseMessage("Car has been successfully deleted."), HttpStatus.ACCEPTED);
		};
	}

	@RequestMapping(value = "/add", method = {RequestMethod.POST})
	public ResponseEntity<?> add(@Valid @RequestBody InputCarDto carForCreation, UriComponentsBuilder ucBuilder) {
		Car createdCar = carService.createCar(carForCreation);
		return new ResponseEntity<>(getHttpHeadersForCar(ucBuilder, createdCar), HttpStatus.CREATED);
	}

	private HttpHeaders getHttpHeadersForCar(UriComponentsBuilder ucBuilder, Car createdCar) {
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/cars/{id}").buildAndExpand(createdCar.getId()).toUri());
		return headers;
	}

	private void postCarDeleteMessage(long carId) {
		jmsTemplate.convertAndSend(JmsTemplateConfig.QUEUE, String.format("Deleted car with id: %d", carId));
	}
}

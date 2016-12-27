package eu.webdude.cardealership.domain.viewmodel;

import eu.webdude.cardealership.domain.entity.Car;
import eu.webdude.cardealership.domain.entity.Color;
import eu.webdude.cardealership.domain.entity.Status;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;

public class CarViewModel implements Serializable {

	private String manufacturedAt;

	private String model;

	private Color color;

	private Double odometerReading;

	private Status status;

	private String make;

	public CarViewModel(Car car) {
		setColor(car.getColor());
		setStatus(car.getStatus());
		setManufacturedAt(car.getManufacturedAt().format(DateTimeFormatter.ISO_DATE));
		setModel(car.getModel().getName());
		setMake(car.getModel().getMake().getName());
		setOdometerReading(car.getOdometerReading());
	}

	public String getManufacturedAt() {
		return manufacturedAt;
	}

	public void setManufacturedAt(String manufacturedAt) {
		this.manufacturedAt = manufacturedAt;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}


	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Double getOdometerReading() {
		return odometerReading;
	}

	public void setOdometerReading(Double odometerReading) {
		this.odometerReading = odometerReading;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}

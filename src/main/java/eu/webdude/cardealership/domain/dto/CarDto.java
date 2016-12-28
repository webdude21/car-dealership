package eu.webdude.cardealership.domain.dto;

import eu.webdude.cardealership.domain.entity.Car;
import eu.webdude.cardealership.domain.entity.Color;
import eu.webdude.cardealership.domain.entity.Status;
import eu.webdude.cardealership.util.DateTimeUtil;

import java.io.Serializable;

public class CarDto implements Serializable {

	private String manufacturedAt;

	private String model;

	private Color color;

	private long odometerReading;

	private Status status;

	private String make;

	public CarDto(Car car) {
		setColor(car.getColor());
		setStatus(car.getStatus());
		setManufacturedAt(DateTimeUtil.toDefaultString(car.getManufacturedAt()));
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

	public long getOdometerReading() {
		return odometerReading;
	}

	public void setOdometerReading(long odometerReading) {
		this.odometerReading = odometerReading;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}

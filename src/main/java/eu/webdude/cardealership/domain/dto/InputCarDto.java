package eu.webdude.cardealership.domain.dto;

import eu.webdude.cardealership.constraint.PositiveNumber;
import eu.webdude.cardealership.domain.entity.Color;
import eu.webdude.cardealership.domain.entity.Status;

import java.io.Serializable;

public class InputCarDto implements Serializable {

	private static final long serialVersionUID = -2080580449579842278L;

	@PositiveNumber(message = "The year of manufacturing couldn't really be negative!")
	private int manufacturedAtYear;

	private String modelName;

	private Color color;

	@PositiveNumber(message = "Odometer reading couldn't really be negative!")
	private long odometerReading;

	private Status status;

	public int getManufacturedAtYear() {
		return manufacturedAtYear;
	}

	public void setManufacturedAtYear(int manufacturedAtYear) {
		this.manufacturedAtYear = manufacturedAtYear;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
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

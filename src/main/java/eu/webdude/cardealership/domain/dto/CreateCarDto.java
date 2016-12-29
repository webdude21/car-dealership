package eu.webdude.cardealership.domain.dto;

import eu.webdude.cardealership.domain.entity.Color;
import eu.webdude.cardealership.domain.entity.Status;

import java.io.Serializable;

public class CreateCarDto implements Serializable {

	private int manufacturedAtYear;

	private String modelName;

	private Color color;

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

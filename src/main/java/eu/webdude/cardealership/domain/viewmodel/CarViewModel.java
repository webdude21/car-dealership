package eu.webdude.cardealership.domain.viewmodel;

import eu.webdude.cardealership.domain.entity.Color;
import eu.webdude.cardealership.domain.entity.Status;

import java.io.Serializable;
import java.util.Date;

public class CarViewModel implements Serializable {

	private Date manufacturedAt;

	private String model;

	private Color color;

	private Double odometerReading;

	private Status status;

	public Date getManufacturedAt() {
		return manufacturedAt;
	}

	public void setManufacturedAt(Date manufacturedAt) {
		this.manufacturedAt = manufacturedAt;
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

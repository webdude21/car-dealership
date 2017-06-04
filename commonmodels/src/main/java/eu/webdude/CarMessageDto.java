package eu.webdude;

import java.io.Serializable;

public class CarMessageDto implements Serializable {

	private static final long serialVersionUID = 2395743034779912954L;

	public CarMessageDto(String manufacturedAt, String model, long odometerReading, String make) {
		this.manufacturedAt = manufacturedAt;
		this.model = model;
		this.odometerReading = odometerReading;
		this.make = make;
	}

	private String manufacturedAt;

	private String model;

	private long odometerReading;

	private String make;

	public String getManufacturedAt() {
		return manufacturedAt;
	}

	public void setManufacturedAt(String manufacturedAt) {
		this.manufacturedAt = manufacturedAt;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public long getOdometerReading() {
		return odometerReading;
	}

	public void setOdometerReading(long odometerReading) {
		this.odometerReading = odometerReading;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	@Override
	public String toString() {
		return "eu.webdude.CarMessageDto{" +
			"manufacturedAt='" + manufacturedAt + '\'' +
			", model='" + model + '\'' +
			", odometerReading=" + odometerReading +
			", make='" + make + '\'' +
			'}';
	}
}

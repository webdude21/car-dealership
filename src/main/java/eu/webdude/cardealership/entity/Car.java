package eu.webdude.cardealership.entity;

import eu.webdude.cardealership.constraint.PositiveNumber;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity {

	@Column(name = "manufactured_at")
	@Temporal(TemporalType.DATE)
	private Date manufacturedAt;

	@ManyToOne
	@JoinColumn(name = "model_id")
	private Model model;

	@Column(name = "odometer_reading")
	@PositiveNumber(message = "Odometer reading couldn't really be negative!")
	private Double odometerReading;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private Status status;

	public Car() {
		this.setStatus(Status.FOR_SALE);
	}

	public Car(double odometerReading, int manufacturedAtYear, Model model) {
		this();
		setOdometerReading(odometerReading);
		setModel(model);
		setManufacturedAt(new Date(manufacturedAtYear, 1, 1));
	}

	public Date getManufacturedAt() {
		return manufacturedAt;
	}

	public void setManufacturedAt(Date manufacturedAt) {
		this.manufacturedAt = manufacturedAt;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
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
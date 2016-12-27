package eu.webdude.cardealership.domain.entity;

import eu.webdude.cardealership.constraint.PositiveNumber;
import eu.webdude.cardealership.util.DateTimeUtil;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity {

	@Column(name = "manufactured_at")
	private ZonedDateTime manufacturedAt;

	@ManyToOne
	@JoinColumn(name = "model_id")
	private Model model;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Column(name = "color")
	private Color color;

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
		setManufacturedAt(DateTimeUtil.fromYear(manufacturedAtYear));
	}

	public Car(double odometerReading, int manufacturedAtYear, Model model, Color color) {
		this(odometerReading, manufacturedAtYear, model);
		setColor(color);
	}

	public ZonedDateTime getManufacturedAt() {
		return manufacturedAt;
	}

	public void setManufacturedAt(ZonedDateTime manufacturedAt) {
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}

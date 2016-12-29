package eu.webdude.cardealership.domain.entity;

import eu.webdude.cardealership.constraint.PositiveNumber;
import eu.webdude.cardealership.util.DateTimeUtil;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "cars")
@Audited
public class Car extends BaseEntity {

	private static final String CAR_YEAR_PRODUCTION_VALIDATION = "Model must not be null, and the car manufacture year should be during the models production period!";

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
	private long odometerReading;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private Status status;

	public Car() {
		this.setStatus(Status.FOR_SALE);
	}

	public Car(long odometerReading, int manufacturedAtYear, Model model) {
		this();
		setOdometerReading(odometerReading);
		validateManufactureYear(manufacturedAtYear, model);
		setModel(model);
		setManufacturedAt(DateTimeUtil.fromYear(manufacturedAtYear));
	}

	public Car(long odometerReading, int manufacturedAtYear, Model model, Color color) {
		this(odometerReading, manufacturedAtYear, model);
		setColor(color);
	}

	private void validateManufactureYear(int manufacturedAtYear, Model model) {
		boolean isValid = model != null;

		if (isValid) {
			if (model.getProductionEnd() == null || model.getProductionStart() == null) {
				isValid = false;
			} else if (manufacturedAtYear < model.getProductionStart().getYear() || manufacturedAtYear > model.getProductionEnd().getYear()) {
				isValid = false;
			}
		}

		if (!isValid) {
			throw new IllegalArgumentException(CAR_YEAR_PRODUCTION_VALIDATION);
		}
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

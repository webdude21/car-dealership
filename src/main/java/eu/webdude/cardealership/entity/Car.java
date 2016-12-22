package eu.webdude.cardealership.entity;

import eu.webdude.cardealership.annotation.PositiveNumber;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "car_id")
	private int id;

	@Column(name = "manufactured_at")
	@Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentZonedDateTime")
	private ZonedDateTime manufacturedAt;

	@ManyToOne
	@JoinColumn(name = "make_id", referencedColumnName = "id")
	private Make make;

	@ManyToOne
	@NotNull
	@JoinColumn(name = "model_id", referencedColumnName = "id")
	private Model model;

	@Column
	@PositiveNumber
	private Double odometerReading;
}

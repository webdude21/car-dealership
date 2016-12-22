package eu.webdude.cardealership.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.ZonedDateTime;

class Model {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "model_id")
	private int id;

	@Column(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "make_id", referencedColumnName = "id")
	private Make make;

	@Column(name = "info", columnDefinition = "TEXT")
	private String info;

	@Column(name = "production_start")
	@Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentZonedDateTime")
	private ZonedDateTime prodctionStart;

	@Column(name = "production_end")
	@Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentZonedDateTime")
	private ZonedDateTime productionEnd;
}


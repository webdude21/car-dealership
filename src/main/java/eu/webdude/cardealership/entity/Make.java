package eu.webdude.cardealership.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Set;

@Entity
@Table(name = "make")
public class Make extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "make_id")
	private int id;

	@OneToMany(mappedBy = "make", targetEntity = Model.class)
	Set<Model> models;

	@Column(name = "name")
	private String name;

	@Column(name = "info", columnDefinition = "TEXT")
	private String info;

	@Column(name = "founded_at")
	@Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentZonedDateTime")
	private ZonedDateTime foundedAt;
}

package eu.webdude.cardealership.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "make")
public class Make extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "info", columnDefinition = "TEXT")
	private String info;

	@Column(name = "founded_at")
	@Temporal(TemporalType.DATE)
	@Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentZonedDateTime")
	private ZonedDateTime foundedAt;
}

package eu.webdude.cardealership.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.ZonedDateTime;
import java.util.Set;

@Entity
@Table(name = "makes")
public class Make extends BaseEntity {

	@OneToMany(mappedBy = "make", targetEntity = Model.class)
	private Set<Model> models;


	@Column(name = "name")
	private String name;

	@Column(name = "info", columnDefinition = "TEXT")
	private String info;

	@Column(name = "founded_at")
	private ZonedDateTime foundedAt;

	public Make(String name, ZonedDateTime foundedAt) {
		setName(name);
		setFoundedAt(foundedAt);
	}

	Make() {
	}

	public Set<Model> getModels() {
		return models;
	}

	public void setModels(Set<Model> models) {
		this.models = models;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public ZonedDateTime getFoundedAt() {
		return foundedAt;
	}

	public void setFoundedAt(ZonedDateTime foundedAt) {
		this.foundedAt = foundedAt;
	}
}

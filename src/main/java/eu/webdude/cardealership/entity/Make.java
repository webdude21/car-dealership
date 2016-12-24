package eu.webdude.cardealership.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "make")
public class Make extends BaseEntity {

	@OneToMany(mappedBy = "make", targetEntity = Model.class)
	private Set<Model> models;


	@Column(name = "name")
	private String name;

	@Column(name = "info", columnDefinition = "TEXT")
	private String info;

	@Column(name = "founded_at")
	@Temporal(TemporalType.DATE)
	private Date foundedAt;

	public Make(String name, Date foundedAt) {
		setName(name);
		setFoundedAt(foundedAt);
	}

	Make() {}

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

	public Date getFoundedAt() {
		return foundedAt;
	}

	public void setFoundedAt(Date foundedAt) {
		this.foundedAt = foundedAt;
	}
}

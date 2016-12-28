package eu.webdude.cardealership.domain.entity;

import eu.webdude.cardealership.util.DateTimeUtil;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "models")
public class Model extends BaseEntity {

	@Column(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "make_id")
	private Make make;

	@Column(name = "info", columnDefinition = "TEXT")
	private String info;

	@Column(name = "production_start")
	private ZonedDateTime productionStart;

	@Column(name = "production_end")
	private ZonedDateTime productionEnd;

	public Model(String name, Make make, int productionStartYear, int productionEndYear) {
		setName(name);
		setMake(make);
		setProductionStart(DateTimeUtil.fromYear(productionStartYear));
		setProductionEnd(DateTimeUtil.fromYear(productionEndYear));
	}

	Model() {
	}

	public ZonedDateTime getProductionStart() {
		return productionStart;
	}

	public void setProductionStart(ZonedDateTime productionStart) {
		this.productionStart = productionStart;
	}

	public ZonedDateTime getProductionEnd() {
		return productionEnd;
	}

	public void setProductionEnd(ZonedDateTime productionEnd) {
		this.productionEnd = productionEnd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Make getMake() {
		return make;
	}

	public void setMake(Make make) {
		this.make = make;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}


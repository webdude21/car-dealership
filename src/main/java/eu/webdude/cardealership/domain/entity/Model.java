package eu.webdude.cardealership.domain.entity;

import javax.persistence.*;
import java.util.Date;

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
	@Temporal(TemporalType.DATE)
	private Date productionStart;

	@Column(name = "production_end")
	@Temporal(TemporalType.DATE)
	private Date productionEnd;

	public Model(String name, Make make, int productionStartYear, int productionEndYear) {
		setName(name);
		setMake(make);
		setProductionStart(new Date(productionStartYear));
		setProductionStart(new Date());

	}

	Model() {
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

	public Date getProductionStart() {
		return productionStart;
	}

	public void setProductionStart(Date productionStart) {
		this.productionStart = productionStart;
	}

	public Date getProductionEnd() {
		return productionEnd;
	}

	public void setProductionEnd(Date productionEnd) {
		this.productionEnd = productionEnd;
	}
}


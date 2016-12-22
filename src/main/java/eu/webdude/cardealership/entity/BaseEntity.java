package eu.webdude.cardealership.entity;

import org.hibernate.envers.Audited;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@Audited
abstract class BaseEntity implements Serializable {
}

/**
 * Course.java Fecha de creacion: 08/01/2018, 14:29:59 Copyright (c) 2018 Omar Rebollo Todos
 * los derechos reservados. Este software es informacion confidencial, propiedad de Omar
 * Rebollo. Esta informacion confidencial no debera ser divulgada y solo se podra utilizar de
 * acuerdo a los terminos que determine la propia persona.
 */
package omare.com.mx.springboot.hibernatejpa.hibernatejpaapplication.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Omar Rebollo (omar.rebollo@gmail.com)
 * @version 1.0
 * @since
 */
@Entity
@NamedQueries(
	value = { @NamedQuery(name = "find_all_courses", query = "Select c from Course c"),
		@NamedQuery(name = "find_namedQuery_course",
			query = "Select c from Course c where name like '%ava'") })
public class Course {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(name = "CREATED_DATE")
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;

	@Column(name = "LAST_UPDATED_DATE")
	@CreationTimestamp
	private LocalDateTime createdDate;

	@Column(name = "IS_DELETED")
	private Boolean isDeleted;

	/**
	 * @return el atributo id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id parametro id a actualizar
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return el atributo name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name parametro name a actualizar
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return el atributo lastUpdatedDate
	 */
	public LocalDateTime getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	/**
	 * @param lastUpdatedDate parametro lastUpdatedDate a actualizar
	 */
	public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	/**
	 * @return el atributo createdDate
	 */
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate parametro createdDate a actualizar
	 */
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return el atributo isDeleted
	 */
	public Boolean getIsDeleted() {
		return isDeleted;
	}

	/**
	 * @param isDeleted parametro isDeleted a actualizar
	 */
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que lo declara
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Course [id=")
			.append(id)
			.append(", name=")
			.append(name)
			.append(", lastUpdatedDate=")
			.append(lastUpdatedDate)
			.append(", createdDate=")
			.append(createdDate)
			.append(", isDeleted=")
			.append(isDeleted)
			.append("]");
		return builder.toString();
	}

}

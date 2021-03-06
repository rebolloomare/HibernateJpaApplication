/**
 * Person.java Fecha de creacion: 19/12/2017, 19:49:27 Copyright (c) 2017 Omar Rebollo Todos
 * los derechos reservados. Este software es informacion confidencial, propiedad de Omar
 * Rebollo. Esta informacion confidencial no debera ser divulgada y solo se podra utilizar de
 * acuerdo a los terminos que determine la propia persona.
 */
package omare.com.mx.springboot.hibernatejpa.hibernatejpaapplication.entity;

import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@NamedQuery(name = "find_all_persons", query = "select p from Person p")

public class Person {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	private String location;

	@Column(name = "BIRTH_DATE")
	private Date birthDate;

	@Column(name = "CREATED_DATE")
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;

	@Column(name = "LAST_UPDATED_DATE")
	@CreationTimestamp
	private LocalDateTime createdDate;

	/**
	 * TODO [Agregar documentacion al metodo]
	 * @author Omar Rebollo (omar.rebollo@gmail.com)
	 */

	public Person() {
	}

	/**
	 * TODO [Agregar documentacion al metodo]
	 * @author Omar Rebollo (omar.rebollo@gmail.com)
	 * @param name
	 * @param location
	 * @param birthDate
	 */

	public Person(String name, String location, Date birthDate) {
		super();
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}

	/**
	 * TODO [Agregar documentacion al metodo]
	 * @author Omar Rebollo (omar.rebollo@gmail.com)
	 * @param i
	 * @param string
	 * @param string2
	 * @param date
	 */

	public Person(Long id, String name, String location, Date birthDate) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}

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
	 * @return el atributo location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location parametro location a actualizar
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return el atributo birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate parametro birthDate a actualizar
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
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

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que lo declara
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [id=")
			.append(id)
			.append(", name=")
			.append(name)
			.append(", location=")
			.append(location)
			.append(", birthDate=")
			.append(birthDate)
			.append(", lastUpdatedDate=")
			.append(lastUpdatedDate)
			.append(", createdDate=")
			.append(createdDate)
			.append("]");
		return builder.toString();
	}

}

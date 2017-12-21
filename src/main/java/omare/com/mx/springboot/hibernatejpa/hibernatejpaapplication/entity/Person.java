/**
 * Person.java Fecha de creación: 19/12/2017, 19:49:27 Copyright (c) 2017 Omar Rebollo Todos
 * los derechos reservados. Este software es información confidencial, propiedad de Omar
 * Rebollo. Esta información confidencial no deberá ser divulgada y solo se podrá utilizar
 * de acuerdo a los términos que determine la propia persona.
 */
package omare.com.mx.springboot.hibernatejpa.hibernatejpaapplication.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

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
	private int id;

	private String name;

	private String location;

	private Date birthDate;

	/**
	 * TODO [Agregar documentacion al método]
	 * @author Omar Rebollo (omar.rebollo@gmail.com)
	 */

	public Person() {
	}

	/**
	 * TODO [Agregar documentacion al método]
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
	 * TODO [Agregar documentacion al método]
	 * @author Omar Rebollo (omar.rebollo@gmail.com)
	 * @param i
	 * @param string
	 * @param string2
	 * @param date
	 */

	public Person(int id, String name, String location, Date birthDate) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}

	/**
	 * @return el atributo id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id parametro id a actualizar
	 */
	public void setId(int id) {
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

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo declara
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
			.append("]");
		return builder.toString();
	}

}

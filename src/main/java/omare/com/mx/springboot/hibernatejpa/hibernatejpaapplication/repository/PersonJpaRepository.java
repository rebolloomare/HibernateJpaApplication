/**
 * PersonJpaRepository.java Fecha de creaci�n: 20/12/2017, 16:30:31 Copyright (c) 2017 Omar
 * Rebollo Todos los derechos reservados. Este software es informaci�n confidencial, propiedad
 * de Omar Rebollo. Esta informaci�n confidencial no deber� ser divulgada y solo se podr�
 * utilizar de acuerdo a los t�rminos que determine la propia persona.
 */
package omare.com.mx.springboot.hibernatejpa.hibernatejpaapplication.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import omare.com.mx.springboot.hibernatejpa.hibernatejpaapplication.entity.Person;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Omar Rebollo (omar.rebollo@gmail.com)
 * @version 1.0
 * @since
 */
@Repository
@Transactional
public class PersonJpaRepository {

	/**
	 * TODO [Agregar documentaci�n del atributo]
	 */
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * TODO [Agregar documentacion al m�todo]
	 * @author Omar Rebollo (omar.rebollo@gmail.com)
	 * @param id
	 * @return
	 */
	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}

	/**
	 * TODO [Agregar documentacion al m�todo]
	 * @author Omar Rebollo (omar.rebollo@gmail.com)
	 * @param person
	 * @return
	 */
	public Person update(Person person) {
		return entityManager.merge(person);
	}

	/**
	 * TODO [Agregar documentacion al m�todo]
	 * @author Omar Rebollo (omar.rebollo@gmail.com)
	 * @param person
	 * @return
	 */
	public Person insert(Person person) {
		return entityManager.merge(person);
	}

	/**
	 * TODO [Agregar documentacion al m�todo]
	 * @author Omar Rebollo (omar.rebollo@gmail.com)
	 * @param id
	 */
	public void deleteById(int id) {
		Person person = findById(id);
		entityManager.merge(person);
	}

	public List<Person> findAll() {
		TypedQuery<Person> namedQuery =
			entityManager.createNamedQuery("find_all_persons", Person.class);
		return namedQuery.getResultList();
	}

}

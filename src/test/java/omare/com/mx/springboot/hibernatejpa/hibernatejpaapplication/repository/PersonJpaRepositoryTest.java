/**
 * PersonJpaRepositoryTest.java Fecha de creacion: 24/12/2017, 12:29:29 Copyright (c) 2017 Omar
 * Rebollo Todos los derechos reservados. Este software es informacion confidencial, propiedad
 * de Omar Rebollo. Esta informacion confidencial no debera ser divulgada y solo se podrá
 * utilizar de acuerdo a los terminos que determine la propia persona.
 */
package omare.com.mx.springboot.hibernatejpa.hibernatejpaapplication.repository;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import omare.com.mx.springboot.hibernatejpa.hibernatejpaapplication.HibernateJpaApplication;
import omare.com.mx.springboot.hibernatejpa.hibernatejpaapplication.entity.Person;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Omar Rebollo (omar.rebollo@gmail.com)
 * @version 1.0
 * @since
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HibernateJpaApplication.class)
public class PersonJpaRepositoryTest {

	/**
	 * TODO [Agregar documentacion del atributo]
	 */
	private Logger logger = LoggerFactory.getLogger(PersonJpaRepositoryTest.class);

	/**
	 * TODO [Agregar documentacion del atributo]
	 */
	@Autowired
	private PersonJpaRepository personJpaRepository;

	/**
	 * TODO [Agregar documentacion al metodo]
	 * @author Omar Rebollo (omar.rebollo@gmail.com)
	 */
	@Test
	public void findById() {
		logger.info("Testing is running");
		Person person = personJpaRepository.findById(10001L);
		assertEquals("Omar", person.getName());
	}

	/**
	 * TODO [Agregar documentacion al método]
	 * @author Omar Rebollo (omar.rebollo@gmail.com)
	 */
	@Test
	@DirtiesContext
	public void deletById_basic() {
		personJpaRepository.deleteById(10003L);
	}

	/**
	 * TODO [Agregar documentacion al método]
	 * @author Omar Rebollo (omar.rebollo@gmail.com)
	 */
	@Test
	@DirtiesContext
	public void save_basic() {
		Person person = personJpaRepository.findById(10001L);
		assertEquals("Omar", person.getName());

		person.setName("Mary - updated");

		personJpaRepository.insert(person);

		Person personUpdated = personJpaRepository.findById(10001L);
		assertEquals("Mary - updated", personUpdated.getName());

	}
}

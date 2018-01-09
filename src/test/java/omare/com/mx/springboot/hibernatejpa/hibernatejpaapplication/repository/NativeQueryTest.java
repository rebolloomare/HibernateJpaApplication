/**
 * JPQLTest.java Fecha de creacion: 07/01/2018, 20:20:14 Copyright (c) 2018 Omar Rebollo Todos
 * los derechos reservados. Este software es informacion confidencial, propiedad de Omar
 * Rebollo. Esta informacion confidencial no debera ser divulgada y solo se podra utilizar de
 * acuerdo a los terminos que determine la propia persona.
 */
package omare.com.mx.springboot.hibernatejpa.hibernatejpaapplication.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import omare.com.mx.springboot.hibernatejpa.hibernatejpaapplication.HibernateJpaApplication;
import omare.com.mx.springboot.hibernatejpa.hibernatejpaapplication.entity.Course;
import omare.com.mx.springboot.hibernatejpa.hibernatejpaapplication.entity.Person;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Omar Rebollo (omar.rebollo@gmail.com)
 * @version 1.0
 * @since
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HibernateJpaApplication.class)
public class NativeQueryTest {

	/**
	 * TODO [Agregar documentacion del atributo]
	 */
	private Logger logger = LoggerFactory.getLogger(NativeQueryTest.class);

	/**
	 * TODO [Agregar documentación del atributo]
	 */
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * TODO [Agregar documentacion al metodo]
	 * @author Omar Rebollo (omar.rebollo@gmail.com)
	 */
	@Test
	public void findById_jpqlBasic() {
		List listPersona = entityManager.createQuery("Select p from Person p").getResultList();
		logger.info("Select p from Persona p -> {}", listPersona);
	}

	/**
	 * TODO [Agregar documentacion al metodo]
	 * @author Omar Rebollo (omar.rebollo@gmail.com)
	 */
	@Test
	public void findById_jpqlTyped() {
		TypedQuery<Person> query =
			entityManager.createQuery("Select p from Person p", Person.class);
		List<Person> listPersona = query.getResultList();
		logger.info("Select p from Persona p -> {}", listPersona);
	}

	/**
	 * TODO [Agregar documentacion al metodo]
	 * @author Omar Rebollo (omar.rebollo@gmail.com)
	 */
	@Test
	public void findById_jpqlWhere() {
		TypedQuery<Person> query = entityManager
			.createQuery("Select p from Person p where name like '%mar'", Person.class);
		List<Person> listPersona = query.getResultList();
		logger.info("Select p from Person p where name like '%mar'", listPersona);
	}

	/**
	 * TODO [Agregar documentacion al metodo]
	 * @author Omar Rebollo (omar.rebollo@gmail.com)
	 */
	@Test
	public void findById_jpqlWhereNamedQuery() {
		TypedQuery<Course> query =
			entityManager.createNamedQuery("find_namedQuery_course", Course.class);
		List<Course> listCourse = query.getResultList();
		logger.info("find_namedQuery_course", listCourse);
	}

}

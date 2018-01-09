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
import javax.persistence.Query;
import javax.transaction.Transactional;
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
public class JPQLTest {

	/**
	 * TODO [Agregar documentacion del atributo]
	 */
	private Logger logger = LoggerFactory.getLogger(JPQLTest.class);

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
	public void findById_NativeQuery() {
		Query query = entityManager.createNativeQuery("Select * from Person", Person.class);
		List listPersona = query.getResultList();
		logger.info("Select * from Persona p -> {}", listPersona);
	}

	/**
	 * TODO [Agregar documentacion al metodo]
	 * @author Omar Rebollo (omar.rebollo@gmail.com)
	 */
	@Test
	public void findById_NativeQuery_with_parameters() {
		Query query =
			entityManager.createNativeQuery("Select * from Course where id = ?", Course.class);
		query.setParameter(1, 10001L);
		List listCourse = query.getResultList();
		logger.info("Select * from Course c -> {}", listCourse);
	}

	/**
	 * TODO [Agregar documentacion al metodo]
	 * @author Omar Rebollo (omar.rebollo@gmail.com)
	 */
	@Test
	public void findById_NativeQuery_with_named_parameter() {
		Query query = entityManager.createNativeQuery("Select * from Course where id = :id",
			Course.class);
		query.setParameter("id", 10001L);
		List listCourse = query.getResultList();
		logger.info("Select * from Course c -> {}", listCourse);
	}

	/**
	 * TODO [Agregar documentacion al metodo]
	 * @author Omar Rebollo (omar.rebollo@gmail.com)
	 */
	@Test
	@Transactional
	public void native_queries_to_update() {
		Query query =
			entityManager.createNativeQuery("UPDATE Course set last_updated_date=sysdate()");
		int nRowsAffected = query.executeUpdate();
		logger.info("nRowsAffected -> {}", nRowsAffected);
	}

}

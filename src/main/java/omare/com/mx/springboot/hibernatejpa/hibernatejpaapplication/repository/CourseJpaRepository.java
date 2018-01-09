/**
 * CourseJpaRepository.java Fecha de creacion: 08/01/2018, 20:04:16 Copyright (c) 2018 Omar
 * Rebollo Todos los derechos reservados. Este software es informacion confidencial, propiedad
 * de Omar Rebollo. Esta informacion confidencial no debera ser divulgada y solo se podra
 * utilizar de acuerdo a los terminos que determine la propia persona.
 */
package omare.com.mx.springboot.hibernatejpa.hibernatejpaapplication.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import omare.com.mx.springboot.hibernatejpa.hibernatejpaapplication.entity.Course;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Omar Rebollo (omar.rebollo@gmail.com)
 * @version 1.0
 * @since
 */
@Repository
@Transactional
public class CourseJpaRepository {

	/**
	 * TODO [Agregar documentación del atributo]
	 */
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * TODO [Agregar documentacion al metodo]
	 * @author Omar Rebollo (omar.rebollo@gmail.com)
	 * @param id
	 * @return
	 */
	public Course findById(Long id) {
		return entityManager.find(Course.class, id);
	}

	/**
	 * TODO [Agregar documentacion al metodo]
	 * @author Omar Rebollo (omar.rebollo@gmail.com)
	 * @param course
	 * @return
	 */
	public Course update(Course course) {
		return entityManager.merge(course);
	}

	/**
	 * TODO [Agregar documentacion al metodo]
	 * @author Omar Rebollo (omar.rebollo@gmail.com)
	 * @param course
	 * @return
	 */
	public Course insert(Course course) {
		if (course.getId() == null) {
			entityManager.persist(course);
		} else {
			entityManager.merge(course);
		}
		return course;
	}

	/**
	 * TODO [Agregar documentacion al metodo]
	 * @author Omar Rebollo (omar.rebollo@gmail.com)
	 * @param id
	 */
	public void deleteById(Long id) {
		Course course = findById(id);
		entityManager.remove(course);
	}

	/**
	 * TODO [Agregar documentacion al metodo]
	 * @author Omar Rebollo (omar.rebollo@gmail.com)
	 * @return
	 */
	public List<Course> findAll() {
		TypedQuery<Course> namedQuery =
			entityManager.createNamedQuery("find_all_courses", Course.class);
		return namedQuery.getResultList();
	}
}

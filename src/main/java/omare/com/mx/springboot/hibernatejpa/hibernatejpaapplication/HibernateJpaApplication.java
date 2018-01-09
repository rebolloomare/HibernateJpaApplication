package omare.com.mx.springboot.hibernatejpa.hibernatejpaapplication;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import omare.com.mx.springboot.hibernatejpa.hibernatejpaapplication.entity.Person;
import omare.com.mx.springboot.hibernatejpa.hibernatejpaapplication.repository.CourseJpaRepository;
import omare.com.mx.springboot.hibernatejpa.hibernatejpaapplication.repository.PersonJpaRepository;

@SpringBootApplication
public class HibernateJpaApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(HibernateJpaApplication.class);

	@Autowired
	private PersonJpaRepository personJpaRepository;

	@Autowired
	private CourseJpaRepository courseJpaRepository;

	public static void main(String[] args) {
		SpringApplication.run(HibernateJpaApplication.class, args);
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo declara
	 * (non-Javadoc)
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String... args) throws Exception {
		logger.info("User id -> {} ", personJpaRepository.findById(10001L));
		logger.info("Inserting 10004 -> {} ",
			personJpaRepository.insert(new Person(10004L, "Omar", "Mexico", new Date())));
		logger.info("Inserting again 10004 -> {} ",
			personJpaRepository.insert(new Person(10004L, "Omar", "Mexicou", new Date())));
		logger.info("Update 10003 -> {} ",
			personJpaRepository.update(new Person(10003L, "Omare2", "Escocia", new Date())));
		logger.info("find all -> {} ", personJpaRepository.findAll());
		logger.info("find all -> {} ", courseJpaRepository.findAll());
	}
}

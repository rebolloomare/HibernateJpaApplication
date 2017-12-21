package omare.com.mx.springboot.hibernatejpa.hibernatejpaapplication;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import omare.com.mx.springboot.hibernatejpa.hibernatejpaapplication.repository.PersonJpaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@ActiveProfiles("test")
public class HibernateJpaApplicationTests {

	@Autowired
	private PersonJpaRepository personJpaRepository;

	@Test
	public void findById() throws Exception {
		assertNotNull(personJpaRepository.findAll());
	}

}

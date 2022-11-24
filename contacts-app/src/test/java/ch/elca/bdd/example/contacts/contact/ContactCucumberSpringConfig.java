package ch.elca.bdd.example.contacts.contact;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Mark Spoerndli
 */
@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ContactsApplication.class)
public class ContactCucumberSpringConfig {
}

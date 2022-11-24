package ch.elca.bdd.example.contacts.contact;


import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;

/**
 * @author Mark Spoerndli
 */
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("ch/elca/bdd/example/contacts/contact")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "ch.elca.bdd.example.contacts.contact")
@ExtendWith(SpringExtension.class)
public class ContactIntegrationTests {
}

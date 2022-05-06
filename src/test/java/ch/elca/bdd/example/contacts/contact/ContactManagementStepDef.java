package ch.elca.bdd.example.contacts.contact;

import ch.elca.bdd.example.contacts.contact.contact.ContactController;
import ch.elca.bdd.example.contacts.contact.contact.ContactService;
import ch.elca.bdd.example.contacts.contact.contact.CreateContactAction;
import ch.elca.bdd.example.contacts.contact.contact.dto.ContactResponseDTO;
import ch.elca.bdd.example.contacts.contact.contact.dto.CreateContactRequestDTO;
import io.cucumber.java8.En;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * This implements the Gherkin Steps defined in the feature file (resources/ch/elca/bdd/example/contacts/contact/contact_management.feature)
 */
public class ContactManagementStepDef implements En {

    @Autowired
    ContactService contactService;

    @Autowired
    protected TestRestTemplate restTemplate;

    @LocalServerPort
    private int localPort;


    public ContactManagementStepDef() {
        Given("a user has {int} registered contacts so far", (Integer numberOfExistingContacts) -> {
            // because here we just prepare the initial test data, we can directly access the ContactService component,
            // instead of going through the REST interface
            IntStream.range(0, numberOfExistingContacts).forEach((i) ->
                    contactService.createContact(
                            CreateContactAction.builder().name("Contact " + i).build()));
        });
        When("the user adds a new contact named {string}", (String contactName) -> {
            //create a new contact trough the REST interface
            CreateContactRequestDTO request = new CreateContactRequestDTO();
            request.setName(contactName);
            ResponseEntity<ContactResponseDTO> createResponse = restTemplate.postForEntity(getLocalTestURL(),
                    request,
                    ContactResponseDTO.class);
        });
        Then("contact list contains a contact named {string}", (String contactName) -> {
            //check contacts list through REST interface
            ContactResponseDTO[] response = restTemplate.getForEntity(getLocalTestURL(), ContactResponseDTO[].class).getBody();
            assertNotNull(response);
            assertTrue(Arrays.stream(response).map(ContactResponseDTO::getName).anyMatch(name -> StringUtils.equals(name, contactName)));
        });
        And("contact list contains {int} entries", (Integer expectedNumberOfEntries) -> {
            //check number of contacts in list through REST interface
            ContactResponseDTO[] response = restTemplate.getForEntity(getLocalTestURL(), ContactResponseDTO[].class).getBody();
            assertNotNull(response);
            assertEquals(expectedNumberOfEntries, response.length);
        });
    }

    private String getLocalTestURL() {
        return "http://localhost:" + localPort + ContactController.PATH;
    }
}

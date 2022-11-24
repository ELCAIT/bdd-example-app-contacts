package ch.elca.bdd.example.contacts.contact.contact;

import ch.elca.bdd.example.contacts.contact.contact.dto.ContactResponseDTO;
import ch.elca.bdd.example.contacts.contact.contact.dto.CreateContactRequestDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mark Spoerndli
 */
@RestController
@RequestMapping(ContactController.PATH)
@AllArgsConstructor
@Slf4j
public class ContactController {
    public static final String PATH = "/contacts";

    private final ContactMapper contactMapper;
    private final ContactService contactService;

    @PostMapping(produces = {"application/json"},
            consumes = {"application/json"}
    )
    public ResponseEntity<ContactResponseDTO> createContact(@RequestBody CreateContactRequestDTO createContactRequestDTO) {
        Contact contact = contactService.createContact(contactMapper.createContactRequestDTOToCreateContactAction(createContactRequestDTO));
        ContactResponseDTO contactResponseDTO = contactMapper.contactToContactResponseDTO(contact);
        return new ResponseEntity<>(
                contactResponseDTO,
                HttpStatus.CREATED);
    }

    @GetMapping
    public ContactResponseDTO[] getContacts() {
        return contactMapper.contactsToContactResponseDTOs(contactService.getContacts().toArray(new Contact[]{}));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllContacts() {
        return contactService.deleteAllContacts();
    }

}

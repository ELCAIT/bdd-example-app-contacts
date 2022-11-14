package ch.elca.bdd.example.contacts.contact.contact;

import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Service
public class ContactService {

    @Getter
    private final Collection<Contact> contacts = new ArrayList<>();

    public Contact createContact(CreateContactAction createContactAction){
        Contact newContact = new Contact(UUID.randomUUID(), createContactAction.getName());
        contacts.add(newContact);
        return newContact;
    }

    public ResponseEntity<Void> deleteAllContacts() {
        contacts.clear();
        return ResponseEntity.ok().build();
    }
}

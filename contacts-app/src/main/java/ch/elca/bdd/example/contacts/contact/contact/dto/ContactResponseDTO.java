package ch.elca.bdd.example.contacts.contact.contact.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * @author Mark Spoerndli
 */
@Getter
@Setter
public class ContactResponseDTO {
    private UUID id;
    private String name;
}

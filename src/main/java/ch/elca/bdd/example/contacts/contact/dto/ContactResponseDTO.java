package ch.elca.bdd.example.contacts.contact.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ContactResponseDTO {
    private UUID id;
    private String name;
}

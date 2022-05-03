package ch.elca.bdd.example.contacts.contact.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CreateContactRequestDTO {
    private String name;
}

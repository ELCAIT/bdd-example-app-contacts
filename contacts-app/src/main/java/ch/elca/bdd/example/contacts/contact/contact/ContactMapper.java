package ch.elca.bdd.example.contacts.contact.contact;

import ch.elca.bdd.example.contacts.contact.contact.dto.ContactResponseDTO;
import ch.elca.bdd.example.contacts.contact.contact.dto.CreateContactRequestDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    CreateContactAction createContactRequestDTOToCreateContactAction(CreateContactRequestDTO createContactRequestDTO);

    ContactResponseDTO contactToContactResponseDTO(Contact contact);

    ContactResponseDTO[] contactsToContactResponseDTOs(Contact[] contacts);
}

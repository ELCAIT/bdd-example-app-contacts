package ch.elca.bdd.example.contacts.contact;

import ch.elca.bdd.example.contacts.contact.dto.CreateContactRequestDTO;
import ch.elca.bdd.example.contacts.contact.dto.ContactResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    CreateContactAction createContactRequestDTOToCreateContactAction(CreateContactRequestDTO createContactRequestDTO);

    ContactResponseDTO contactToContactResponseDTO(Contact contact);

    ContactResponseDTO[] contactsToContactResponseDTOs(Contact[] contacts);
}

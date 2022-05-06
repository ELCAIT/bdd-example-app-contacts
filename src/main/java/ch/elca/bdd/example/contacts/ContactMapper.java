package ch.elca.bdd.example.contacts;

import ch.elca.bdd.example.contacts.dto.ContactResponseDTO;
import ch.elca.bdd.example.contacts.dto.CreateContactRequestDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    CreateContactAction createContactRequestDTOToCreateContactAction(CreateContactRequestDTO createContactRequestDTO);

    ContactResponseDTO contactToContactResponseDTO(Contact contact);

    ContactResponseDTO[] contactsToContactResponseDTOs(Contact[] contacts);
}

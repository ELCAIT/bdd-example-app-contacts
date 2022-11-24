package ch.elca.bdd.example.contacts.contact.contact;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Mark Spoerndli
 */
@Setter
@Getter
@Builder
public class CreateContactAction {
    private String name;
}

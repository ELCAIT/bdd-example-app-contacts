package ch.elca.bdd.example.contacts;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class CreateContactAction {
    private String name;
}

# Example App to demonstrate BDD setup with Spring, Cucumber, Cypress

This project contains example setups for running BDD-Tests at Service level and at UI level in a Spring Boot Web Application.

## Executing Service Level Tests 
An example scenario is defined in [contacts-app/src/test/resources/ch/elca/bdd/example/contacts/contact/contact/contact_management.featur](contacts-app/src/test/resources/ch/elca/bdd/example/contacts/contact/contact/contact_management.feature).

To execute the example scenario against the contact service use: 
  ```bash
  gradle :contacts-app:check
  ```

This will run the tests against the REST API of the service, using JUnit.

## Executing UI Level Tests 
The same example scenario can also be run against the Web-UI using cypress.
The scenario definition is the same, but in this case it is located in [contacts-ui-tests/cypress/integration/contact_management.feature](contacts-ui-tests/cypress/integration/contact_management.feature)

To execute the example scenario against in cypress use: 
  ```bash
  gradle :contacts-ui-tests:check
  ```

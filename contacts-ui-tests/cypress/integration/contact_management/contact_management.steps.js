import {Given, Then, When} from 'cypress-cucumber-preprocessor/steps';

import ContactsPage from '../../support/page_objects/ContactsPage';

const contactsPage = new ContactsPage();


Given('a user has 2 registered contacts so far', () => {
    cy.deleteAllExistingContacts();
    cy.createContacts('contacts.json');
    contactsPage.visitContactsPage();
})

When('the user adds a new contact named {string}', (contactName) => {
    contactsPage.getCreateContactNameField().type(contactName);
    contactsPage.getCreateContactSaveButton().click();
})
Then('contact list contains a contact named {string}', (contactName) => {
    contactsPage.getContactsTable().should("contain.text", contactName);
})

Then('contact list contains {int} entries', (expectedContactsCount) => {
    contactsPage.getContactsTableRows().should("have.length", expectedContactsCount);
})

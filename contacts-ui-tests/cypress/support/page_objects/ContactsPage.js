class ContactsPage {
    visitContactsPage = () => cy.visit('http://localhost:8080/');

    getCreateContactNameField = () => cy.get('#createContactName');

    getCreateContactSaveButton = () => cy.get('#saveContact');

    getContactsTable = () => cy.get('#contacts-table');

    getContactsTableRows = () => this.getContactsTable().find('tr');
}

export default ContactsPage;
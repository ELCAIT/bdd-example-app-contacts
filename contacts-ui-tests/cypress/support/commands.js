Cypress.Commands.add('createContacts', (fixtureFilename) => {
    cy.fixture(fixtureFilename).then((contacts) => {
        contacts.forEach((contact) => {
            cy.request({
                method: 'POST',
                url: '/contacts',
                headers: {
                    'content-type': 'application/json',
                },
                failOnStatusCode: false,
                body: {
                    name: contact.name,
                }
            }).then((response) => {
                expect(response.status).to.equal(201);
            });
        });
    });
});
Cypress.Commands.add('deleteAllExistingContacts', () => {
    cy.request({
        method: 'DELETE',
        url: '/contacts',
        headers: {
            'content-type': 'application/json',
        },
        failOnStatusCode: false,
    }).then((response) => {
        expect(response.status).to.equal(200);
    });
});

Cypress.Commands.add('createContacts', (body) => {
    cy.fixture('contacts.json').then((contacts) => {
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
                    ...body
                }
            }).then((response) => {
                expect(response.status).to.equal(201);
            });
        });
    });
});

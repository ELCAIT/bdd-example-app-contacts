describe('contacts-app', () => {
  beforeEach(() => {
    cy.visit('http://localhost:8080')
  })

  it('displays two todo items by default', () => {
    // We use the `cy.get()` command to get all elements that match the selector.
    // Then, we use `should` to assert that there are two matched items,
    // which are the two default items.
    cy.get('.todo-list li').should('have.length', 2)
  })

})

/// <reference types="cypress" />

/**
 * @type {Cypress.PluginConfig}
 */
// eslint-disable-next-line no-unused-vars
const cucumber = require('cypress-cucumber-preprocessor').default;

module.exports = (on, _config) => {
    on('file:preprocessor', cucumber());
}

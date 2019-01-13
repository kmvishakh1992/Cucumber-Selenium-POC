Feature: Free CRM Create Contacts

Scenario Outline: Free CRM Create a new contact scenario

Given user is already on Login Page
Then user enters "<name>" and "<password>"

Examples:
	|name|password|
	|adasd|sdcfdf|
	|test|wsd1|
	|test2|wsd1|
	|test3|wsd1|
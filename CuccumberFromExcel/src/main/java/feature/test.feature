Feature: Excel Read wsd test

Scenario Outline: Excel Read wsd test

Given user is already on WSD page
Then user enters "<dataid>" 
And enters submit button

Examples:
	|dataid|
	|0|
	|1|
	|2|
	|3|
Meta: SearchProduct

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: search any product and proceed to checkout page
Given Homepage I verify Homepage is opened
When Homepage I search dress in searchbox
And Homepage I click on button search
Then Searchpage I return number of items displayed on search page
And Searchpage I return price of 1 item
When Searchpage I hover on 1 item
And Searchpage I click on button AddToCart on 1 item
And Searchpage I Click on button ProceedToCheckout
Then Summarypage verify price on summarypage
And Summarypage I click on button delete
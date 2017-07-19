Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: scenario description
Given Order Number is <OrderID>
When I enter the <subHeading> and <emailAddress>
And I enter a <message>
And I click Send button
Then verify the <result> from page.

Examples:
|OrderID|subHeading|emailAddress|message|result|
|403-40732124t7824t62784|Customer service|test@test.com|Test message1|Your message has been successfully sent to our team|
|403-40732124t7824t62785|Customer service|test1@test.com|Test message2|Your message has been successfully sent to our team|
|403-40732124t7824t62786|Webmaster|test2@test.com|Test message3|Your message has been successfully sent to our team|
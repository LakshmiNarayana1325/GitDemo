Feature: Login Page validation

Scenario Outline: Validate for valid and nonvalid ids
Given Initialize browser with chrome
And Load the page with "http://www.qaclickacademy.com/"
And click on login link
When enter the user enters <username> and <password>
Then verify user successfully loged in
And close all browsers
Examples:
|username 	|password 	|
|lakshminarayana1325@gmail.com|Lakshmi831!|
|abcmouse@gmail.com		|123456|

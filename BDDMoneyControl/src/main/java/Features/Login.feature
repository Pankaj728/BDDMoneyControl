Feature: Verify different functionalities on Moneycontrol site
Description: The purpose of this feature is to test the real time updated data on Moneycontrol site

Scenario: 1. User verifies first record on Moneycontrol site

Given User is already on "https://www.moneycontrol.com" on "Chrome" browser
When User clicks on drop down icon
When User Verifies Quick View section and takes snapshot
Then User Click on the first stock listed on the “Stocks in News” section and print the details
Then close the browser


Scenario Outline: 2. User saves data for S&P BSE SENSEX and NIFTY 50

Given User is already on "<Expected site>" on "Chrome" browser
Then User saves data for respective sites 
Then close the browser

Examples:
|Expected site|
|https://www.moneycontrol.com/sensex/bse/sensex-live|
|https://www.moneycontrol.com/indian-indices/nifty-50-9.html|


Scenario: 3. User saves data for S&P BSE SENSEX and NIFTY 50

Given User is already on "https://www.moneycontrol.com/sensex/bse/sensex-live" on "Chrome" browser
Then User saves data for respective sites for "30" Mins

$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Login.feature");
formatter.feature({
  "line": 1,
  "name": "Verify different functionalities on Moneycontrol site",
  "description": "Description: The purpose of this feature is to test the real time updated data on Moneycontrol site",
  "id": "verify-different-functionalities-on-moneycontrol-site",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "3. User saves data for S\u0026P BSE SENSEX and NIFTY 50",
  "description": "",
  "id": "verify-different-functionalities-on-moneycontrol-site;3.-user-saves-data-for-s\u0026p-bse-sensex-and-nifty-50",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "comments": [
    {
      "line": 7,
      "value": "#Given User is already on \"https://www.moneycontrol.com/sensex/bse/sensex-live\" on \"Chrome\" browser"
    },
    {
      "line": 8,
      "value": "#Given User is already on \"https://www.moneycontrol.com/sensex/bse/sensex-live\" page"
    }
  ],
  "line": 9,
  "name": "User saves data for respective sites for \"1\" Mins",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 42
    }
  ],
  "location": "LoginStepDefination.user_saves_data_for_respective_sites_for_Mins(int)"
});
formatter.result({
  "duration": 295546003,
  "status": "passed"
});
});
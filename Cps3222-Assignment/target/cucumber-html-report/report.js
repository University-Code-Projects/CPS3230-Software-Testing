$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Features/AffiliateLogin.feature");
formatter.feature({
  "line": 1,
  "name": "Affiliate Login",
  "description": "",
  "id": "affiliate-login",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 2,
  "name": "Successful Affiliate Login",
  "description": "",
  "id": "affiliate-login;successful-affiliate-login",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 3,
  "name": "I am an affiliate trying to log in",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "I login using valid credentials",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "I should be taken to my account admin page",
  "keyword": "Then "
});
formatter.match({
  "location": "PageTest.login()"
});
formatter.result({
  "duration": 4089469642,
  "status": "passed"
});
formatter.match({
  "location": "PageTest.validLogin()"
});
formatter.result({
  "duration": 1612754829,
  "status": "passed"
});
formatter.match({
  "location": "PageTest.takenAdminPage()"
});
formatter.result({
  "duration": 3094035516,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "Unsuccessful Affiliate Login",
  "description": "",
  "id": "affiliate-login;unsuccessful-affiliate-login",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "I am an affiliate trying to log in",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "I login using invalid credentials",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I should see an error message",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "I should remain on the login page",
  "keyword": "And "
});
formatter.match({
  "location": "PageTest.login()"
});
formatter.result({
  "duration": 3371319232,
  "status": "passed"
});
formatter.match({
  "location": "PageTest.invalidLogin()"
});
formatter.result({
  "duration": 2393409981,
  "status": "passed"
});
formatter.match({
  "location": "PageTest.errorMsg()"
});
formatter.result({
  "duration": 18397655,
  "status": "passed"
});
formatter.match({
  "location": "PageTest.samePage()"
});
formatter.result({
  "duration": 3200064148,
  "status": "passed"
});
});
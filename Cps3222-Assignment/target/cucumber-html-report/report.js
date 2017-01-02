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
  "duration": 4543351790,
  "status": "passed"
});
formatter.match({
  "location": "PageTest.validLogin()"
});
formatter.result({
  "duration": 163908851,
  "status": "passed"
});
formatter.match({
  "location": "PageTest.takenAdminPage()"
});
formatter.result({
  "duration": 1075696877,
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
  "duration": 3268549687,
  "status": "passed"
});
formatter.match({
  "location": "PageTest.invalidLogin()"
});
formatter.result({
  "duration": 182300642,
  "status": "passed"
});
formatter.match({
  "location": "PageTest.errorMsg()"
});
formatter.result({
  "duration": 23561755,
  "status": "passed"
});
formatter.match({
  "location": "PageTest.samePage()"
});
formatter.result({
  "duration": 3172126398,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Account Admin Page Contents",
  "description": "",
  "id": "affiliate-login;account-admin-page-contents",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 14,
  "name": "I am a logged in affiliate",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "I visit my account admin page",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "I should see my balance",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "I should see a button allowing me to withdraw my balance",
  "keyword": "And "
});
formatter.match({
  "location": "PageTest.loggedIn()"
});
formatter.result({
  "duration": 3309108837,
  "status": "passed"
});
formatter.match({
  "location": "PageTest.adminAccoutAccess()"
});
formatter.result({
  "duration": 49486,
  "status": "passed"
});
formatter.match({
  "location": "PageTest.seeBalance()"
});
formatter.result({
  "duration": 37740303,
  "status": "passed"
});
formatter.match({
  "location": "PageTest.withdrawButton()"
});
formatter.result({
  "duration": 3162914373,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "Withdrawals",
  "description": "",
  "id": "affiliate-login;withdrawals",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 20,
  "name": "I am a logged in affiliate",
  "keyword": "Given "
});
formatter.step({
  "line": 21,
  "name": "my balance is \u003cbalance\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "I try to withdraw my balance",
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "I should see a message indicating \u003cmessage-type\u003e",
  "keyword": "Then "
});
formatter.step({
  "line": 24,
  "name": "my new balance will be \u003cnew-balance\u003e",
  "keyword": "And "
});
formatter.match({
  "location": "PageTest.loggedIn()"
});
formatter.result({
  "duration": 3213829582,
  "status": "passed"
});
formatter.match({
  "location": "PageTest.checkBalance()"
});
formatter.result({
  "duration": 50468005,
  "status": "passed"
});
formatter.match({
  "location": "PageTest.withdrawBalance()"
});
formatter.result({
  "duration": 91865113,
  "status": "passed"
});
formatter.match({
  "location": "PageTest.seeMessage()"
});
formatter.result({
  "duration": 38609418,
  "status": "passed"
});
formatter.match({
  "location": "PageTest.newBalance()"
});
formatter.result({
  "duration": 3162506026,
  "status": "passed"
});
});
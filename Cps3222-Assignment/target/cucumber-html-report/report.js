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
  "duration": 4873286743,
  "status": "passed"
});
formatter.match({
  "location": "PageTest.validLogin()"
});
formatter.result({
  "duration": 460292918,
  "status": "passed"
});
formatter.match({
  "location": "PageTest.takenAdminPage()"
});
formatter.result({
  "duration": 3200896973,
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
  "duration": 3173783983,
  "status": "passed"
});
formatter.match({
  "location": "PageTest.invalidLogin()"
});
formatter.result({
  "duration": 399557929,
  "status": "passed"
});
formatter.match({
  "location": "PageTest.errorMsg()"
});
formatter.result({
  "duration": 34833847,
  "status": "passed"
});
formatter.match({
  "location": "PageTest.samePage()"
});
formatter.result({
  "duration": 2982358192,
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
  "duration": 3076993400,
  "status": "passed"
});
formatter.match({
  "location": "PageTest.adminAccoutAccess()"
});
formatter.result({
  "duration": 43987,
  "status": "passed"
});
formatter.match({
  "location": "PageTest.seeBalance()"
});
formatter.result({
  "duration": 585503278,
  "status": "passed"
});
formatter.match({
  "location": "PageTest.withdrawButton()"
});
formatter.result({
  "duration": 3249775207,
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
  "duration": 3168068942,
  "status": "passed"
});
formatter.match({
  "location": "PageTest.checkBalance()"
});
formatter.result({
  "duration": 550294806,
  "error_message": "java.lang.AssertionError: expected:\u003c0.0\u003e but was:\u003c9.0\u003e\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.failNotEquals(Assert.java:834)\r\n\tat org.junit.Assert.assertEquals(Assert.java:553)\r\n\tat org.junit.Assert.assertEquals(Assert.java:683)\r\n\tat PageTest.checkBalance(PageTest.java:127)\r\n\tat ✽.And my balance is \u003cbalance\u003e(Features/AffiliateLogin.feature:21)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "PageTest.withdrawBalance()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "PageTest.seeMessage()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "PageTest.newBalance()"
});
formatter.result({
  "status": "skipped"
});
});
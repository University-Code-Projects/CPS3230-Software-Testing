# CPS3230-Software-Testing
Repository for CPS3230 Fundamentals of Software Testing Assignment<br>
Deadline: Monday 9th January 2017 till 12pm<br>
Submission:
 + Soft-copy: Each individual member must submit the report and any related files (code) through VLE <br>
 + Hard-copy: A hard copy is to be submitted to Vanessa Marie Borg, the department secretary of Computer Science <br>

```diff
+ Specifications Implemented
```
#Rules & Specifications for the system<br>
+ 1. Affiliates can register with the system<br>
    + a. These are assigned a unique ID (primary key)<br>
    + b. The Affiliate Type is set to bronze with balance 0 upon registration<br>
+ 2. Affiliates type if changed under the following conditions<br>
    + a. Balance is >= 50  ---> Affiliates type = Silver<br>
    + b. Banalce is >= 500 ---> Affiliates type = Gold<br>
+ 3. If Affiliates request to settle their balance<br>
    + a. Check if Balance is >= 5<br>
      + i. Ask for payment provider<br>
      + ii. If Affiliate is Bronze, Commission = 10%<br>
      + iii. If Affiliate is Silver, Commission = 7.5%<br>
      + iv. If Affiliate is Gold, Commission = 5%<br>
      + v. Pay Affiliate Total of = Balance - Commission<br>
    + b. If False, Insufficient Funds<br>
+ 4. Affiliates request adverts from platform<br>
    + a. By creating AdDescription objects to specify type of advertising needed<br>
    + b. Platform checks the list of AdPlatforms to check any matching adverts <br>
    + c. Choose one at random and pass on to the Affiliate in the form of an Advert object<br>
+ 5. Platform is responsible for checking advert is returned by provider and it is in line with the ad format requested<br>
    + a. (Continuation with point 4)<br>
    + b. If not, return another advert from a different provider<br>
    + c. If no advert exists with the specifications,  return null object to show ad could not be served<br>
+ 6. When user click displayed ads<br>
    + a. AdProviders notify platform using adClicked() method and provide affiliate ID<br>
    + b. Platform update affiliate's balance (+0.50)<br>

#Task 1: Unit Testing and Test Driven Development<br>
Weight: 28%<br>
Progress: In Progress<br>
+ 1. Required to build and UNIT-TEST the system outline in the specifications using TEST DRIVE approach <br>
+ 2. Ensure maximum TEST COVERAGE<br>
+ 3. Document statement coverage analysis, any test patterns used, use of test doubles<br>
+ 4. Aspect of interest when it comes to coding for testability<br>

At this stage, not required to produce any implementations of the following interfaces<br>
+ i. PaymentProvider<br>
+ ii. AdProvider<br>

Modification can be made to the design presented as it is only a first draft by the architect and may need adjustments in order
to function and be fully testable.
Make sure to document any assumptions made

#Task 2: Cucumber and Automated Web Testing<br>
Weight: 28%<br>
Progress: N/A<br>
+ 1. Develop a web application that uses the classes, these must supports two pages:<br>
    + i. A login page for affiliates<br>
    + ii. An account page for affiliates<br>
+ 2. Web application should behave according to the scenarios below. Document any test doubles you needed to implement as well as any issues relating to test data that we came across. (See PDF for full Scenarios)<br>
    + i. Successful Affiliate Login<br>
    + ii. Unsuccessful Affiliate Login<br>
    + iii. Account Admin Page Contents<br>
    + iv. Withdrawals<br>
    
#Task 3: Model Based Testing <br>
Weight: 24%<br>
Progress: N/A <br>
+ 1. Modify your web application to support simple ad delivery from one AdProvider implementation. <br>
+ 2. Your stakeholders are now interested in generating test cases based on the following rules:<br>
    + i. An affiliate initially has a balance of €0.00 and an affiliate-type of Bronze<br>
    + ii. Every time an affiliate requests an ad and a user clicks on it, the affiliate’s balance will be increased by €0.50<br>
    + iii. When an affiliate generates his first €50 then he is promoted to an affiliatetype of Silver. <br>
        + a. Note that even though an  affiliate’s balance might drop due to withdrawals,<br>
        + b. A running total of the amount of commission earned by an affiliate should be tracked.<br>
    + iv. When an affiliate generates his first €500 then he is promoted to an affiliate type of Gold.<br>
        + a. Note that even though balance might drop due to withdrawals, <br>
        + b. A running total of the amount of commission earned by an affiliate should be tracked.<br>
+ 3. Create a model which describes how this aspect of the web application should function. <br>
    + i. Use this model to automate the generation and execution of test cases for this aspect of the system. <br>
+ 4. Document the following:<br>
    + i. Your model in a graphical notation<br>
    + ii. A graph depicting how much state coverage was achieved against the number of test cases executed.<br>
    + iii. Explain what step(s) you would take to reduce the amount of test cases required to achieve 100% state coverage.<br>
    
#Task 4: Performance Testing<br>
Weight: 20%<br>
Progress: N/A <br>
It is expected serving and clicking of adverts will generate heavy usage loads on the system. Stakeholders are concerned about the extent to which the serveAdvert() and adClicked() methods can deal with large usage loads.<br>
+ 1. Using a performance testing tool of your choice or a custom-built test harness<br>
+ 2. Provide an indication of the number of affiliates that your system can handle. <br>
    + i. Each affiliate is expected to request between an everage of 2.5 adverts per second with end users expected to click on 10% of delivered adverts.<br>

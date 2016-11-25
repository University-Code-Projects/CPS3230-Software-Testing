# CPS3230-Software-Testing
Repository for CPS3230 Fundamentals of Software Testing Assignment
<br><br>
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
Progress: N/A<br>
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

# CPS3230-Software-Testing
Repository for CPS3230 Fundamentals of Software Testing Assignment
<br><br>
#Rules & Specifications for the system<br>
+ 1. Affiliates can register with the system
    + a. These are assigned a unique ID (primary key)<br>
    + b. The Affiliate Type is set to bronze with balance 0 upon registration
+ 2. Affiliates type if changed under the following conditions
    + a. Balance is >= 50  ---> Affiliates type = Silver
    + b. Banalce is >= 500 ---> Affiliates type = Gold
+ 3. If Affiliates request to settle their balance
    + a. Check if Balance is >= 5
      + i. Ask for payment provider
      + ii. If Affiliate is Bronze, Commission = 10%
      + iii. If Affiliate is Silver, Commission = 7.5%
      + iv. If Affiliate is Gold, Commission = 5%
      + v. Pay Affiliate Total of = Balance - Commission
    + b. If False, Insufficient Funds
+ 4. Affiliates request adverts from platform
    + a. By creating AdDescription objects to specify type of advertising needed
    + b. Platform checks the list of AdPlatforms to check any matching adverts 
    + c. Choose one at random and pass on to the Affiliate in the form of an Advert object
+ 5. Platform is responsible for checking advert is returned by provider and it is in line with the ad format requested
    + a. (Continuation with point 4)
    + b. If not, return another advert from a different provider
    + c. If no advert exists with the specifications,  return null object to show ad could not be served
+ 6. When user click displayed ads
    + a. AdProviders notify platform using adClicked() method and provide affiliate ID
    + b. Platform update affiliate's balance (+0.50)

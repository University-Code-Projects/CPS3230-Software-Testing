/**
 * Testing the page created
 * from the features class
 */
import cps.uom.edu.AdPlatform;
import cps.uom.edu.Affiliate;
import cucumber.api.java.en.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

//repeated givens, when, thens... have been removed and using the same one for different scenarios
public class PageTest {
    WebDriver driver;
    AdPlatform plat = null;
    Affiliate aff =  new Affiliate(1,"pass1","Client1");
    Affiliate aff2 =  new Affiliate(2,"pass2","Client2");

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds*1000);
        } catch (Exception e) {}
    }

    public PageTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Given("^I am an affiliate trying to log in$")
    public void login()throws Throwable{
        plat = new AdPlatform();//creating a new platform
        plat.registerAffiliate(aff);//registering a new affiliate
    }

    @When("^I login using valid credentials$")
    public void validLogin() throws Throwable{
        driver.get("http://localhost:9515/index.jsp");//setting the URL
        driver.findElement(By.name("id")).sendKeys("1");//setting the id to be entered
        driver.findElement(By.name("pass")).sendKeys("pass1");//setting the password to be entered
        //sleep(1);
        driver.findElement(By.name("submit")).click();//clicking the submit button
        assertEquals(true,(1 == aff.getId())&&(aff.getPassword().equals("pass1")));
    }

    @Then("^I should be taken to my account admin page$")
    public void takenAdminPage() throws Throwable{
        //sleep(1);
        assertEquals("http://localhost:9515/display.jsp", driver.getCurrentUrl());
        driver.close();//closing the page
        driver.quit();
    }

    @When("^I login using invalid credentials$")
    public void invalidLogin() throws Throwable{
        driver.get("http://localhost:9515/index.jsp");
        driver.findElement(By.name("id")).sendKeys("1");
        driver.findElement(By.name("pass")).sendKeys("pass2");//giving an incorrect password
        //sleep(1);
        driver.findElement(By.name("submit")).click();
        assertEquals(false,(1 == aff.getId())&&(aff.getPassword().equals("pass2")));
    }

    @Then("^I should see an error message$")
    public void errorMsg() throws Throwable{
        boolean flag = false;
        try{
            driver.switchTo().alert().accept();//check if an error message has appeared
            flag=true;
        }catch (NoAlertPresentException Ex){
            flag = false;
        }
        assertEquals(true, flag);
    }

    @And("^I should remain on the login page$")
    public void samePage() throws Throwable{
        //sleep(1);
        assertEquals("http://localhost:9515/error.jsp", driver.getCurrentUrl());
        driver.close();
        driver.quit();
    }

    @Given("^I am a logged in affiliate$")
    public void loggedIn()throws Throwable{
        plat = new AdPlatform();
        plat.registerAffiliate(aff2);
        driver.get("http://localhost:9515/index.jsp");
        driver.findElement(By.name("id")).sendKeys("2");
        driver.findElement(By.name("pass")).sendKeys("pass2");
        driver.findElement(By.name("submit")).click();
    }

    @When("^I visit my account admin page$")
    public void adminAccoutAccess() throws Throwable{
        assertEquals(true,((Integer.parseInt(driver.findElement(By.className("id")).getText())) == aff2.getId()));//checking i have visited the correct web page
    }

    @Then("^I should see my balance$")
    public void seeBalance() throws Throwable{
        //sleep(1);
        for (int i = 0; i<9; i++){//clicking the ad button
            plat.adClicked(2);
            driver.findElement(By.name("Ad")).click();
        }
        assertEquals(aff2.getBalance(),(Double.parseDouble(driver.findElement(By.className("balance")).getText())),0.01);//checking that the balance is matching
    }

    @And("^I should see a button allowing me to withdraw my balance$")
    public void withdrawButton() throws Throwable{
        //sleep(1);
        assertEquals(true, driver.findElements(By.name("Withdraw")).size()>0);//checking there is a withdraw button
        driver.close();
        driver.quit();
    }

    @And("^my balance is <balance>$")
    public void checkBalance() throws Throwable {
        for (int i = 0; i<9; i++){
           plat.adClicked(2);//incrementing the balance of affiliate
        }
        assertEquals(aff2.getBalance(),(Double.parseDouble(driver.findElement(By.className("balance")).getText())),0.01);//checking balance matches that of the affiliate
    }

    @When("^I try to withdraw my balance$")
    public void withdrawBalance() throws Throwable{
        driver.findElement(By.name("Withdraw")).click();//clicking the withdraw button
        assertEquals("http://localhost:9515/withdraw.jsp",driver.getCurrentUrl());
    }

    @Then("^I should see a message indicating <message-type>$")
    public void seeMessage() throws Throwable{
        assertEquals("|Error", driver.findElement(By.className("msg")).getText());//checking i got the error message if i had less than 5.00 credit
        //assertEquals(aff2.getBalance(),(Double.parseDouble(driver.findElement(By.className("balance")).getText())),0.01);
    }

    @And("^my new balance will be <new-balance>$")
    public void newBalance() throws Throwable{
        String result = "|"+String.valueOf(aff2.getBalance());
        assertEquals(result,driver.findElement(By.className("newBalance")).getText());//checking the new balance
        driver.close();
        driver.quit();
    }
}

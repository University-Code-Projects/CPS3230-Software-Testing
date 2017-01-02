/**
 * Created by jonathan on 29/12/2016.
 */
import cps.uom.edu.AdPlatform;
import cps.uom.edu.Affiliate;
import cucumber.api.java.en.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

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
        plat = new AdPlatform();
        //aff = new Affiliate(1,"pass1","Client1");
        plat.registerAffiliate(aff);
        driver.get("http://localhost:9515/index.jsp");
        driver.findElement(By.name("id")).sendKeys("1");
        driver.findElement(By.name("pass")).sendKeys("pass1");
        driver.findElement(By.name("submit")).click();
    }

    @When("^I login using valid credentials$")
    public void validLogin() throws Throwable{
        driver.get("http://localhost:9515/index.jsp");
        driver.findElement(By.name("id")).sendKeys("1");
        driver.findElement(By.name("pass")).sendKeys("pass1");
        //sleep(1);
        driver.findElement(By.name("submit")).click();
        assertEquals(true,(1 == aff.getId())&&(aff.getPassword().equals("pass1")));
    }

    @Then("^I should be taken to my account admin page$")
    public void takenAdminPage() throws Throwable{
        //sleep(1);
        assertEquals("http://localhost:9515/display.jsp", driver.getCurrentUrl());        //assertEquals(aff.getId(),driver.findElement(By.name("id")));
        driver.close();
        driver.quit();
    }

    @When("^I login using invalid credentials$")
    public void invalidLogin() throws Throwable{
        driver.get("http://localhost:9515/index.jsp");
        driver.findElement(By.name("id")).sendKeys("1");
        driver.findElement(By.name("pass")).sendKeys("pass2");
        //sleep(1);
        driver.findElement(By.name("submit")).click();
        assertEquals(false,(1 == aff.getId())&&(aff.getPassword().equals("pass2")));
    }

    @Then("^I should see an error message$")
    public void errorMsg() throws Throwable{
        boolean flag = false;
        try{
            driver.switchTo().alert().accept();
            flag=true;
        }catch (NoAlertPresentException Ex){
            flag = false;
        }
        assertEquals(true, flag);
    }

    @And("^I should remain on the login page$")
    public void samePage() throws Throwable{
        //sleep(1);
        assertEquals("http://localhost:9515/error.jsp", driver.getCurrentUrl());        //assertEquals(aff.getId(),driver.findElement(By.name("id")));
        driver.close();
        driver.quit();
    }

    @Given("^I am a logged in affiliate$")
    public void loggedIn()throws Throwable{
        plat = new AdPlatform();
        //aff2 = new Affiliate(2,"pass2","Client2");
        plat.registerAffiliate(aff2);
        driver.get("http://localhost:9515/index.jsp");
        driver.findElement(By.name("id")).sendKeys("2");
        driver.findElement(By.name("pass")).sendKeys("pass2");
        driver.findElement(By.name("submit")).click();
    }

    @When("^I visit my account admin page$")
    public void adminAccoutAccess() throws Throwable{
        assertEquals(true,(2 == aff2.getId())&&(aff2.getPassword().equals("pass2")));
    }

    @Then("^I should see my balance$")
    public void seeBalance() throws Throwable{
        //sleep(1);
        for (int i = 0; i<9; i++){
            plat.adClicked(2);              //to equal balance in website
            driver.findElement(By.name("Ad")).click();
        }
        assertEquals(aff2.getBalance(),(Double.parseDouble(driver.findElement(By.className("balance")).getText())),0.01);
    }

    @And("^I should see a button allowing me to withdraw my balance$")
    public void withdrawButton() throws Throwable{
        //sleep(1);
        assertEquals(true, driver.findElements(By.name("Withdraw")).size()>0);
        driver.close();
        driver.quit();
    }

    @And("^my balance is <balance>$")
    public void checkBalance() throws Throwable {
        for (int i = 0; i<9; i++){
           plat.adClicked(2);              //to equal balance in website
        }
        assertEquals(aff2.getBalance(),(Double.parseDouble(driver.findElement(By.className("balance")).getText())),0.01);
    }

    @When("^I try to withdraw my balance$")
    public void withdrawBalance() throws Throwable{
        driver.findElement(By.name("Withdraw")).click();
        assertEquals("http://localhost:9515/withdraw.jsp",driver.getCurrentUrl());
    }

    @Then("^I should see a message indicating <message-type>$")
    public void seeMessage() throws Throwable{
        assertEquals("|Error", driver.findElement(By.className("msg")).getText());
        //assertEquals(aff2.getBalance(),(Double.parseDouble(driver.findElement(By.className("balance")).getText())),0.01);
    }

    @And("^my new balance will be <new-balance>$")
    public void newBalance() throws Throwable{
        String result = "|"+String.valueOf(aff2.getBalance());
        assertEquals(result,driver.findElement(By.className("newBalance")).getText());
        driver.close();
        driver.quit();
    }
}

/**
 * Created by jonathan on 29/12/2016.
 */
import cps.uom.edu.AdPlatform;
import cps.uom.edu.Affiliate;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageTest {
    WebDriver driver;
    AdPlatform plat = null;
    Affiliate aff = null;

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
        aff = new Affiliate(1,"pass1","Client1");
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




}

/**
 * Class used to run the CucumberTests
 */

import cps.uom.edu.AdPlatform;
import cps.uom.edu.Affiliate;
import cucumber.api.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, format = {"html:target/cucumber-html-report"})

public class RunCucumberTests {

    public class runTest{

    }
}

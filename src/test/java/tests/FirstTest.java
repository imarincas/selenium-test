package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.HomePage;
import utils.Utils;

import java.util.concurrent.TimeUnit;

public class FirstTest {

    WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.firefoxdriver().setup();
    }

    @Before
    public void setupTest() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.navigate().to(Utils.getUrl());
    }

    @Test
    public void test() {
        HomePage homePage = new HomePage(driver);
        homePage.selectBundlesTab()
                .selectCar()
                .setFlyFromText("SFO")
                .setFlyToText("LAX")
                .setStartDate()
                .setEndDate()
                .selectEvening()
                .selectMorning()
                .submitSearch()
                .verifyMinOneResult();
    }

      @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

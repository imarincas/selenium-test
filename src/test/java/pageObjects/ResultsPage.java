package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultsPage {
    final WebDriver driver;

    @FindBy(id = "resultsContainer")
    private WebElement resultsContainer;

    public void verifyMinOneResult() {
        Assert.assertTrue(resultsContainer.findElements(By.xpath("//article")).size() >= 1);
    }

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}

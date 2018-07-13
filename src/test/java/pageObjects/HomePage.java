package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HomePage {

    final WebDriver driver;

    @FindBy(xpath = "//div[@data-bdd='bundles-tab']")
    private WebElement bundelsTab;

    @FindBy(xpath = "//hw-check-button[@content='Car']")
    private WebElement carSelector;

    @FindBy(id = "origin")
    private WebElement flyFromTextbox;

    @FindBy(id = "destination")
    private WebElement flyToTextbox;

    @FindBy(xpath = "//ul[@class=dropdown-menu]")
    private WebElement textboxPopup;

    @FindBy(id = "startDate")
    private WebElement startDate;

    @FindBy(id = "startHour")
    private WebElement startHour;

    @FindBy(id = "endDate")
    private WebElement endDate;

    @FindBy(id = "endHour")
    private WebElement endHour;

    @FindBy(xpath = "//div[@ng-controller='packageSearchBoxController']//div[contains(@class,'search-button')]/button")
    private WebElement submitButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public HomePage selectBundlesTab() {
        bundelsTab.click();
        return this;
    }

    public HomePage selectCar(){
        carSelector.click();
        return this;
    }

    public HomePage setFlyFromText(String text) {
        flyFromTextbox.sendKeys(text);
        return this;
    }

    public HomePage setFlyToText(String text) {
        flyToTextbox.sendKeys(text);
        //need to close the popup
        flyToTextbox.sendKeys(Keys.ESCAPE);
        return this;
    }

    public HomePage setStartDate() {
        startDate.clear();
        startDate.sendKeys(addDaysToTodayDate(1));
        return this;
    }

    public HomePage setEndDate() {
        endDate.clear();
        endDate.sendKeys(addDaysToTodayDate( 20));
        return this;
    }

    public HomePage selectEvening() {
        selectFromDropdown(startHour, "Evening");
        return this;
    }

    public HomePage selectMorning() {
        selectFromDropdown(endHour, "Morning");
        return this;
    }

    public ResultsPage submitSearch() {
        submitButton.click();
        return new ResultsPage(driver);
    }


    private String addDaysToTodayDate(int daysNumber) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate today=LocalDate.now();
        return formatter.format(today.plusDays(daysNumber));
    }

    private void selectFromDropdown(WebElement select, String option) {
        Select dropdown = new Select(select);
        dropdown.selectByVisibleText(option);
    }
}

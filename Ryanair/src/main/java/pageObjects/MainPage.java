package pageObjects;

import helpers.DriverInstance;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    //selectors are css because they are faster than xpath

    @FindBy(css = "span[class=\"username\"][translate=\"MYRYANAIR.LAYOUT.HEADER.MYRYANAIR_LOGIN\"]")
    private WebElement logIn_LNK;

    @FindBy(css = "input[name=\"emailAddress\"]")
    private WebElement email_TXTbox;

    @FindBy(css = "input[class=\"core-input ng-pristine ng-empty ng-invalid ng-invalid-required ng-touched\"]")
    private WebElement userPassword_TXTbox;

    @FindBy(css = "button[class=\"core-btn-primary\"]")
    private WebElement logIn_BTN;

    @FindBy(css = "label[for=\"flight-search-type-option-one-way\"]")
    private WebElement oneWay_Rbtn;

    @FindBy(css = "input[aria-labelledby=\"label-airport-selector-from\"]")
    private WebElement from_TXTbox;

    @FindBy(css = "input[aria-labelledby=\"label-airport-selector-to\"]")
    private WebElement to_TXTbox;

    @FindBy(css = "span[ng-bind-html=\"option.name | highlight: $ctrl.highlighter.text\"]")
    private WebElement selectCity_LBL;

    @FindBy(css = "input[aria-label=\"Fly out: - DD\"]")
    private WebElement DDFrom_TXTbox;

    @FindBy(css = "input[aria-label=\"Fly out: - MM\"]")
    private WebElement MMFrom_TXTbox;

    @FindBy(css = "input[aria-label=\"Fly out: - YYYY\"]")
    private WebElement YYYYFrom_TXTbox;

    @FindBy(css = "div[aria-label=\"1 Passenger\"]")
    private WebElement passengers_DROPD;

    @FindBy(css = "div[label=\"Adults\"] button[ng-click=\"$ctrl.increment()\"]")
    private WebElement adultsIncrement;

    @FindBy(css = "button[class=\"core-btn-primary core-btn-block core-btn-big\"]")
    private WebElement letsGo_BTN;

    public MainPage() {
        PageFactory.initElements(DriverInstance.getInstance(), this);
    }

    WebDriverWait explicitWait = new WebDriverWait(helpers.DriverInstance.getInstance(), 10);

    public MainPage LoginToSystem(String email, String password){

        explicitWait.until(ExpectedConditions.elementToBeClickable(logIn_LNK));
        logIn_LNK.click();
        email_TXTbox.sendKeys(email);
        email_TXTbox.sendKeys(Keys.TAB);
        email_TXTbox.click();
        userPassword_TXTbox.sendKeys(password);
        logIn_BTN.click();

        return new MainPage();
    }

    public MainPage incrementAdultPassengers() {
        passengers_DROPD.click();
        adultsIncrement.click();
        return new MainPage();
    }

    public MainPage selectDates(String DDfromDate, String MMfromDate, String YYYYfromDate) {
        explicitWait.until(ExpectedConditions.elementToBeClickable(DDFrom_TXTbox));
        DDFrom_TXTbox.sendKeys(DDfromDate);
        MMFrom_TXTbox.clear();
        MMFrom_TXTbox.sendKeys(MMfromDate);
        YYYYFrom_TXTbox.clear();
        YYYYFrom_TXTbox.sendKeys(YYYYfromDate);
        return new MainPage();
    }

    public MainPage selectOneWay() {
        explicitWait.until(ExpectedConditions.visibilityOf(oneWay_Rbtn));
        explicitWait.until(ExpectedConditions.elementToBeClickable(oneWay_Rbtn));
        oneWay_Rbtn.click();
        return new MainPage();
    }

    public MainPage selectCities(String from, String to) {
        from_TXTbox.clear();
        from_TXTbox.sendKeys(from);
        selectCity_LBL.click();
        to_TXTbox.sendKeys(to);
        selectCity_LBL.click();
        return new MainPage();
    }

    public TripDetails clickLetsGo() {
        letsGo_BTN.click();
        return new TripDetails();
    }
}

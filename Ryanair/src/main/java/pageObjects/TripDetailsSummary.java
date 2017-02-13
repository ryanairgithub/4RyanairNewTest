package pageObjects;

import helpers.DriverInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TripDetailsSummary {

    @FindBy(css = "button[class=\"core-btn-primary core-btn-block core-btn-medium\"]")
    private WebElement continue_BTN;

    public TripDetailsSummary() {
        PageFactory.initElements(DriverInstance.getInstance(), this);
    }

    public TripDetailsSeatReservation clickContinue(){
        WebDriverWait explicitWait = new WebDriverWait(helpers.DriverInstance.getInstance(), 10);
        explicitWait.until(ExpectedConditions.elementToBeClickable(continue_BTN));
        continue_BTN.click();
        return new TripDetailsSeatReservation();
    }

}

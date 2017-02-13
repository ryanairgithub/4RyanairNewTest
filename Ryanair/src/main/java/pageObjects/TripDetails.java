package pageObjects;

import helpers.DriverInstance;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TripDetails {

    @FindBy(css = ".flights-table-price__header")
    private WebElement selectFlight;

    @FindBy(css = "div[class=\"flight-fare standard\"] button")
    private WebElement selectRegularFare_BTN;

    public TripDetails() {
        PageFactory.initElements(DriverInstance.getInstance(), this);
    }

    public TripDetails selectFirstFlight() {
        selectFlight.click();
        return new TripDetails();
    }

    public TripDetailsSummary selectRegularFare() {
        selectRegularFare_BTN.click();
        return new TripDetailsSummary();
    }

}

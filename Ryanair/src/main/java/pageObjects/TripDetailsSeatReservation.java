package pageObjects;

import helpers.DriverInstance;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TripDetailsSeatReservation {

    @FindBy(css = "button[class=\"core-btn-primary core-btn-block core-btn-medium btn-text\"]")
    private WebElement checkout_BTN;

    @FindBy(css = "button[translate=\"trips.summary.seat.prompt.popup.reject\"]")
    private WebElement closeDialog_BTN;

    public TripDetailsSeatReservation() {
        PageFactory.initElements(DriverInstance.getInstance(), this);
    }

    public TripDetailsSeatReservation clickCheckout() {
        checkout_BTN.click();
        return new TripDetailsSeatReservation();
    }

    public Payment closeDialog() {
        closeDialog_BTN.click();
        return new Payment();
    }

}

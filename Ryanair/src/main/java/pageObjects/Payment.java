package pageObjects;

import helpers.DriverInstance;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static junit.framework.TestCase.assertTrue;

public class Payment {

    @FindBy(css = "input[name=\"cardNumber\"]")
    private WebElement cardNumber_TXTbox;

    @FindBy(css = "button[translate=\"common.components.payment_forms.pay_now\"]")
    private WebElement payNow_BTN;

    @FindBy(css = "span[translate=\"common.components.payment_forms.error_card_number_minlength\"]")
    private WebElement cardError_LBL;

    public Payment() {
        PageFactory.initElements(DriverInstance.getInstance(), this);
    }

    public Payment enterCardNumber(String cardNumber) {
        cardNumber_TXTbox.sendKeys(cardNumber);
        return new Payment();
    }

    public Payment clickPayNow() {
        payNow_BTN.click();
        return new Payment();
    }

    public Payment isCardErrorDisplayed() {
        assertTrue(cardError_LBL.isDisplayed());
        return new Payment();
    }

}

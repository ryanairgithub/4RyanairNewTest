package tests;


import helpers.DriverInstance;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObjects.MainPage;
import pageObjects.TripDetails;
import pageObjects.TripDetailsSeatReservation;
import pageObjects.TripDetailsSummary;

import java.util.concurrent.TimeUnit;

public class LogIn {

    //test data - in real it will be taken from test data generator, file or database
    private static final String EMAIL = "4ryanair_register_ticket@mailinator.com";
    private static final String PASSWORD = "4ryanair_register_ticketA";
    private static final String CITY_FROM = "Dublin";
    private static final String CITY_TO = "Wroclaw";
    private static final String DD_DATE_FROM = "07";
    private static final String MM_DATE_FROM = "04";
    private static final String YYYY_DATE_FROM = "2017";
    private static final String CARD_NUMBER = "2345467345";

    private MainPage loginPage;
    private DriverInstance driverInstance;
    private TripDetails tripDetails;
    private TripDetailsSummary tripDetailsSummary;
    private TripDetailsSeatReservation tripDetailsSeatReservation;

    @Before
    public void doBefore() {
        DriverInstance.initialiseDriver();
        DriverInstance.getInstance().manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        loginPage = new MainPage();
        loginPage.LoginToSystem(EMAIL, PASSWORD);
    }

    @After
    public void doAfter() {
        driverInstance.closeBrowserAndDriver();
    }

    @Test
    public void buyTicket() {

        //given
        DriverInstance.getInstance().manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS); //implicit wait
        loginPage

                //when
                .selectOneWay()
                .selectCities(CITY_FROM, CITY_TO)
                .selectDates(DD_DATE_FROM, MM_DATE_FROM, YYYY_DATE_FROM)
                .incrementAdultPassengers()
                .clickLetsGo()
                .selectFirstFlight()
                .selectRegularFare()
                .clickContinue()
                .clickCheckout()
                .closeDialog()
                .enterCardNumber(CARD_NUMBER)
                .clickPayNow()

        //then
        .isCardErrorDisplayed(); //assert


    }


}

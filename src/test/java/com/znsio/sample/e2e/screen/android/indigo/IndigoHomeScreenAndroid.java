package com.znsio.sample.e2e.screen.android.indigo;

import com.znsio.e2e.tools.Driver;
import com.znsio.e2e.tools.Visual;
import com.znsio.sample.e2e.screen.indigo.IndigoFlightSearchResultsScreen;
import com.znsio.sample.e2e.screen.indigo.IndigoGiftVouchersScreen;
import com.znsio.sample.e2e.screen.indigo.IndigoHomeScreen;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class IndigoHomeScreenAndroid
        extends IndigoHomeScreen {
    private final Driver driver;
    private final Visual visually;
    private static final String SCREEN_NAME = IndigoHomeScreenAndroid.class.getSimpleName();
    private static final Logger LOGGER = Logger.getLogger(SCREEN_NAME);
    private static final String NOT_YET_IMPLEMENTED = " not yet implemented";
    private static final By byContinueAsGuestId = By.id("in.goindigo.android:id/button_as_guest");
    private static final By byGiftVoucherXpath = By.xpath("//android.widget.TextView[@text='Gift voucher']/..");

    public IndigoHomeScreenAndroid(Driver driver, Visual visually) {
        this.driver = driver;
        this.visually = visually;
        WebElement continueAsGuestElement = this.driver.waitForClickabilityOf(byContinueAsGuestId, 20);
        visually.checkWindow(SCREEN_NAME, "Launch screen");
        continueAsGuestElement.click();
    }

    @Override
    public IndigoHomeScreen selectFrom(String from) {
        throw new NotImplementedException(SCREEN_NAME + ":" + new Throwable().getStackTrace()[0].getMethodName() + NOT_YET_IMPLEMENTED);
    }

    @Override
    public IndigoHomeScreen selectTo(String destination) {
        throw new NotImplementedException(SCREEN_NAME + ":" + new Throwable().getStackTrace()[0].getMethodName() + NOT_YET_IMPLEMENTED);
    }

    @Override
    public IndigoHomeScreen selectNumberOfAdultPassengers(int numberOfAdults) {
        throw new NotImplementedException(SCREEN_NAME + ":" + new Throwable().getStackTrace()[0].getMethodName() + NOT_YET_IMPLEMENTED);
    }

    @Override
    public IndigoHomeScreen selectJourneyType(String journeyType) {
        throw new NotImplementedException(SCREEN_NAME + ":" + new Throwable().getStackTrace()[0].getMethodName() + NOT_YET_IMPLEMENTED);
    }

    @Override
    public IndigoFlightSearchResultsScreen searchFlightOptions() {
        throw new NotImplementedException(SCREEN_NAME + ":" + new Throwable().getStackTrace()[0].getMethodName() + NOT_YET_IMPLEMENTED);
    }

    @Override
    public IndigoGiftVouchersScreen selectGiftVouchers() {
        WebElement giftVoucherElement = driver.waitForClickabilityOf(byGiftVoucherXpath, 20);
        visually.checkWindow(SCREEN_NAME, "On Landing screen");
        giftVoucherElement.click();
        return IndigoGiftVouchersScreen.get();
    }
}

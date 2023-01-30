package com.znsio.sample.e2e.steps;

import com.context.SessionContext;
import com.context.TestExecutionContext;
import com.znsio.e2e.runner.Runner;
import com.znsio.e2e.tools.Drivers;
import com.znsio.sample.e2e.businessLayer.indigo.GiftVoucherBL;
import com.znsio.sample.e2e.businessLayer.indigo.IndigoBL;
import com.znsio.sample.e2e.entities.SAMPLE_TEST_CONTEXT;
import io.cucumber.java.en.Given;
import org.apache.log4j.Logger;

public class IndigoSteps {
    private static final Logger LOGGER = Logger.getLogger(IndigoSteps.class.getName());
    private final TestExecutionContext context;
    private final Drivers allDrivers;

    public IndigoSteps() {
        context = SessionContext.getTestExecutionContext(Thread.currentThread()
                                                               .getId());
        LOGGER.info("context: " + context.getTestName());
        allDrivers = (Drivers) context.getTestState(SAMPLE_TEST_CONTEXT.ALL_DRIVERS);
        LOGGER.info("allDrivers: " + (null == allDrivers));
    }

    @Given("I search for a {string} ticket from {string} to {string} for {string} adult passenger")
    public void iSearchForATicketFromToForPassenger(String journeyType, String from, String destination, String numberOfAdults) {
        LOGGER.info(System.out.printf("iSearchForATicketFromToForPassenger - Persona:'%s'", SAMPLE_TEST_CONTEXT.ME));
        allDrivers.createDriverFor(SAMPLE_TEST_CONTEXT.ME, Runner.platform, context);
        new IndigoBL(SAMPLE_TEST_CONTEXT.ME, Runner.platform).searchForTicket(journeyType, from, destination, numberOfAdults);
    }

    @Given("I want to purchase {string} gift voucher of INR {string}")
    public void iWantToPurchaseGiftVoucherOfINR(String numberOfGiftVouchersToPurchase, String denomination) {
        LOGGER.info(System.out.printf("iWantToPurchaseGiftVoucherOfINR - Persona:'%s'", SAMPLE_TEST_CONTEXT.ME));
        allDrivers.createDriverFor(SAMPLE_TEST_CONTEXT.ME, Runner.platform, context);
        new GiftVoucherBL(SAMPLE_TEST_CONTEXT.ME, Runner.platform).selectGiftVoucher(numberOfGiftVouchersToPurchase, denomination);
    }

    @Given("I want to personalize {string} gift voucher of INR {string} for {string} with message {string}")
    public void iWantToPersonalizeGiftVoucherOfINRForWithMessage(String numberOfGiftVouchersToPurchase, String denomination, String forWhom, String customMessage) {
        LOGGER.info(System.out.printf("iWantToPurchaseGiftVoucherOfINR - Persona:'%s'", SAMPLE_TEST_CONTEXT.ME));
        allDrivers.createDriverFor(SAMPLE_TEST_CONTEXT.ME, Runner.platform, context);
        new GiftVoucherBL(SAMPLE_TEST_CONTEXT.ME, Runner.platform).selectGiftVoucherAndPersonalise(numberOfGiftVouchersToPurchase, denomination, forWhom, customMessage);
    }
}

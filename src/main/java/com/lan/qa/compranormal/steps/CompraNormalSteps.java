package com.lan.qa.compranormal.steps;

import com.lan.qa.common.utils.PageFactory;
import com.lan.qa.home.pages.CountrySelector;
import com.lan.qa.home.pages.MainHome;
import junit.framework.Assert;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 * Created with IntelliJ IDEA.
 * User: marenaso
 * Date: 08-10-13
 * Time: 11:34 AM
 * To change this template use File | Settings | File Templates.
 */
public class CompraNormalSteps {

    private CountrySelector countrySelector;
    private MainHome mainHome;

    public CompraNormalSteps(PageFactory pageFactory) {
        countrySelector = pageFactory.newCountrySelector();
        mainHome = pageFactory.newMainhome();
    }

    @Given("a non-logged user")
    public void verifyUserIsLoggedOut() {
        countrySelector.go();
        countrySelector.selectCountry("cl");
        mainHome.selectPromo();
    }

    @When("I want to buy a ticket")
    public void buyATicket() {

    }

    @Then("system shows me a record locator")
    public void verifyRecordLocator() {
        Assert.assertTrue(true);
    }

}

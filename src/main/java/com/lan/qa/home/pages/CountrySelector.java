package com.lan.qa.home.pages;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

/**
 * Created with IntelliJ IDEA.
 * User: marenaso
 * Date: 08-10-13
 * Time: 11:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class CountrySelector extends FluentWebDriverPage {


    public CountrySelector(WebDriverProvider webDriverProvider) {
        super(webDriverProvider);

    }

    public void go() {
        get("http://www.lan.com");
    }

    public void selectCountry(String country) {
        link(By.className(country)).click();
    }

}

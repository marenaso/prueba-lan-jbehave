package com.lan.qa.common.utils;

import com.lan.qa.home.pages.CountrySelector;
import com.lan.qa.home.pages.MainHome;
import org.jbehave.web.selenium.WebDriverProvider;

/**
 * Created with IntelliJ IDEA.
 * User: marenaso
 * Date: 08-10-13
 * Time: 11:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class PageFactory {
    private final WebDriverProvider webDriverProvider;

    public PageFactory(WebDriverProvider webDriverProvider) {
        this.webDriverProvider = webDriverProvider;
    }

    public CountrySelector newCountrySelector() {
        return new CountrySelector(webDriverProvider);
    }

    public MainHome newMainhome() {
        return new MainHome(webDriverProvider);
    }

}

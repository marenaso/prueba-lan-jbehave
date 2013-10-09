package com.lan.qa.com.lan.qa.components;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

/**
 * Created with IntelliJ IDEA.
 * User: marenaso
 * Date: 08-10-13
 * Time: 03:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class Cashier extends FluentWebDriverPage {

    public Cashier(WebDriverProvider webDriverProvider) {
        super(webDriverProvider);
    }

    public void selectOrigin(){

    }

    public void selectDestination(){

    }

    private void selectCity(String id, String city) {
        select(By.id("id"));


    }

}

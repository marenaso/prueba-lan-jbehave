package com.lan.qa.home.pages;

import com.lan.qa.com.lan.qa.components.Cashier;
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
public class MainHome extends FluentWebDriverPage {

    private static final String PROMO_XPATH = "//*[@id=\"amax-menudynamic-639102\"]/div[2]/div[1]/ul/li[3]/a";
    private Cashier cashier;

    public MainHome(WebDriverProvider webDriverProvider) {
        super(webDriverProvider);
        this.cashier = new Cashier(webDriverProvider);
    }

    public void fillCashier(){
        this.cashier.selectOrigin();
        this.cashier.selectDestination();
    }

    public void selectPromo() {
        link(By.xpath(PROMO_XPATH)).click();
    }
}

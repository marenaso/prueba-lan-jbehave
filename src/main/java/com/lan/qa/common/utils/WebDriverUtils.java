package com.lan.qa.common.utils;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.WebDriver;

/**
 * Created with IntelliJ IDEA.
 * User: marenaso
 * Date: 08-10-13
 * Time: 05:19 PM
 * To change this template use File | Settings | File Templates.
 */

public class WebDriverUtils {

    private WebDriver webDriver;

    public WebDriverUtils(WebDriverProvider webDriverProvider) {
        this.webDriver = webDriverProvider.get();
    }

    public void go(String url) {
        this.webDriver.get(url);
    }


}

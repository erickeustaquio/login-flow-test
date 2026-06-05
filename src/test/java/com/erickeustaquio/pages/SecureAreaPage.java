package com.erickeustaquio.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {


    private WebDriver driver;
    private By statusAlert = By.id("flash");


    public SecureAreaPage (WebDriver driver) {

        this.driver = driver;
    }

    public String getAlertText(){
        return driver.findElement(statusAlert)
                .getText()
                .replace("×", "")   // remove o "x" do alerta
                .replace("\n", "")  // remove quebras de linha
                .trim();            // remove espaços extras

    }
}

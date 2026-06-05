package com.erickeustaquio.base;

import com.erickeustaquio.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        //WebDriverManager baixa e configura automaticamente o ChromeDriver
        WebDriverManager.chromedriver().setup();

        //Se estiver rodando no GitHub actions (variaveis Ci definida), usa headles
        ChromeOptions options = new ChromeOptions();
        if (System.getenv("CI") != null) {
            options.addArguments("--headless=new");
        }

        driver = new ChromeDriver(options);
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }


    @AfterClass
    public void tearDown(){
        driver.quit(); // Fecha o navegador ao final do teste

    }



}

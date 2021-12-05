import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static org.testng.Reporter.log;


public class CreateWalletPage {

    private final By pin1       = By.xpath("//android.view.ViewGroup[@content-desc='pin-pad-button-1']");
    private final By pin2       = By.xpath("//android.view.ViewGroup[@content-desc='pin-pad-button-2']");
    private final By pin3       = By.xpath("//android.view.ViewGroup[@content-desc='pin-pad-button-3']");
    private final By pin4       = By.xpath("//android.view.ViewGroup[@content-desc='pin-pad-button-4']");
    private final By pin5       = By.xpath("//android.view.ViewGroup[@content-desc='pin-pad-button-5']");
    private final By pin6       = By.xpath("//android.view.ViewGroup[@content-desc='pin-pad-button-6']");
    private final By confirmBtn = By.xpath("//android.view.ViewGroup[@content-desc='confirm-btn']/android.view.ViewGroup/android.view.View");




    private final AndroidDriver<MobileElement> driver;

    public CreateWalletPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void sendPin() throws InterruptedException {
        Thread.sleep(10000);
        driver.findElement(pin1).click();
        driver.findElement(pin2).click();
        driver.findElement(pin3).click();
        driver.findElement(pin4).click();
        driver.findElement(pin5).click();
        driver.findElement(pin6).click();

    }

    public void confirmBtn() throws InterruptedException {
        Thread.sleep(10000);
        driver.findElement(confirmBtn).click();


    }

    public void login() throws InterruptedException{
        sendPin();
        sendPin();
        confirmBtn();
    }

}
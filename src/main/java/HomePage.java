import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.aspectj.util.FileUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Thread.sleep;
import static org.testng.Reporter.log;

public class HomePage {

    private final By switchButon = By.xpath("//android.view.ViewGroup[@content-desc='privacy-policy-switch']");
    private final By continueButon = By.xpath("//android.view.ViewGroup[@content-desc='privacy-policy-confirm-btn']/android.view.ViewGroup/android.view.View");
    private final By createWallet = By.xpath("//android.view.ViewGroup[@content-desc='create-wallet-btn']/android.view.ViewGroup/android.view.View");
    private final By titleLabel = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[2]");


    /*String actualTxt = titleLabel.getAttribute("text");
        System.out.println("Actual test -" +actualTxt);
    String expectedTxt = "Enter New Pin";

        Assert.assertEquals(actualTxt,"Enter New Pin");

        if (actualTxt.equals("Enter New PIN")) {
        System.out.println("PASSED");
    }
        else {
        System.out.println("FAILED");
    }*/
    private final AndroidDriver<MobileElement> driver;

    public HomePage(AndroidDriver<MobileElement> driver) throws InterruptedException {
        this.driver = driver;

    }

    public void clickSwitchBtn() throws InterruptedException  {
        Thread.sleep(50000);
        driver.findElement(switchButon).click();

    }

    public void clickContinueBtn() throws InterruptedException {
        Thread.sleep(20000);
        driver.findElement(continueButon).click();


    }
    public void clickCreateWalletBtn()throws InterruptedException {
        Thread.sleep(10000);
        driver.findElement(createWallet).click();

    }
    public String getTitleLabelLabelTxt() {

        return driver.findElement(titleLabel).getText();

    }
    public void homeScreen() throws InterruptedException {
        clickSwitchBtn();
        clickContinueBtn();
        clickCreateWalletBtn();
    }
}
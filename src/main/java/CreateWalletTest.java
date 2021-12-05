import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.util.concurrent.TimeUnit.SECONDS;

public class CreateWalletTest {

    private final DesiredCapabilities dc = new DesiredCapabilities();
    private AndroidDriver<MobileElement> driver;
    private CreateWalletPage createWalletPage;
    String folder_name;
    DateFormat df;

    public void captureScreenShots() throws IOException {
        folder_name="screenshot";
        File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //Date format fot screenshot file name
        df=new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
        //create dir with given folder name
        new File(folder_name).mkdir();
        //Setting file name
        String file_name=df.format(new Date())+".png";
        //coppy screenshot file into screenshot folder.
        FileUtils.copyFile(f, new File(folder_name + "/" + file_name));
    }

    @BeforeSuite
    public void setupDeviceCapabilities() {

        /*dc.setCapability("app", new File(System.getProperty("user.dir")
                + "/src/test/resources/loginApp.apk").getAbsolutePath());

        dc.setCapability("noReset", true);
        dc.setCapability("fullReset", false);
*/

        dc.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel XL API 30");
        dc.setCapability("platformName","Android");
        dc.setCapability("appPackage","cash.klever.blockchain.wallet");
        dc.setCapability("appActivity","cash.klever.blockchain.wallet.MainActivity");


    }

    @BeforeMethod
    public void spinUpAndroidDriver() {
        try {
            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
            String sessionId = driver.getSessionId().toString();
            System.out.println(sessionId +""+ " Application started...");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(10, SECONDS);

    }

    @Test(description = "Ana Ekran...")
    public void testHomeScreen() throws InterruptedException  {

        HomePage homePage = new HomePage(driver);
        createWalletPage = new CreateWalletPage(driver);
        homePage.homeScreen();
        Assert.assertEquals(homePage.getTitleLabelLabelTxt(), "Enter New PIN");
        System.out.println("pass");
        Thread.sleep(10000);
        createWalletPage.login();


    }

    @AfterMethod
    public void stopAndroidDriver() {
        driver.quit();
    }
}
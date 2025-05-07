import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.URL;
import java.time.Duration;

public class SampleTest {
    private AndroidDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void setup() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Samsung Galaxy A52");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.samsung.android.app.reminder");
        caps.setCapability("appActivity", "com.samsung.android.app.reminder.MainActivity");
        caps.setCapability("automationName", "UiAutomator2"); // Explicitly set automation engine
        caps.setCapability("noReset", true); // Prevents app reset between tests

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait
    }

    @Test
    public void testReminderWithoutTime() {
        //  Open app and tap "+" with explicit wait
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.samsung.android.app.reminder:id/floating_action_button")));
        addButton.click();

        //  Enter title but skip time
        WebElement titleField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("com.samsung.android.app.reminder:id/add_viewholder_text_view")));
        titleField.sendKeys("No Time Reminder");

        //  Verify "Save" button is disabled
        WebElement saveButton = driver.findElement(By.id("com.samsung.android.app.reminder:id/action_save_reminder"));
        Assert.assertFalse(saveButton.isEnabled(), "Save button should be disabled when time is not set");


    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}





















//import io.appium.java_client.android.AndroidDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.By;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import java.net.URL;
//
//public class SampleTest {
//
//    private AndroidDriver<WebElement> driver;
//
//    public void setUp() throws Exception {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("platformVersion", "14");  // Adjust accordingly
//        capabilities.setCapability("deviceName", "Galaxy A52");  // Adjust accordingly
//        capabilities.setCapability("appPackage", "com.samsung.android.app.reminder");
//        capabilities.setCapability("appActivity", ".ui.LaunchMainActivity");
//        capabilities.setCapability("automationName", "UiAutomator2");
//
//        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//    }
//
//    public void test() {
//        // Replace with actual resource ID of the element
//        WebElement element = driver.findElement(By.id("com.samsung.android.app.reminder"));
//        element.click();
//    }
//
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//}













//import io.appium.java_client.android.MobileDriver;
//import io.appium.java_client.android.MobileElement;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import java.net.URL;
//import org.openqa.selenium.By;
//
//
//public class SampleTest {
//
//    private AndroidDriver<MobileElement> driver;
//
//    public void setUp() throws Exception {
//        // Set up the DesiredCapabilities
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("platformVersion", "14");  // Adjust accordingly
//        capabilities.setCapability("deviceName", "Galaxy A52");  // Adjust to your device or emulator name
//        capabilities.setCapability("appPackage", "com.samsung.android.app.reminder");
//        capabilities.setCapability("appActivity", ".ui.LaunchMainActivity");
//        capabilities.setCapability("automationName", "UiAutomator2");
//
//        // Initialize the AndroidDriver
//        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//    }
//
//    public void test() {
//        // Your test code goes here
//        // Example: Find an element and perform an action
//        MobileElement element = driver.findElementById("com.example:id/button");
//        element.click();
//    }
//
//    public void tearDown() {
//        // Close the session after test
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//}



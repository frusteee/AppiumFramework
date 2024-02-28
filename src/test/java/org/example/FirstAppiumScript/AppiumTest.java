package org.example.FirstAppiumScript;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;
import org.example.App;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class AppiumTest {

    @Test
    public void androidLaunchTest() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setUdid("emulator-5554");
        options.setApp(System.getProperty("user.dir") + "/src/test/resources/apps/Android-MyDemoAppRN.1.3.0.build-244.apk");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        Thread.sleep(4000);
    }

    @Test
    public void iOSLaunchTest() throws MalformedURLException, InterruptedException {
        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iphone 12");
        options.setApp(System.getProperty("user.dir") + "/src/test/resources/apps/Android-MyDemoAppRN.1.3.0.build-244.zip");

        IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
        Thread.sleep(4000);
    }

    @Test
    public void androidWaitPlugins() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setUdid("emulator-5554");
        options.setApp(System.getProperty("user.dir") + "/src/test/resources/apps/Android-MyDemoAppRN.1.3.0.build-244.apk");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // use appium 2.0 Plugin appium --use-plugins=element-wait
        driver.findElement(AppiumBy.accessibilityId("open menu")).click();

        driver.findElement(By.xpath("//android.widget.TextView[@text=\"Log In\"]")).click();

        driver.findElement(AppiumBy.accessibilityId("Username input field")).sendKeys("Rahul");
        driver.quit();
    }

    @Test
    public void androidTap() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setUdid("emulator-5554");
        options.setApp(System.getProperty("user.dir") + "/src/test/resources/apps/Android-MyDemoAppRN.1.3.0.build-244.apk");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        WebElement open_menu = driver.findElement(AppiumBy.accessibilityId("open menu"));
        tap(driver, open_menu);

    }

    @Test
    public void androidDoubleTap() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setUdid("emulator-5554");
        options.setApp(System.getProperty("user.dir") + "/src/test/resources/apps/Android-MyDemoAppRN.1.3.0.build-244.apk");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        WebElement open_menu = driver.findElement(AppiumBy.accessibilityId("open menu"));
        doubleTap(driver, open_menu);


    }

    @Test
    public void androidLongPress() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setUdid("emulator-5554");
        options.setApp(System.getProperty("user.dir") + "/src/test/resources/apps/ApiDemos-debug.apk");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        WebElement peoplesName = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"People Names\"]"));

        longPress(driver, peoplesName);
        new Actions(driver).clickAndHold(peoplesName)
                .build().perform();

    }

    @Test
    public void androidZoom() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setUdid("emulator-5554");
        options.setApp(System.getProperty("user.dir") + "/src/test/resources/apps/Android-MyDemoAppRN.1.3.0.build-244.apk");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        WebElement open_menu = driver.findElement(AppiumBy.accessibilityId("open menu"));
        tap(driver, open_menu);
        driver.findElement(By.xpath("(//android.widget.TextView[@text=\"Drawing\"])[1]")).click();

        WebElement img = driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id=\"signature-pad\"]/android.view.View/android.widget.Image[2]\n"));
        Point centerLocation = getCenterLocation(img);

        zoom(driver, centerLocation);


    }

    @Test
    public void androidSwipeOrScroll() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setUdid("emulator-5554");
        options.setApp(System.getProperty("user.dir") + "/src/test/resources/apps/ApiDemos-debug.apk");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        scrollOrSwipe(driver);

    }

    @Test
    public void scrollIntoView() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setUdid("emulator-5554");
        options.setApp(System.getProperty("user.dir") + "/src/test/resources/apps/ApiDemos-debug.apk");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        By webView = AppiumBy.accessibilityId("WebView");

        int counter=0;
        while(!driver.findElement(webView).isDisplayed() && counter<10){
        scrollOrSwipe(driver);
        counter++;
        }




    }

    private void scrollOrSwipe(AndroidDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int startX = size.getWidth()/2;
        int startY = size.getHeight()/2;

        int endX =startX;
        int endY = startY/2;

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1);
        sequence.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),startX,startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1,Duration.ofMillis(200)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(),endX,endY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
    }

    private void zoom(AndroidDriver driver, Point centerLocation) {
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");

        Sequence sequence1 = new Sequence(finger1, 1);
        Sequence sequence2 = new Sequence(finger2, 1);

        sequence1.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerLocation))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1,Duration.ofMillis(200)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(),
                        centerLocation.getX()+100, centerLocation.getY()-100))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        sequence2.addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerLocation))
                .addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger2,Duration.ofMillis(200)))
                .addAction(finger2.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(),
                        centerLocation.getX()-100, centerLocation.getY()+100))
                .addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(sequence1,sequence2));
    }

    private void longPress(AndroidDriver driver, WebElement peoplesName) {
        Point point = peoplesName.getLocation();
        Point centerLocation = getCenterLocation(peoplesName);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.MOUSE, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ofMillis(3000), PointerInput.Origin.viewport(), centerLocation))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofSeconds(3)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
    }

    private void tap(AndroidDriver driver, WebElement open_menu) {
        Point point = open_menu.getLocation();
        Point centerLocation = getCenterLocation(open_menu);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.MOUSE, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerLocation))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(200)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
    }

    private void doubleTap(AndroidDriver driver, WebElement open_menu) {
        Point point = open_menu.getLocation();
        Point centerLocation = getCenterLocation(open_menu);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.MOUSE, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ofMillis(3000), PointerInput.Origin.viewport(), centerLocation))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(100)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(100)))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(100)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
    }

    private Point getCenterLocation(WebElement ele) {
        return new Point(ele.getLocation().getX()+ele.getSize().getWidth()/2,ele.getLocation().getY()+ele.getSize().getHeight()/2);
    }

    @Test
    public void androidLaunchDC() {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setUdid("emulator-5554");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();


        options.setCapability("appium:appPackage", "com.google.android.youtube");
        options.setCapability("appium:appActivity", "com.google.android.apps.youtube.app.watchwhile.WatchWhileActivity");
        options.setCapability("platformName", "Android");
        options.setCapability("appium:platformVersion", "14.0");
        options.setCapability("appium:automationName", "uiautomator2");

        try {
            AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            TouchAction touchAction = new TouchAction(driver);
            driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
            WebElement element = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Search\"]"));
            // element.click();
            element.wait(5000);

        } catch (MalformedURLException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
    }
}

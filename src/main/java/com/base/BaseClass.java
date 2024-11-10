package com.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.utilis.LoggerUtil;

public class BaseClass {
	protected static WebDriver driver;
	protected WebDriverWait wait;

	public WebDriver initializeDriver() {
		System.setProperty("webdriver.chrome.driver", "D:\\Ece\\JeepIndia\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 15);
		driver.manage().window().maximize();
		return driver;

	}

	public void launchUrl() {
//		driver.get("https://www.jeep.com/");
		// server issue in the main url -- so direcly navigating to India Site url
		driver.get("https://www.jeep-india.com/");
	}

	public void quitDriver() {

		driver.quit();

	}

	public void clickWebElement(WebElement element) {
		element.click();
	}

	public static void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000);", "");

	}

	public static void scrollByElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);

	}

	public void waitTimeout() throws InterruptedException {
		Thread.sleep(9000);
	}

	public void waitForElement() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public void verifyTextPresence(WebElement element, String text) {

		String textvalue = element.getText();
		System.out.println(textvalue);
		boolean isPresent = textvalue.contains(text);
		if (isPresent) {
			verifyAsserTrue(isPresent);
			LoggerUtil.logInfo("The Expected Title is : " + text + " is Successfully Validated");
		}

	}

	public void verifyAssertEquals(String actual, String expected) {
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(actual, expected);
		softassert.assertAll();
	}

	public void verifyAsserTrue(boolean value) {
		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(value);
		softassert.assertAll();
	}
}

package com.framework.test;

import com.base.BaseClass;
import com.pages.FeatureConfiguration;
import com.pages.HomePage;
import com.pages.VechicleSelection;
import com.utilis.LoggerUtil;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JeepConfiguratorTest extends BaseClass {
	HomePage hp;
	WebDriver driver;
	VechicleSelection vs;
	FeatureConfiguration fc;

	@BeforeClass
	public void setUp() {
		driver = initializeDriver();
		hp = new HomePage(driver);
		vs = new VechicleSelection(driver);
		fc= new FeatureConfiguration(driver);
		LoggerUtil.logInfo("Test setup initialized.");
	}

	@Test
	public void testJeepConfigurator() throws InterruptedException, AWTException {

		launchUrl();
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl="https://www.jeep-india.com/";
		if(actualUrl.equalsIgnoreCase(expectedUrl))
		{
			LoggerUtil.logInfo("Jeep India Launched As Expected");
		}
		else
		{
			LoggerUtil.logError("The Url is Invalid");
		}
		
		waitTimeout();
		//waitForElement();
//		hp.clickIndiaSite(); --- server issue in clicking India site
		BaseClass.scrollDown();
		hp.clickBuildAndPrice();
		vs.selectVechicleAndClickBuild3D();
		waitTimeout();
		fc.selectFeatures();
		fc.view360degree();

	}

	@AfterClass
	public void tearDown() {
		quitDriver();
		LoggerUtil.logInfo("Execution Completed and Closed Browser Session");
	}
}
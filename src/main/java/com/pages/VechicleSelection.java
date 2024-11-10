package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
import com.utilis.Constants;

public class VechicleSelection extends BaseClass {

	WebDriver driver;
	@FindBy(xpath = "//h2[text()='COMPARE & BUILD IN 3D']")
	private WebElement checkCompareAndBuild3DTitle;

	@FindBy(xpath = "//div[text()='Wrangler']")
	private WebElement vechicleSelection;

	@FindBy(xpath = "(//span[text()='Build 3D'])[1]")
	private WebElement clickBuild3DBtn;

	public void selectVechicleAndClickBuild3D() throws InterruptedException {
		waitTimeout();
		verifyTextPresence(checkCompareAndBuild3DTitle, Constants.compareTitle);
		waitTimeout();
		scrollByElement(vechicleSelection);
		waitTimeout();
		clickWebElement(vechicleSelection);
		waitTimeout();
		clickWebElement(clickBuild3DBtn);

	}

	public VechicleSelection(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

}

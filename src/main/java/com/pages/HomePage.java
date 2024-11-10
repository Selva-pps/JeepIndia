package com.pages;

import com.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {

	WebDriver driver;

	@FindBy(xpath = "//a[@data-lid='overlay:go-to-India']")
	private WebElement siteSelection;

	@FindBy(xpath = "(//a[text()='Build & Price'])[3]")
	private WebElement buildAndPrice;

	public void clickIndiaSite() {

		clickWebElement(siteSelection);

	}

	public void clickBuildAndPrice() {
		clickWebElement(buildAndPrice);

	}

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

}

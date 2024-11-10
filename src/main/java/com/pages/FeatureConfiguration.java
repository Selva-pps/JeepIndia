package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;

public class FeatureConfiguration extends BaseClass {

	WebDriver driver;

	@FindBy(xpath = "//*[@id=\"iframe-3d-config\"]")
	private WebElement frame2;

	@FindBy(xpath = "//h4[text()='VARIANT']/..")
	private WebElement variantSelection;

	@FindBy(xpath = "(//ion-checkbox[@role='checkbox'])[1]")
	private WebElement unlimitedSelect;

	@FindBy(xpath = "(//ion-label[text()='ACCESSORIZE'])[1]")
	private WebElement accessorizeBtn;

	@FindBy(xpath = "//button[text()=' ADD ']")
	private List<WebElement> addBtn;

	@FindBy(xpath = "/html/body/app-root/ion-app/ion-router-outlet/visualizer/ion-content/ion-row[1]/ion-col[1]/div[1]/ion-accordion-group/ion-accordion[2]/ion-card-content/accessories/div/ion-segment/ion-segment-button[2]")
	private WebElement interiorOption;

	@FindBy(xpath = "(//ion-label[text()='ADD-ONS'])[1]")
	private WebElement addonsBtn;

	@FindBy(xpath = "//ion-button[text()=' SUMMARY ']")
	private WebElement submitBtn;

	@FindBy(xpath = "//span[text()='TOTAL PRICE']/../following-sibling::ion-col")
	private WebElement totalPrice;

	@FindBy(xpath = "//*[@id=\"one3d-canvas\"]")
	private WebElement view360Degree;

	@FindBy(xpath = "//div[@class='one3d-login-popup-wrapper']/div/*[@name='close']")
	private WebElement loginCloseBtn;

	public void closeIfLoginPopup() {
		try {
			waitTimeout();
			if (loginCloseBtn.isDisplayed()) {
				loginCloseBtn.click();
			}
		} catch (Exception e)

		{
			System.out.println(e.getLocalizedMessage());
		}
	}

	public void robotDown() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}

	public void robotUp() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_UP);
		r.keyRelease(KeyEvent.VK_UP);
		r.keyPress(KeyEvent.VK_UP);
		r.keyRelease(KeyEvent.VK_UP);
		r.keyPress(KeyEvent.VK_UP);
		r.keyRelease(KeyEvent.VK_UP);
		r.keyPress(KeyEvent.VK_UP);
		r.keyRelease(KeyEvent.VK_UP);
		r.keyPress(KeyEvent.VK_UP);
		r.keyRelease(KeyEvent.VK_UP);
	}

	public void selectFeatures() throws InterruptedException, AWTException {
		waitTimeout();
		waitTimeout();
		driver.switchTo().frame(frame2);
		waitTimeout();
		clickWebElement(accessorizeBtn);
		waitTimeout();
		clickWebElement(variantSelection);
//		clickVariant();
		waitForElement();
		waitTimeout();
//		scrollByElement(unlimitedSelect); -- by default unlimited is selected
//		clickWebElement(unlimitedSelect);
		waitTimeout();
		clickWebElement(variantSelection);
		waitTimeout();
		closeIfLoginPopup();
		clickWebElement(accessorizeBtn);
		waitTimeout();
		clickWebElement(addBtn.get(0));
		waitTimeout();
		robotDown();
		waitTimeout();
		clickWebElement(addBtn.get(1));
		waitTimeout();
		closeIfLoginPopup();
		robotDown();
		waitTimeout();
		robotDown();
		waitTimeout();
		clickWebElement(addBtn.get(1));
		waitTimeout();
		robotUp();
		waitTimeout();
		waitTimeout();
		clickWebElement(interiorOption);
		waitTimeout();
		clickWebElement(addBtn.get(0));
		waitTimeout();
		robotDown();
		waitTimeout();
		clickWebElement(addBtn.get(0));
		waitTimeout();
		closeIfLoginPopup();
		robotDown();
		waitTimeout();
		clickWebElement(addBtn.get(1));
		waitTimeout();
		clickWebElement(accessorizeBtn);
		waitTimeout();
		robotUp();
		waitTimeout();
		clickWebElement(addonsBtn);
		waitTimeout();
		clickWebElement(addBtn.get(13));
		waitTimeout();
		clickWebElement(submitBtn);
		waitTimeout();
		String totalPriceValue = totalPrice.getText();
		waitTimeout();
		System.out.println("The Total Price is : " + totalPriceValue);

	}

	private void clickVariant() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement shadowHost = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"body > app-root > ion-app > ion-router-outlet > visualizer > ion-content > ion-row.one-3d-fullHeight.one3d-visualizer-row.md.hydrated > ion-col.one3d-visualizer-lhs.ion-no-padding.md.hydrated > div.one3d-lhs-panel-wrapper > ion-accordion-group > ion-accordion.md.accordion-animated.hydrated.accordion-expanded > ion-item")));
		WebElement shadowRoot = (WebElement) ((JavascriptExecutor) driver)
				.executeScript("return arguments[0].shadowRoot", shadowHost);
		WebElement accordionItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button")));
		accordionItem.click();
	}

	public void view360degree() throws InterruptedException {
		waitTimeout();
		Actions actions = new Actions(driver);
		actions.clickAndHold(view360Degree).moveByOffset(300, 0).release().perform();
	}

	public FeatureConfiguration(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

}

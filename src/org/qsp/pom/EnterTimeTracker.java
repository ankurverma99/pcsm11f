package org.qsp.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class EnterTimeTracker {
	@FindBy(id = "addTaskButtonId")
	private WebElement newButton;

	@FindBy(xpath = "//div[text()='kbvjkb' and @class='selectedItem']")
	private WebElement combobox;

	@FindBy(xpath = "//div[text()='- New Customer -' ]")
	private WebElement newCustomer;

	@FindBy(xpath = "//input[@placeholder='Enter Customer Name']")
	private WebElement customerName;

	@FindBy(xpath = "//input[@placeholder='Enter Project Name']")
	private WebElement projectName;

	public EnterTimeTracker(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void newClick() {
		newButton.click();
	}

	public void comboClick() {
		combobox.click();
	}

	public void newCustomerClick() {
		newCustomer.click();
	}

	public void customerName(String cname) {
		customerName.sendKeys(cname);
	}

	public void projectName(String pname) {
		projectName.sendKeys(pname);
	}

	public void verfiyHPisDisplayed(WebDriver driver, long eto) {
		WebDriverWait ww = new WebDriverWait(driver, eto);
		ww.until(ExpectedConditions.titleContains("Enter"));
		Reporter.log("Home page is displayed", true);
	}
}

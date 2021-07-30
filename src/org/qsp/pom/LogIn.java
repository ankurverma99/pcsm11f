package org.qsp.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogIn {
	@FindBy(id = "username")
	private WebElement username;

	@FindBy(name = "pwd")
	private WebElement password;

	@FindBy(id = "loginButton")
	private WebElement loginButton;

	@FindBy(linkText = "Forgot your password?")
	private WebElement forgotPassword;

	@FindBy(id = "keepMeLoggedInCaptionContainer")
	private WebElement keepMeLogIn;

	public LogIn(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void sendUsername(String usrname) {
		username.sendKeys(usrname);
	}

	public void sendPassword(String pass) {
		password.sendKeys(pass);
	}

	public void loginClick() {
		loginButton.click();
	}

	public void fPClick() {
		forgotPassword.click();
	}

	public void keepMeLoginClick() {
		keepMeLogIn.click();
	}

}

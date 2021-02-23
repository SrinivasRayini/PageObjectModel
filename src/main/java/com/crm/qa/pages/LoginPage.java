package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//page factory - OR:

	@FindBy(name="email")
	@CacheLookup
	WebElement username;

	@FindBy(name="password")
	@CacheLookup
	WebElement password;

	@FindBy(xpath="//div[text()='Login']")
	@CacheLookup
	WebElement loginBtn;


	@FindBy(xpath="//a[text()='Sign Up']")
	@CacheLookup
	WebElement signUpLink;

	@FindBy(xpath="//a[text()='Forgot your password?']")
	@CacheLookup
	WebElement forgotPwdLink;

	//initializing the page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	

	public HomePage login(String user, String pwd){
		username.clear();
		username.sendKeys(user);
		password.clear();
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}
	
	public SignUpPage clickOnSignUpLink() {
		signUpLink.click();
		return new SignUpPage();
	}

}

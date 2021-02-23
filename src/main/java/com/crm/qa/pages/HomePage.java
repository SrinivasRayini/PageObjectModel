package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//span[contains(text(),'Srinivas Rayini')]")
	WebElement userNameLabel;

	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	@CacheLookup
	WebElement contactsLink;

	@FindBy(xpath = "//span[contains(text(),'Deals')]")
	@CacheLookup
	WebElement dealsLink;

	@FindBy(xpath = "//span[contains(text(),'Tasks')]")
	@CacheLookup
	WebElement tasksLink;
	
	@FindBy(xpath="//span[text()='Home']")
	@CacheLookup
	WebElement homeBtn;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String validateHomePageTitle() {
		return driver.getTitle();
	}

	public String validateUserNameLabel() {
		return userNameLabel.getText();
	}

	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	} 
	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}

	public HomePage clickOnHomeButton() {
		homeBtn.click();
		return new HomePage();
	}
}

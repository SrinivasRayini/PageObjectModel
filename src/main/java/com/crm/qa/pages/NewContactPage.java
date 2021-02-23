package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class NewContactPage extends TestBase{

	@FindBy(name="first_name")
	WebElement first_name;

	@FindBy(name="last_name")
	WebElement last_name;

	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement saveBtn;

	@FindBy(xpath="//button[@class='ui button']")
	WebElement cancelBtn;

	public void createNewContact(String firstName, String lastName) {
		//		first_name.clear();
		if(first_name != null)
			first_name.sendKeys(firstName);
		else
			System.out.println("first_name is null");
		//		last_name.clear();
		if(last_name!=null)
			last_name.sendKeys(lastName);
		else
			System.out.println("last_name is null");
		
	}


	public ContactPage clickOnSaveButton() {
		TestUtil.clickOnElementByjsExecutor(driver, saveBtn);
		return new ContactPage();
	}

	public ContactsPage clickOnCancelButton() {
		TestUtil.clickOnElementByjsExecutor(driver, cancelBtn);
		return new ContactsPage();
	}










}

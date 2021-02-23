package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactPage extends TestBase{
	
	@FindBy(xpath="//i[@class='trash icon']")
	WebElement deleteBtn;
	
	@FindBy(xpath="//a[text()='All']")
	WebElement allBtn;
	
	@FindBy(xpath="//a[text()='Notes']")
	WebElement notesBtn;
	
	@FindBy(xpath="//a[text()='Events']")
	WebElement eventsBtn;
	
	@FindBy(xpath="//i[contains(@class,'remove icon')]")
	WebElement confirmDelete;
	
	
	
	//i[contains(@class,'remove icon')]
	public ContactPage() {
		PageFactory.initElements(driver, this);
	}
	
	//methods
	
	public ContactsPage clickOnDeleteButton() {
		deleteBtn.click();
		confirmDelete.click();
		return new ContactsPage();
	}
	
	public void clickOnNotesButton() {
		notesBtn.click();
	}
	
	
}

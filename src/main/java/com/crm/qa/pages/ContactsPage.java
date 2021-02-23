package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	@FindBy(xpath="//a[@href='/contacts/new']")
	WebElement newContact;
	
	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	//methods
	public NewContactPage clickOnNewContact() {
		newContact.click();
		driver.navigate().refresh();
		return new NewContactPage();
	}
	
	public void selectContactByName(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']/parent::td//preceding-sibling::td//input[@name='id']")).click();
	}
	
	public ContactPage openContactByName(String name) {
		 driver.findElement(By.xpath("//a[text()='"+name+"']")).click();
		 return new ContactPage();
	}
	
	
	
	
	
	
	
}

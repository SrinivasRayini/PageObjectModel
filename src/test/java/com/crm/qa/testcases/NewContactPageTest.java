package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContactPage;
import com.crm.qa.util.TestUtil;

public class NewContactPageTest extends TestBase{

	TestUtil testUtil;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	NewContactPage newContactPage;
	ContactPage contactPage;
	String sheetName = "contacts";

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.clickOnContactsLink();
		newContactPage = contactsPage.clickOnNewContact();
	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] =  TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(dataProvider = "getCRMTestData")
	public void createContactTest(String firstName, String lastName) {
		System.out.println("------- In enterNameTest ----------------");
		driver.navigate().refresh();
		newContactPage.createNewContact(firstName, lastName);
		
		contactPage = newContactPage.clickOnSaveButton();
	}



	@AfterMethod
	public void tearDown() {
		//		driver.quit();
	}



}

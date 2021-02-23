package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;

	public HomePageTest() {
		super();
	}
	//test cases should be independent
	//before each test case launch the browser and login
	//execute the test
	//after each test case, logout n close the browser

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		System.out.println("---- In verifyHomePageTitleTest -----");
		String homePagetitle = homePage.validateHomePageTitle();
		System.out.println("Home page title:==> " + homePagetitle);
		Assert.assertEquals(homePagetitle, "Cogmento CRM"," Home page title not matched");
	}

	@Test(priority = 2)
	public void verifyUserNameLabelTest(){
		System.out.println("----- In verifyUserNameLabelTest ------ ");
		String userName =  homePage.validateUserNameLabel();
		System.out.println("User name is:==> "+userName);
		Assert.assertEquals(userName, "Srinivas Rayini","User name not matched");
	}

	@Test
	public void contactsLinkTest() {
		System.out.println("---- In contactsLinkTest ----- ");
		contactsPage = homePage.clickOnContactsLink();
	}




	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}

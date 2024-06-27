package org.e_learning_platform.E_Learning_Plateform;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.pom.E_Learning_POM;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class E_Learning extends BaseClass {
	E_Learning_POM e;

	@BeforeClass
	@Parameters("browser")
	public void setUp(String browserName) throws Exception {
		launchBrowser(browserName);
		e = new E_Learning_POM(driver);
		Thread.sleep(1500);
	}

	@DataProvider(name = "valid")
	public Object[][] data() {
		return new Object[][] { { "deepaksundaravelu@gmail.com", "Deepak.S1" } };
	}

	@DataProvider(name = "invalid")
	public Object[][] data1() {
		return new Object[][] { { "deepak1@gmail.com", "Deep2k.S1" } };
	}

	@Test(priority = 2, dataProvider = "valid")
	public void validUserRegistration(String uid, String pwd) throws Exception {
		driver.navigate().refresh();

		String title = pageTitle();

		e.getUsrnameTxt().clear();
		e.getUsrnameTxt().sendKeys(uid);
		Thread.sleep(1000);
		e.getPassTxt().sendKeys(pwd);
		Thread.sleep(1000);

		SoftAssert s = new SoftAssert();
		s.assertTrue(title.contains("Log in"), "Title does not contain 'Log in'");

		e.getSubmit().click();
		Thread.sleep(4000);
		s.assertAll();
	}

	@Test(priority = 1, dataProvider = "invalid")
	public void invalidUserRegistration(String uid, String pwd) throws Exception {
		e.getCurIcon().click();
		Thread.sleep(1500);
		e.getSignBtn().click();
		Thread.sleep(1500);
		String title = pageTitle();

		e.getUsrnameTxt().sendKeys(uid);
		Thread.sleep(1000);
		e.getPassTxt().sendKeys(pwd);
		Thread.sleep(1000);

		SoftAssert s = new SoftAssert();
		s.assertTrue(title.contains("Log in"), "Title does not contain 'Log in'");

		e.getSubmit().click();
		Thread.sleep(4000);
		s.assertAll();
	}

	@AfterClass
	public void closetheBrowser() {
		closeBrowser();
	}

}

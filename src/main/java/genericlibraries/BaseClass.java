package genericlibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import pomPages.ContactUsPage;
import pomPages.CoreJavaForSeleniumPage;
import pomPages.CoreJavaVideoPage;
import pomPages.HomePagePom;
import pomPages.SeleniumTrainingPage;
import pomPages.SkillraryDemoAppPage;
import pomPages.TestingPage;

public class BaseClass {
	protected PropertiesFileUtility property;
	protected ExcelUtility excel;
	protected WebDriverUtility web;
	protected WebDriver driver;
	protected HomePagePom home;
	protected SkillraryDemoAppPage skillraryDemo;
	protected SeleniumTrainingPage selenium;
	protected TestingPage testing;
	protected CoreJavaForSeleniumPage corejava;
	protected CoreJavaVideoPage javavideo;
	protected ContactUsPage contact;
	protected long time;
	//@BeforeSuite
	//@BeforeTest
	@BeforeClass
	public void classConfirguration()
	{
		property=new PropertiesFileUtility();
		excel=new ExcelUtility();
		web=new WebDriverUtility();
		
		property.propertyFileInialization(IConstantPath.PROPERTIES_FILE_PATH);
		excel.excelInitialization(IConstantPath.EXCEL_FILE_PATH);
		
	}
	@BeforeMethod
	public void methodConfiguration()
	{
		time=Long.parseLong(property.featchproperties("timeouts"));
		driver=web.openApplication(property.featchproperties("browser"), property.featchproperties("url"), time);
		home=new HomePagePom(driver);
		
		Assert.assertTrue(home.getLogo().isDisplayed());
		
		skillraryDemo=new SkillraryDemoAppPage(driver);
		selenium=new SeleniumTrainingPage(driver);
		corejava=new CoreJavaForSeleniumPage(driver);
		testing=new TestingPage(driver);
		contact=new ContactUsPage(driver);
			
	}
	
	@AfterMethod
	public void methodTearDown()
	{
		web.quitBrowser();
	}
	@AfterClass
	public void classTearDown()
	{
		excel.closeExcel();
	}
	//@AfterTest
	//@AfterSuite

}

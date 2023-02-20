package testscripts;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;
import pomPages.SkillraryDemoAppPage;

public class FourthTest extends BaseClass  {
	
		@Test
		public void firstTest()
		{
			SoftAssert soft=new SoftAssert();
			home.ClickGears();
			home.ClickSkillrarydemoApp();
			web.handleChildBrowser();
		
			soft.assertTrue(skillraryDemo.getPageHeader().isDisplayed());
		
			web.scrollToElement(skillraryDemo.getContactUs());
			skillraryDemo.clickContactUs();
			
			soft.assertTrue(contact.getPageHeader().isDisplayed());
			
			List<String> data=excel.fetchDataFromExcel("sheet1");
			contact.submitDetails(data.get(0), data.get(1), data.get(2), data.get(3));
			
			soft.assertAll();
		}
	}




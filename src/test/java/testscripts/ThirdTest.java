package testscripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import genericlibraries.BaseClass;

public class ThirdTest extends BaseClass
	{
		@Test
		public void thirdTest() throws InterruptedException
		{
			SoftAssert soft=new SoftAssert();
			home.searchFor("core java for selenium");
			soft.assertEquals(corejava.getPageHeader(),"CORE JAVA FOR SELENIUM");
			
			corejava.clickCoreJavaForSeleniumLink();
			soft.assertEquals(javavideo.getPageHeader(), "Core Java For Selenium Training");
			
			javavideo.clickCloseCookies();
			web.swithToFrame();
			javavideo.clickPlayButton();
			Thread.sleep(2000);
			javavideo.clickPauseButton();
			
			web.switchToBackFromFrame();
			javavideo.clickAddWishListTab();
			soft.assertAll();
			
		}
	}




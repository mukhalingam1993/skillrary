package genericlibraries;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains all reusable webDriver methods
 * 
 * @author user
 *
 */

public class WebDriverUtility {
	WebDriver driver;

	/**
	 * This method is used to navigate to application
	 * 
	 * @param browser
	 * @param url
	 * @param time
	 * @return
	 */
	public WebDriver openApplication(String browser, String url, long time) {
		switch (browser) {
		case "chrome":driver = new ChromeDriver();break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Invalid browser data");
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		return driver;
	}

	/**
	 * These methods are used to handling mouse actions using Actions class
	 * 
	 * @param element
	 */
	public void mouseHover(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void doubleClickOnElement(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	public void dragAndDropElement(WebElement src, WebElement dest) {
		Actions action = new Actions(driver);
		action.dragAndDrop(src, dest).perform();
	}

	/**
	 * These methods are used to handle dropDowns using select class
	 * 
	 * @param element
	 * @param index
	 */
	public void dropdown(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	public void dropdown(String text, WebElement element) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	public void dropdown(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	/**
	 * These methods are used to handle the frames
	 */
	public void swithToFrame() {
		driver.switchTo().frame(0);
	}

	public void switchToBackFromFrame() {
		driver.switchTo().defaultContent();
	}

	/**
	 * this method is used to handle alert popUp
	 */
	public void handleAlert() {
		driver.switchTo().alert().accept();
	}

	/**
	 * this method is used to handle child browser popUp
	 */
	public void handleChildBrowser() {
		Set<String> WindowIDs = driver.getWindowHandles();
		for (String string : WindowIDs) {
			driver.switchTo().window(string);
		}
	}

	public void switchToParentWindow() {
		driver.switchTo().window(driver.getWindowHandle());
	}

	public void scrollToElement(WebElement element)
	/**
	 * This method is used to scroll element reference using scrollBars
	 */
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	public void takesScreenshot() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/picture.png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void explicitWait(long time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void closeCurrentWindow() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();

	}
}

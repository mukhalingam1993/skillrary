package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoreJavaVideoPage {
	
	//Declaration
	@FindBy(xpath="//h1")
	private WebElement pageHeader;
	@FindBy(xpath="//a[text()='X']")
	private WebElement closeCookies;
	@FindBy(xpath="//Button[@aria-label='Play']")
	private WebElement playButton;
	@FindBy(xpath="//Button[@aria-label='Pause']")
	private WebElement pauseButton;
	@FindBy(xpath="//span[text()='Add To Wishlist']")
	private WebElement addWishListTab;
	
	
	//Initialization
	public CoreJavaVideoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//Utilization
	public String getPageHeader()
	{
		return pageHeader.getText();
	}
	public void clickCloseCookies()
	{
		closeCookies.click();
	}
	public void clickPlayButton() {
		playButton.click();
	}
	public void clickPauseButton() {
		pauseButton.click();
	}
	public void clickAddWishListTab()
	{
		addWishListTab.click();
	}
}

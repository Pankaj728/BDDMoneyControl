package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Util.UtilClass;

public class MainPage  {
	WebDriver driver;
	public MainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH,using="//a[@href='javascript:;'and @class='icon']")
	public WebElement dropDown;
	@FindBy(how=How.XPATH,using="//div[@class='clearfix']/div[contains(@class,'title')]")
	public WebElement quickViewText;
	@FindBy(how=How.XPATH,using="//*[@id='lastStock']/div[1]/div[1]/p[1]/a")
	public WebElement firstRecodStockName;
	@FindBy(how=How.XPATH,using="//*[@id='lastStock']/div[1]/div[1]/p[2]/span[1]/strong")
	public WebElement firstRecordCurrentPrice;
	@FindBy(how=How.XPATH,using="//*[@id='lastStock']/div[1]/div[1]/p[2]/span[3]/strong")
	public WebElement firstRecordDeviation;
	@FindBy(how=How.XPATH,using="//*[@id='lastStock']/div[1]/div[1]/p[2]/span[5]")
	public WebElement firstRecordVolume;
	@FindBy(how=How.XPATH,using="//*//*[@id='lastStock']/div[1]/div[3]/div")
	public WebElement firstRecordNews;


	public void ClickOnDropDown() {
		System.out.println("Click on Drop Down");
		//driver.switchTo().defaultContent();
		dropDown.click();
		if(UtilClass.isDisplayed(driver, quickViewText)) 
		{
			System.out.println("Wizard expended sucessfully");
		}
		else
		{
			System.out.println("Wizard expended sucessfully");

		}
	}

	public void ClickOnFirstStock() 
	{ 
		String mainWindow=driver.getWindowHandle();
		System.out.println("current window"+mainWindow);
		if(UtilClass.isDisplayed(driver, firstRecodStockName)) 
		{
			firstRecodStockName.click();
			System.out.println("First record clicked");
		}
		else
		{
			System.out.println("First record not found");

		}

		UtilClass.SwitchToMainWindow(driver, mainWindow);
	}

	public void PrintDetails() {

		System.out.println("Stock Name for first record:---"+firstRecodStockName.getText());
		System.out.println("Current Price for first record:---"+firstRecordCurrentPrice.getText());
		System.out.println("Devation for first record:---"+firstRecordDeviation.getText());
		System.out.println("Volume for first record:---"+firstRecordVolume.getText());
		System.out.println("News for first record:---"+firstRecordNews.getText());
		
	}



}
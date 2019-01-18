package Pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Util.UtilClass;

public class Nifty_SensexPage {
	WebDriver driver;


	public Nifty_SensexPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how=How.XPATH,using="//*[@id=\"mc_mainWrapper\"]/div[3]/div[1]/div[4]/div[1]/strong")
	public WebElement Value;	
	@FindBy(how=How.XPATH,using="//*[@id=\"mc_mainWrapper\"]/div[3]/div[1]/div[4]/div[3]/strong")
	public WebElement Deviation;	
	@FindBy(how=How.XPATH,using="//*[@id=\"mc_mainWrapper\"]/div[3]/div[1]/div[4]/div[4]")
	public WebElement Percentage;
	@FindBy(how=How.XPATH,using="//*[@id=\"mc_mainWrapper\"]/div[3]/div[1]/p[1]")
	public WebElement Date;

	//	Method to get Value/Devation/Percentage from respective sites
	public ArrayList<String> GetDetails() {

		ArrayList<String> getText=new ArrayList<String>();
		if(UtilClass.isDisplayed(driver, Value)) {
			try 
			{
				getText.add(Date.getText());
				getText.add(Value.getText());
				getText.add(Deviation.getText());
				getText.add(Percentage.getText());
			}
			catch(Exception e) {
				System.out.println(e);
			}

		}return getText;
	}
}
package StepDefinition;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import org.openqa.selenium.WebDriver;

import Pages.BasePage;
import Pages.MainPage;
import Pages.Nifty_SensexPage;
import Util.UtilClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefination {
	public WebDriver driver;
	BasePage basePage;
	MainPage mainPage;
	Nifty_SensexPage niftySensexPage;
	String refresh="NIFTY";
	

	@Given("^User is already on \"([^\"]*)\" on \"([^\"]*)\" browser$")
	public void user_is_already_on_on_browser(String url, String browser) throws Throwable {
		basePage=new BasePage(driver);
		driver=basePage.launchBrowser(url,browser);
	}

	@When("^User clicks on drop down icon$")
	public void user_clicks_on_drop_down_icon()  {
		mainPage=new MainPage(driver);
		mainPage.ClickOnDropDown();
	}

	@When("^User Verifies Quick View section and takes snapshot$")
	public void user_Verifies_Quick_View_section_and_takes_snapshot() throws Exception  {
		UtilClass.takeSnapShot(driver) ;
	}


	@Then("^User Click on the first stock listed on the “Stocks in News” section and print the details$")
	public void user_Click_on_the_first_stock_listed_on_the_Stocks_in_News_section_and_print_the_details()  {
		mainPage.ClickOnFirstStock();
		mainPage.PrintDetails();
	}

	@Then("^close the browser$")
	public void close_the_browser()  {
		basePage.CloseBrowser();

	}


	@Given("^User is already on \"([^\"]*)\" page$")
	public void user_is_already_on_page(String url) {

		basePage=new BasePage(driver);
		driver=basePage.launchBrowser(url,"chrome");

	}
	@Then("^User saves data for respective sites$")
	public void user_saves_data_for_respective_sites() throws InterruptedException  {
		ArrayList<String> datalist;
		String actualfileName = UtilClass.getFileName(driver);
		niftySensexPage=new Nifty_SensexPage(driver);
		datalist =niftySensexPage.GetDetails();
		UtilClass.writeDataLineByLine(actualfileName, datalist);

	}


	@Then("^User saves data for respective sites for \"([^\"]*)\" Mins$")
	public void user_saves_data_for_respective_sites_for_Mins(int mins) throws InterruptedException  {

		System.out.println("in Method");

		int MINUTES = mins; // The delay in minutes
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("in Method");
				String actualfileName=null;
				try {
					basePage=new BasePage(driver);
					driver=basePage.launchBrowser("https://www.moneycontrol.com/sensex/bse/sensex-live","chrome");

					System.out.println("in try");
					actualfileName=UtilClass.getFileName(driver);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ArrayList<String> datalist;// Function runs every MINUTES minutes.
				niftySensexPage=new Nifty_SensexPage(driver);
				datalist =niftySensexPage.GetDetails();
				UtilClass.writeDataLineByLine(actualfileName, datalist);
			}
		}, 0, 1000 * 60 * MINUTES);
	}





}

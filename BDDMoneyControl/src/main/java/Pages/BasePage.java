package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;




import java.util.concurrent.TimeUnit;

public class BasePage {
	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver launchBrowser(String urlBase,String browser){
		if(browser.equalsIgnoreCase("chrome")){
			
			System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "Driver/geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
		driver.manage().window().maximize();
		driver.get(urlBase);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		System.out.println(driver.getTitle());
		driver.switchTo().defaultContent();
		return driver;

	}
	
	public void CloseBrowser() {
		driver.quit();
	
	}
}

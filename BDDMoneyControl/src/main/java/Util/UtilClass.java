package Util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencsv.CSVWriter;


public class UtilClass {
	WebDriver driver;
	static WebDriverWait wait;
	//static String snapshotPath="Screenshot/"+"Snap"+System.currentTimeMillis()+ ".png";
	public UtilClass(WebDriver driver) {
		this.driver = driver;
	}

	public static void takeSnapShot(WebDriver webdriver) throws Exception{

		//Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File("Screenshot/snapshot.png");
		FileUtils.copyFile(SrcFile, DestFile);

	}

	public static Boolean isDisplayed(WebDriver driver, WebElement ele) 
	{
		wait=new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.visibilityOf(ele));

		if(ele.isDisplayed()) 
		{

			return true;
		}
		else 
		{
			return false;
		}

	}

	public static void SwitchToMainWindow(WebDriver driver,String MainWindow) 
	{

		Set<String> s1=driver.getWindowHandles();		
		Iterator<String> i1=s1.iterator();		

		while(i1.hasNext())			
		{		
			driver.switchTo().window(MainWindow);
			break;

		}

	}



	public static void writeDataLineByLine(String filePath ,ArrayList<String> datalList) 
	{ 
		String[] finaldata =new String[6]; 

		for(int i=0;i<=6;i++) {
			if(i==0) {
				finaldata[0]="1";
			}
			else if(i==2) {
				String date= datalList.get(0);
				finaldata[1]=date;
			}

			else if(i==3) {

				String stockType = null;
				if(filePath.contains("SENSEX")) {
					stockType="S&P BSE SENSEX";
				}
				else if(filePath.contains("NIFTY")) {
					stockType="NIFTY  50";
				}
				finaldata[2]=stockType;

			}
			else if(i==4) {
				String value= datalList.get(1);
				finaldata[3]=value;
			}
			else if(i==5) {
				String deviation= datalList.get(2);
				finaldata[4]=deviation;
			}
			else if(i==6) {

				String Percentage= datalList.get(3);
				finaldata[5]=Percentage.substring(1, 5);
			}
		}


		File file = new File(filePath); 
		try { 

			FileWriter outputfile = new FileWriter(file); 
			CSVWriter writer = new CSVWriter(outputfile); 
			String[] header = { " SR# ", " Date time ", " Stock " ," Value "," Deviation "," Percentage "}; 
			writer.writeNext(header); 
			writer.writeNext(finaldata); 
			writer.close(); 
		} 
		catch (IOException e) { 
			e.printStackTrace(); 
		} 
	}

	public static String getFileName(WebDriver driver) throws InterruptedException{


		String currentURL=driver.getCurrentUrl();
		String fileName = null,filepath;
		Thread.sleep(2000);
		if (currentURL.contains("nifty")) {
			fileName="NIFTY 50.csv";
		}
		else if(currentURL.contains("sensex")) {
			fileName="S&P BSE SENSEX.csv";
		}
		filepath="src\\main\\java\\Util\\LiveData\\"+fileName;
		return filepath;
	}


}

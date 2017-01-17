package util;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>();
	
	@BeforeClass(alwaysRun=true)
	public void setUp(){
		 System.setProperty("webdriver.chrome.driver", "D:\\pavan\\chromedriver.exe");
		threadDriver.set(new ChromeDriver());
		threadDriver.get().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterClass(alwaysRun=true)
	public void tearDown(){
		if(getDriver() != null){
			getDriver().quit();
		}
	}
	
	public static WebDriver getDriver(){
		return threadDriver.get();
	}
}

package pageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class Test_POF {

	static WebDriver driver;

	// In order to use the PageFactory, first declare some fields on a
	// PageObject that are WebElements

	static WebElement log;

	static WebElement pwd;

	static WebElement submit;

	public static void main(String[] args) throws InterruptedException {

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://store.demoqa.com");

		// In order for this code to work and not throw a NullPointerException
		// because

		// the "log", "pwd" nd "submit" fields aren't instantiated, we need to
		// initialise the PageObject

		PageFactory.initElements(driver, Test_POF.class);

		// Once Instantiated, we can now use the above created WebElements

		log.sendKeys("testuser_1");

		pwd.sendKeys("Test@123");

		submit.click();

		driver.quit();

}

}
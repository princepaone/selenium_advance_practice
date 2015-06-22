package fileUpload;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class File_Upload_Working {

	String URL = "http://jpeg-optimizer.com/";

	public void testUpload() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"/Users/pavankumar_k11/Desktop/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.id("filename"));
		File file = new File("/Users/pavankumar_k11/Desktop/degree.jpg");
		element.sendKeys(file.getAbsolutePath());
		;
		// uploadFileUsingRobot("/Users/pavankumar_k11/Desktop/degree.jpg");
		Thread.sleep(2000);
		driver.findElement(By.name("Submit")).click();
	}
}

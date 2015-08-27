package fluentWait_And_Function;

import java.util.concurrent.TimeUnit;
//import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class Fun2 {
	public static void main(String[] args) throws InterruptedException {
		 
		WebDriver driver = new FirefoxDriver();
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
 

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(250,  TimeUnit.MILLISECONDS);
		wait.withTimeout(2, TimeUnit.MINUTES);
		wait.ignoring(NoSuchElementException.class); //make sure that this exception is ignored
		Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>()
				{
					public WebElement apply(WebDriver arg0) {
						System.out.println("Checking for the element!!");
						WebElement element = arg0.findElement(By.id("target"));
						if(element != null)
						{
							System.out.println("Target element found");
						}
						return element;
					}
		};
 
		wait.until(function);

		WebDriverWait driverWait = new WebDriverWait(driver, 10);
		WebElement element = driverWait.until(ExpectedConditions
				.presenceOfElementLocated(By.id("target")));
		element.click();
		
	}
 
}


package fluentWait_And_Function;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Predicate;

public class FluentWait_Using_Predicate {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new FirefoxDriver();
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		wait.withTimeout(2, TimeUnit.MINUTES);
		wait.ignoring(NoSuchElementException.class); // make sure that this
														// exception is ignored

		Predicate<WebDriver> predicate = new Predicate<WebDriver>() {

			public boolean apply(WebDriver arg0) {
				WebElement element = arg0.findElement(By.id("colorVar"));
				String color = element.getAttribute("color");
				System.out.println("The color if the button is " + color);
				if (color.equals("red")) {
					return true;
				}
				return false;
			}
		};
		wait.until(predicate);
	}
}

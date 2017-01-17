package eventListeners_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class EventFiringWebDriver_and_RegisteringEventHandler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FirefoxDriver driver = new FirefoxDriver();
		EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);

		EventHandler handler = new EventHandler();
		eventDriver.register(handler);
		// eventDriver
		// .get("http://www.toolsqa.com/automation-practice-switch-windows/");
		eventDriver.get("http://www.google.co.in");
		WebElement element = eventDriver.findElement(By.id("q"));
		element.click();

		eventDriver.unregister(handler);
	}

}

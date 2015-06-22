package objectRepositoryImplementationInSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		ProductListing_Page.Product_1.btn_AddToCart(driver).click();
	}
}

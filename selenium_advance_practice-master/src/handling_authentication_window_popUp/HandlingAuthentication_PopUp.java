package handling_authentication_window_popUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class HandlingAuthentication_PopUp {

	@Test
	public void testBasicAuth_Firefox() {

		WebDriver driver = new FirefoxDriver();

		driver.get("http://pavankumar_k11:password@sparshv2/Pages/Home.aspx");
		// To check if we have landed in the correct place


	}
}

package cookies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DeleteCookies {
	WebDriver driver;

	@Test
	public void deleteCookieNamedExample() {
		driver = new FirefoxDriver();
		String URL = "http://www.flipcart.com";
		driver.navigate().to(URL);
		driver.manage().deleteCookieNamed("__utmb");
	}

	@Test
	public void deleteAllCookiesExample() {
		driver = new FirefoxDriver();
		String URL = "http://www.flipcart.com";
		driver.navigate().to(URL);
		driver.manage().deleteAllCookies();
	}
	/*
	 * Delete Cookie Delete Cookie with Name Delete All Cookies
	 * 
	 * User can delete a cookie from the browser's "cookie jar". The domain of
	 * the cookie will be ignored.
	 * 
	 * User can delete the named cookie from the current domain. This is
	 * equivalent to setting the named cookie's expiry date to sometime in the
	 * past.
	 * 
	 * User can also delete all the cookies for the current domain using
	 * driver.manage().deleteAllCookies();
	 * 
	 * Example:
	 * 
	 * Deleting the specific cookie with cookie name "--utmb"
	 */
}

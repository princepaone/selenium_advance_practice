package cookies;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class AddingCookie {
	@Test
	public void addCookie() {
		WebDriver driver = new FirefoxDriver();
		String URL = "http://www.google.co.in";
		driver.navigate().to(URL);
		// we should pass name and value for cookie as parameters
		// In this example we are passing, name=mycookie and value=123456789123
		Cookie name = new Cookie("mycookie", "123456789123");
		driver.manage().addCookie(name);

		// After adding the cookie we will check that by displaying all the
		// cookies.
		Set<Cookie> cookiesList = driver.manage().getCookies();
		for (Cookie getcookies : cookiesList) {
			System.out.println(getcookies);
		}
	}
}
/*
 * Syntax:driver.manage().addCookie(arg0); Purpose: To add a specific cookie
 * into cookies. If the cookie's domain name is left blank, it is assumed that
 * the cookie is meant for the domain of the current document. Parameters:
 * cookie - The name and value of the cookie to be add.
 */
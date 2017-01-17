package singlePageFactoryIntoDiffPageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/*As My Account link and Log out link resides in the header of the webpage, 
 I always consider a Header as a part of Home Page.
 As it remain same throughout the application.*/
public class Home_PG_POF {

	final WebDriver driver;

	@FindBy(how = How.XPATH, using = ".//*[@id='account']/a")
	public WebElement lnk_MyAccount;

	@FindBy(how = How.XPATH, using = ".//*[@id='account_logout']/a")
	public WebElement lnk_LogOut;

	// This is a constructor, as every page need a base driver to find web
	// elements

	public Home_PG_POF(WebDriver driver)

	{

		this.driver = driver;

	}

}

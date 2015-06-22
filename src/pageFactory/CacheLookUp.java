package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CacheLookUp {

	@FindBy(how = How.ID, using = "userName")
	@CacheLookup
	// used to save time so that PageFactory do not look everytime when we turn
	// to webelement
	private WebElement txt_UserName;
}

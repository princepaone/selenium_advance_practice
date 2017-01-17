package checkBox;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckBox {
public static void main(String[] args) {
	
	try {
		WebDriver driver=new FirefoxDriver();
		String baseUrl="http://hedwig-uat.apple.com/pollyv2/index.php";
		driver.get(baseUrl);
		WebElement e3=driver.findElement(By.id("geo_id"));
			List<WebElement> l1 = driver
					.findElements(By
							.xpath(".//*[@id='polly_generate']/div[2]/div/input[contains(@type, 'checkbox')]"));
		System.out.println(l1.size());
			String s = "Append_Plan_Id";
		for(WebElement element:l1){
		System.out.println("inside1");
				System.out.println(element.getAttribute("value"));
				if (s.equalsIgnoreCase(element.getAttribute("value")))
		{
		element.click();
		System.out.println("inside");
		
		}
		WebElement e4=driver.findElement(By.id("generate_pg"));
				// e4.click();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
}

}
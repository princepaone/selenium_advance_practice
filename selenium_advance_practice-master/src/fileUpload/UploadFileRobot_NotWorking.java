package fileUpload;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadFileRobot_NotWorking {

	String URL = "http://jpeg-optimizer.com/";

	public void testUpload() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"/Users/pavankumar_k11/Desktop/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.id("filename"));
		File file = new File("/Users/pavankumar_k11/Desktop/degree.jpg");
		System.out.println(file.canRead());
		element.sendKeys(file.getAbsolutePath());
		;
		// uploadFileUsingRobot("/Users/pavankumar_k11/Desktop/degree.jpg");
		Thread.sleep(2000);
		driver.findElement(By.name("Submit")).click();
	}

	/**
	 * This method will set any parameter string to the system's clipboard.
	 */
	public static void setClipboardData(String string) {
		// StringSelection is a class that can be used for copy and paste
		// operations.
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard()
				.setContents(stringSelection, null);
	}

	public void uploadFileUsingRobot(String s) {
		/*
		 * KeyBoard board = null; try { board = new KeyBoard(); } catch
		 * (AWTException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } board.type(s);
		 */
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		robot.keyPress(KeyEvent.VK_SLASH);
		robot.keyRelease(KeyEvent.VK_SLASH);
		robot.keyPress(KeyEvent.VK_U);
		robot.keyRelease(KeyEvent.VK_U);
	}


	/*
	 * public static void uploadFile(String fileLocation) { try { // Setting
	 * clipboard with file location // setClipboardData(fileLocation); // native
	 * key strokes for CTRL, V and ENTER keys Robot r = new Robot();
	 * 
	 * r.keyPress(KeyEvent.VK_SLASH); r.keyRelease(KeyEvent.VK_SLASH);
	 * 
	 * r.keyPress(KeyEvent.VK_SHIFT); r.keyPress(KeyEvent.VK_U);
	 * r.keyRelease(KeyEvent.VK_SHIFT); r.keyRelease(KeyEvent.VK_U);
	 * 
	 * r.keyPress(KeyEvent.VK_S); r.keyRelease(KeyEvent.VK_S);
	 * 
	 * r.keyPress(KeyEvent.VK_E); r.keyRelease(KeyEvent.VK_E);
	 * r.keyPress(KeyEvent.VK_R); r.keyRelease(KeyEvent.VK_R);
	 * r.keyPress(KeyEvent.VK_S); r.keyRelease(KeyEvent.VK_S);
	 * 
	 * r.keyPress(KeyEvent.VK_SLASH); r.keyRelease(KeyEvent.VK_SLASH);
	 * 
	 * r.keyPress(KeyEvent.VK_P); r.keyRelease(KeyEvent.VK_P);
	 * r.keyPress(KeyEvent.VK_A); r.keyRelease(KeyEvent.VK_A);
	 * r.keyPress(KeyEvent.VK_V); r.keyRelease(KeyEvent.VK_V);
	 * r.keyPress(KeyEvent.VK_A); r.keyRelease(KeyEvent.VK_A);
	 * r.keyPress(KeyEvent.VK_N); r.keyRelease(KeyEvent.VK_N);
	 * 
	 * r.keyPress(KeyEvent.VK_K); r.keyRelease(KeyEvent.VK_K);
	 * r.keyPress(KeyEvent.VK_U); r.keyRelease(KeyEvent.VK_U);
	 * r.keyPress(KeyEvent.VK_M); r.keyRelease(KeyEvent.VK_M);
	 * r.keyPress(KeyEvent.VK_A); r.keyRelease(KeyEvent.VK_A);
	 * r.keyPress(KeyEvent.VK_R); r.keyRelease(KeyEvent.VK_R);
	 * r.keyPress(KeyEvent.VK_UNDERSCORE); r.keyRelease(KeyEvent.VK_UNDERSCORE);
	 * r.keyPress(KeyEvent.VK_K); r.keyRelease(KeyEvent.VK_K);
	 * r.keyPress(KeyEvent.VK_1); r.keyRelease(KeyEvent.VK_1);
	 * r.keyPress(KeyEvent.VK_1); r.keyRelease(KeyEvent.VK_1);
	 * 
	 * r.keyPress(KeyEvent.VK_SLASH); r.keyRelease(KeyEvent.VK_SLASH);
	 * r.keyPress(KeyEvent.VK_SHIFT); r.keyPress(KeyEvent.VK_D);
	 * r.keyRelease(KeyEvent.VK_SHIFT); r.keyRelease(KeyEvent.VK_D);
	 * r.keyPress(KeyEvent.VK_O); r.keyRelease(KeyEvent.VK_O);
	 * r.keyPress(KeyEvent.VK_C); r.keyRelease(KeyEvent.VK_C);
	 * r.keyPress(KeyEvent.VK_U); r.keyRelease(KeyEvent.VK_U);
	 * r.keyPress(KeyEvent.VK_M); r.keyRelease(KeyEvent.VK_M);
	 * r.keyPress(KeyEvent.VK_E); r.keyRelease(KeyEvent.VK_E);
	 * r.keyPress(KeyEvent.VK_N); r.keyRelease(KeyEvent.VK_N);
	 * r.keyPress(KeyEvent.VK_T); r.keyRelease(KeyEvent.VK_T);
	 * r.keyPress(KeyEvent.VK_S); r.keyRelease(KeyEvent.VK_S);
	 * r.keyPress(KeyEvent.VK_SLASH); r.keyRelease(KeyEvent.VK_SLASH);
	 * r.keyPress(KeyEvent.VK_SHIFT); r.keyPress(KeyEvent.VK_V);
	 * r.keyRelease(KeyEvent.VK_V); r.keyPress(KeyEvent.VK_I);
	 * r.keyRelease(KeyEvent.VK_I); r.keyPress(KeyEvent.VK_N);
	 * r.keyRelease(KeyEvent.VK_N); r.keyPress(KeyEvent.VK_C);
	 * r.keyRelease(KeyEvent.VK_C); r.keyPress(KeyEvent.VK_I);
	 * r.keyRelease(KeyEvent.VK_I); r.keyRelease(KeyEvent.VK_SHIFT);
	 * r.keyPress(KeyEvent.VK_UNDERSCORE); r.keyRelease(KeyEvent.VK_UNDERSCORE);
	 * r.keyPress(KeyEvent.VK_SHIFT); r.keyPress(KeyEvent.VK_T);
	 * r.keyRelease(KeyEvent.VK_SHIFT); r.keyRelease(KeyEvent.VK_T);
	 * r.keyPress(KeyEvent.VK_E); r.keyRelease(KeyEvent.VK_E);
	 * r.keyPress(KeyEvent.VK_S); r.keyRelease(KeyEvent.VK_S);
	 * r.keyPress(KeyEvent.VK_T); r.keyRelease(KeyEvent.VK_T);
	 * r.keyPress(KeyEvent.VK_UNDERSCORE); r.keyRelease(KeyEvent.VK_UNDERSCORE);
	 * r.keyPress(KeyEvent.VK_D); r.keyRelease(KeyEvent.VK_D);
	 * r.keyPress(KeyEvent.VK_O); r.keyRelease(KeyEvent.VK_O);
	 * r.keyPress(KeyEvent.VK_C); r.keyRelease(KeyEvent.VK_C);
	 * r.keyPress(KeyEvent.VK_U); r.keyRelease(KeyEvent.VK_U);
	 * r.keyPress(KeyEvent.VK_M); r.keyRelease(KeyEvent.VK_M);
	 * r.keyPress(KeyEvent.VK_E); r.keyRelease(KeyEvent.VK_E);
	 * r.keyPress(KeyEvent.VK_N); r.keyRelease(KeyEvent.VK_N);
	 * r.keyPress(KeyEvent.VK_T); r.keyRelease(KeyEvent.VK_T);
	 * r.keyPress(KeyEvent.VK_S); r.keyRelease(KeyEvent.VK_S);
	 * r.keyPress(KeyEvent.VK_SLASH); r.keyRelease(KeyEvent.VK_SLASH);
	 * r.keyPress(KeyEvent.VK_SHIFT); r.keyPress(KeyEvent.VK_T);
	 * r.keyRelease(KeyEvent.VK_SHIFT); r.keyRelease(KeyEvent.VK_T);
	 * r.keyPress(KeyEvent.VK_E); r.keyRelease(KeyEvent.VK_E);
	 * r.keyPress(KeyEvent.VK_S); r.keyRelease(KeyEvent.VK_S);
	 * r.keyPress(KeyEvent.VK_T); r.keyRelease(KeyEvent.VK_T);
	 * r.keyPress(KeyEvent.VK_UNDERSCORE); r.keyRelease(KeyEvent.VK_UNDERSCORE);
	 * r.keyPress(KeyEvent.VK_SHIFT); r.keyPress(KeyEvent.VK_R);
	 * r.keyRelease(KeyEvent.VK_SHIFT); r.keyRelease(KeyEvent.VK_R);
	 * r.keyPress(KeyEvent.VK_E); r.keyRelease(KeyEvent.VK_E);
	 * r.keyPress(KeyEvent.VK_S); r.keyRelease(KeyEvent.VK_S);
	 * r.keyPress(KeyEvent.VK_SHIFT); r.keyPress(KeyEvent.VK_R);
	 * r.keyRelease(KeyEvent.VK_SHIFT); r.keyRelease(KeyEvent.VK_R);
	 * r.keyPress(KeyEvent.VK_E); r.keyRelease(KeyEvent.VK_E);
	 * r.keyPress(KeyEvent.VK_Q); r.keyRelease(KeyEvent.VK_Q);
	 * r.keyPress(KeyEvent.VK_SHIFT); r.keyPress(KeyEvent.VK_M);
	 * r.keyRelease(KeyEvent.VK_SHIFT); r.keyRelease(KeyEvent.VK_M);
	 * r.keyPress(KeyEvent.VK_E); r.keyRelease(KeyEvent.VK_E);
	 * r.keyPress(KeyEvent.VK_M); r.keyRelease(KeyEvent.VK_M);
	 * r.keyPress(KeyEvent.VK_O); r.keyRelease(KeyEvent.VK_O);
	 * r.keyPress(KeyEvent.VK_PERIOD); r.keyRelease(KeyEvent.VK_PERIOD);
	 * r.keyPress(KeyEvent.VK_P); r.keyRelease(KeyEvent.VK_P);
	 * r.keyPress(KeyEvent.VK_D); r.keyRelease(KeyEvent.VK_D);
	 * r.keyPress(KeyEvent.VK_F); r.keyRelease(KeyEvent.VK_F);
	 * r.keyPress(KeyEvent.VK_ENTER); r.keyRelease(KeyEvent.VK_ENTER);
	 * 
	 * } catch (Exception exp) { exp.printStackTrace(); } }
	 */
	public static void main(String[] args) {
		UploadFileRobot_NotWorking fileRobot = new UploadFileRobot_NotWorking();
		try {
			fileRobot.testUpload();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

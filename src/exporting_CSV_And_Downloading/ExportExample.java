package exporting_CSV_And_Downloading;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExportExample {

	WebDriver driver;

	private static String downloadPath = "D:\\seleniumdownloads";
	private String URL = "appURL";

	@BeforeClass
	public void testSetup() throws Exception {
	    System.setProperty("webdriver.gecko.driver","E:\\geckodriver.exe");

		driver = new FirefoxDriver(firefoxProfile());
		driver.manage().window().maximize();
	}

	public static FirefoxProfile firefoxProfile() throws Exception {
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		firefoxProfile.setPreference("browser.download.folderList", 2);
		firefoxProfile.setPreference(
				"browser.download.manager.showWhenStarting", false);
		firefoxProfile.setPreference("browser.download.dir", downloadPath);
		firefoxProfile
				.setPreference(
						"browser.helperApps.neverAsk.saveToDisk",
						"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");

		return firefoxProfile;
	}

	@Test
	public void testExportAllRecords() throws InterruptedException {
		driver.get(URL);
		int noOfEntries = getNumberOfEntries();
		System.out.println("Total number of entries are :- " + noOfEntries);

		WebElement elementCSV = driver
				.findElement(By
						.xpath(".//*[@id='ToolTables_example_1']/span[contains(text(),'CSV')]"));
		elementCSV.click();

		File file = getLatestFilefromDir(downloadPath);
		String csvFileName = file.getName();
		System.out.println("CSV File Downloaded is :- " + csvFileName);

		System.out
				.println("Verifying number of entries with number of entries in csv");
		Assert.assertEquals(noOfEntries,
				getRecordsCountInCSV(downloadPath, csvFileName));
	}

	public int getNumberOfEntries() {

		String entriesTxt = driver.findElement(By.id("example_info")).getText()
				.trim();
		String[] aEntriesText = entriesTxt.split(" ");
		String totalEntriesText = aEntriesText[aEntriesText.length - 2];
		return Integer.parseInt(totalEntriesText);
	}

	public int getRecordsCountInCSV(String downloadPath, String csvFileName) {
		int lineNumberCount = 0;
		try {
			if (!csvFileName.isEmpty() || csvFileName != null) {
				String filePath = downloadPath
						+ System.getProperty("file.separator") + csvFileName;
				System.out.println(filePath);
				File file = new File(filePath);
				if (file.exists()) {
					System.out.println("File found :" + csvFileName);
					FileReader fr = new FileReader(file);
					LineNumberReader linenumberreader = new LineNumberReader(fr);
					while (linenumberreader.readLine() != null) {
						lineNumberCount++;
					}
					// To remove the header
					lineNumberCount = lineNumberCount - 1;
					System.out.println("Total number of lines found in csv : "
							+ (lineNumberCount));
					linenumberreader.close();
				} else {
					System.out.println("File does not exists");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return lineNumberCount;
	}

	private File getLatestFilefromDir(String dirPath) {
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}

		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}
}

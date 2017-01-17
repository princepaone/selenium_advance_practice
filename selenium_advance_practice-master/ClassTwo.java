package tests;

import org.testng.annotations.Test;

import util.TestBase;

public class ClassTwo extends TestBase {
	@Test
	public void testOne(){

		getDriver().get("https://www.google.co.in");
	}
	@Test(dependsOnMethods="testOne")
	public void testTwo(){
		
		getDriver().get("https://www.google.co.in");
	}
	@Test(dependsOnMethods="testTwo")
	public void test3(){

		getDriver().get("https://www.google.co.in");
	} 

}

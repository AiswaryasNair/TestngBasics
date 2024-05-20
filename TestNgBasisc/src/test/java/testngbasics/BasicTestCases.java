package testngbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicTestCases {

WebDriver driver;//set as global
	
	@BeforeMethod
	
	public void launchsection() {
		System.out.println(System.getProperty("user.dir"));
		WebDriverManager.chromedriver().setup();//equalent to system.setproperty
		driver=new ChromeDriver();
		
		driver.get("https://selenium.qabible.in/check-box-demo.php");
		driver.manage().window().maximize();
	}
	
	@Test
	public void VerifyChcekboxHeader() {
		WebElement header=driver.findElement(By.xpath("(//div[@class='card-header'])[2]"));
		String actual=header.getText();
		String Expectedresult="Single Checkbox Demo";
		Assert.assertEquals(actual, Expectedresult);
	}
	@Test
	public void Verifymultiplecheckbox() {
		WebElement header=driver.findElement(By.xpath("(//div[@class='card-header'])[3]"));
		String actual=header.getText();
		String Expectedresult="Multiple Checkbox Demo";
		Assert.assertEquals(actual, Expectedresult);
	}
	@Test
	public void VerifyChcekboxDisply() {
		WebElement header=driver.findElement(By.xpath("//input[@class='form-check-input']"));
		boolean status = header.isDisplayed();
		//Assert.assertEquals(status, true);
		//OR case of boolean
		Assert.assertTrue(status);// or Assert.assertTrue(header.isDisplayed()); Or
		//Assert.assertFalse(status,"Checkbox verification failed");//message is displyed in report after fail the testcase
	}
	
	@AfterMethod
	public void Aftermethod() {
		
		driver.quit();
		
	}
}

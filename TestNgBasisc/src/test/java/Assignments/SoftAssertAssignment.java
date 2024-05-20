package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertAssignment {

WebDriver driver;//set as global
SoftAssert softassert=new SoftAssert();
	
	@BeforeMethod
	
	public void launchsection() {
		WebDriverManager.chromedriver().setup();//equalent to system.setproperty
		driver=new ChromeDriver();
		driver.get("https://selenium.qabible.in/bootstrap-alert.php");
		driver.manage().window().maximize();
	}
	
	@Test
	public void verifybootstrap() {
		
		WebElement bootstrapheader=driver.findElement(By.xpath("(//div[@class='card-header'])[2]"));
		String actual=bootstrapheader.getText();
		String expected="Bootstrap Alert";
		softassert.assertEquals(actual, expected);
		WebElement bgcolor=driver.findElement(By.xpath("//button[@id='autoclosable-btn-success']"));
		String actualcolor=bgcolor.getCssValue("background-color");
		String expectedcolor="rgba(40, 167, 69, 1)";
		softassert.assertEquals(actualcolor,expectedcolor);
		softassert.assertAll();
	}
	@AfterMethod

	public void Aftermethod() {

		driver.quit();
	}
}

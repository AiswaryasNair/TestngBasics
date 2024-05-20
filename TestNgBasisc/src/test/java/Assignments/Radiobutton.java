package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Radiobutton {

	WebDriver driver;// set as global

	@BeforeMethod

	public void launchsection() {
		WebDriverManager.chromedriver().setup();// equalent to system.setproperty
		driver = new ChromeDriver();

		driver.get("https://selenium.qabible.in/radio-button-demo.php");
		driver.manage().window().maximize();
	}

	//invocationCount - run the same testcase
	@Test(priority = 2/* ,invocationCount = 3 */)

	public void verifyradiobuttonEnabled() {

		WebElement maleradiobtn = driver.findElement(By.xpath("//input[@id='inlineRadio1']"));
		boolean status = maleradiobtn.isEnabled();
		Assert.assertFalse(status);//hard assert when the exception is thrown the next assert is not considered,when the multiple asserts ina single testcase
		//soft assert - multiple asserts are possible
		System.out.println("hello");
	}
	//enabled=false - skip the testcase
	//dependsonmethod= if the depended method is failed the related testcase is skipped
	@Test(priority=1,enabled=true,dependsOnMethods = "verifyradiobuttonEnabled")
	public void verifyradiobuttonselected() {

		WebElement femaleradiobtn = driver.findElement(By.xpath("//input[@id='inlineRadio2']"));
		femaleradiobtn.click();
		boolean status = femaleradiobtn.isSelected();
		Assert.assertTrue(status);
	}

	@AfterMethod

	public void Aftermethod() {

		driver.quit();
	}
}

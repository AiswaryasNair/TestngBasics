package Assignments;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import testngbasics.DataProviderss;

public class DataProviderSearch {

	WebDriver driver;// set as global

	@BeforeMethod

	public void launchsection() {
		WebDriverManager.chromedriver().setup();// equalent to system.setproperty
		driver = new ChromeDriver();
		driver.get("https://selenium.qabible.in/table-filter.php");
		driver.manage().window().maximize();
	}

	@Test(dataProvider = "TableData", dataProviderClass = DataProviderss.class)
	public void VerifyTableHeader(String name) throws InterruptedException {

		WebElement searchfield = driver.findElement(By.xpath("//input[@type='search']"));
		searchfield.sendKeys(name);
		Thread.sleep(5000);
		WebElement next = driver.findElement(By.xpath("//div[@id='example_info']"));
		String actual=next.getText();
		String expected="Showing 1 to 1 of 1 entries (filtered from 57 total entries)";
		Assert.assertEquals(actual, expected);
	}

	@AfterMethod

	public void Aftermethod() {

		driver.quit();
	}
}

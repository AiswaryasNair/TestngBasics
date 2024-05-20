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
import testngbasics.DataProviderss;

public class Dataprovider6D {

	WebDriver driver;// set as global

	@BeforeMethod

	public void launchsection() {
		WebDriverManager.chromedriver().setup();// equalent to system.setproperty
		driver = new ChromeDriver();
		driver.get("https://selenium.qabible.in/form-submit.php");
		driver.manage().window().maximize();
	}

	@Test(dataProvider = "Form", dataProviderClass = DataProviderss.class)
	public void VerifyTableHeader(String firstn,String lastn,String user,String cities,String states,String zips) throws InterruptedException {

		WebElement firstname = driver.findElement(By.xpath("//input[@id='validationCustom01']"));
		firstname.sendKeys(firstn);
		WebElement lastname = driver.findElement(By.xpath("//input[@id='validationCustom02']"));
		lastname.sendKeys(lastn);
		WebElement username = driver.findElement(By.xpath("//input[@id='validationCustomUsername']"));
		username.sendKeys(user);
		WebElement city = driver.findElement(By.xpath("//input[@id='validationCustom03']"));
		city.sendKeys(cities);
		WebElement state = driver.findElement(By.xpath("//input[@id='validationCustom04']"));
		state.sendKeys(states);
		WebElement zip = driver.findElement(By.xpath("//input[@id='validationCustom05']"));
		zip.sendKeys(zips);
		WebElement checkbox=driver.findElement(By.xpath("//input[@class='form-check-input']"));
		checkbox.click();
		WebElement submitbtn = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		submitbtn.click();
		Thread.sleep(5000);
		WebElement msg = driver.findElement(By.xpath("//div[@id='message-one']"));
		String actual=msg.getText();
		String expected="Form has been submitted successfully!";
		Assert.assertEquals(actual, expected);
	}

	@AfterMethod

	public void Aftermethod() {

		driver.quit();
	}
}

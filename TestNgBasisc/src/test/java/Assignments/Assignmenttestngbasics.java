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

public class Assignmenttestngbasics {

	WebDriver driver;// set as global

	@BeforeMethod

	public void launchsection() {
		WebDriverManager.chromedriver().setup();// equalent to system.setproperty
		driver = new ChromeDriver();

		driver.get("https://selenium.qabible.in/simple-form-demo.php");
		driver.manage().window().maximize();
	}

	@Test

	public void verifyShowMsgText() {

		WebElement showmsgbtntext = driver.findElement(By.xpath("//button[@id='button-one']"));
		String actual = showmsgbtntext.getText();
		String Expected = "Show Message";
		Assert.assertEquals(actual, Expected);
	}

	@Test

	public void Verifymsgtext() {

		WebElement showmsgbtntext = driver.findElement(By.xpath("//label[text()='Enter Message']"));
		String actual = showmsgbtntext.getText();
		String Expected = "Enter Message";
		Assert.assertEquals(actual, Expected);
	}

	@Test
	public void verifyMsg() {
		WebElement msg = driver.findElement(By.xpath("//input[@id='single-input-field']"));
		msg.sendKeys("Aiswarya");
		WebElement showmsgbtn = driver.findElement(By.xpath("//button[@id='button-one']"));
		showmsgbtn.click();
		WebElement yourmsg = driver.findElement(By.xpath("//div[@id='message-one']"));
		String actual = yourmsg.getText();
		String Expected = "Your Message : Aiswarya";
		Assert.assertEquals(actual, Expected);
		
	}
	@AfterMethod

	public void Aftermethod() {

		driver.quit();
	}
}

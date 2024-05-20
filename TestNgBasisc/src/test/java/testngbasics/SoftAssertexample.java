package testngbasics;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertexample {

	WebDriver driver;// set as global
	SoftAssert softassert=new SoftAssert();
	@BeforeMethod

	public void launchsection() {
		WebDriverManager.chromedriver().setup();// equalent to system.setproperty
		driver = new ChromeDriver();

		driver.get("https://selenium.qabible.in/window-popup.php");
		driver.manage().window().maximize();
	}
	@Test
	public void verifybuttontextAndTooltip() {
		
		WebElement likeusonfacebooktxt = driver.findElement(By.xpath("//a[@class='btn btn-primary windowSingle']"));
		String actualtext=likeusonfacebooktxt.getText();
		String expectedtext="Like us On Facebook";
		softassert.assertEquals(actualtext, expectedtext);
		WebElement tooltip = driver.findElement(By.xpath("//a[@class='btn btn-primary windowSingle']"));
		String actualtooltip = tooltip.getAttribute("title");
		String expectedtooltip="Follow @obsqurazone on Faceboo66";
		softassert.assertEquals(actualtooltip, expectedtooltip);
		softassert.assertAll();//imp - for showing in the report
	}
	@AfterMethod

	public void Aftermethod() {

		driver.quit();
	}
}

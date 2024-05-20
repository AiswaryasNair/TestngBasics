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

public class SoftAssert2 {

	WebDriver driver;// set as global
	SoftAssert softassert = new SoftAssert();

	@BeforeMethod

	public void launchsection() {
		WebDriverManager.chromedriver().setup();// equalent to system.setproperty
		driver = new ChromeDriver();
		driver.get("https://selenium.qabible.in/table-pagination.php");
		driver.manage().window().maximize();
	}

	@Test
	public void VerifyTableHeader() {

		WebElement header = driver.findElement(By.xpath("(//div[@class='card-header'])[2]"));
		String actual = header.getText();
		String expected = "Table with Pagination Example";
		softassert.assertEquals(actual, expected);
		WebElement data = driver.findElement(By.xpath("//table[@id='dtBasicExample']//tbody//tr[1]//td[1]"));
		softassert.assertTrue(data.isDisplayed());

	}

	@AfterMethod

	public void Aftermethod() {

		driver.quit();
	}
}

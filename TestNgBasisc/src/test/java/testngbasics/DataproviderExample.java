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

public class DataproviderExample {

	WebDriver driver;// set as global
	SoftAssert softassert=new SoftAssert();
	@BeforeMethod

	public void launchsection() {
		WebDriverManager.chromedriver().setup();// equalent to system.setproperty
		driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	}
	//single dimensional dataprovider //run 5times(5products)
	@Test(dataProvider = "Amazonproductlist",dataProviderClass = DataProviderss.class)
	public void verifyAmazonproduct(String product) {
		
		WebElement serchproduct = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		serchproduct.sendKeys(product);
		System.out.println(product);
		WebElement searchbtn = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		searchbtn.click();
		
	}
	//2D dataprovider
	@Test(dataProvider = "Facebooklogin",dataProviderClass = DataProviderss.class)
	public void VerifyFacebooklogin(String usernames,String passwords) {
		driver.get("https://www.facebook.com/");
		WebElement username = driver.findElement(By.xpath("//input[@class='inputtext _55r1 _6luy']"));
		username.sendKeys(usernames);
		WebElement password = driver.findElement(By.xpath("//input[@class='inputtext _55r1 _6luy _9npi']"));
		password.sendKeys(passwords);
		WebElement loginbtn = driver.findElement(By.xpath("//button[@class='_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy']"));
		loginbtn.click();
	}
	@AfterMethod

	public void Aftermethod() {

		driver.quit();
	}
}

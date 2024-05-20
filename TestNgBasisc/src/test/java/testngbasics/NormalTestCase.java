package testngbasics;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NormalTestCase {
	
	WebDriver driver;//set as global
	
	@BeforeMethod
	
	public void launchsection() {
		WebDriverManager.chromedriver().setup();//equalent to system.setproperty
		driver=new ChromeDriver();
		// OR
		//WebDriverManager.edgedriver().setup();
		//driver=new EdgeDriver();
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	}

	@Test
	public void verifyAmazonTitle() {
		String actualresult=driver.getTitle();
		String expected ="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		Assert.assertEquals(actualresult, expected);
		//System.out.println(driver.getTitle());
		
	}
	@Test
	public void verifyurl() {
		String actualresult=driver.getCurrentUrl();
		String expected ="https://www.amazon.in/";
		Assert.assertEquals(actualresult, expected);
				
	}
	
}

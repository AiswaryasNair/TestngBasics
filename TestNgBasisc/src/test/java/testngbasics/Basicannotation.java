package testngbasics;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Basicannotation {

	@BeforeSuite
	public void beforesuites() {
		System.out.println("run before suite");
	}
	
	@BeforeMethod
	
	public void beforemethods() {
		System.out.println("run before methods");
	}
	
	@AfterMethod
	public void aftermethods() {
		System.out.println("run after methods");
	}
	
	@BeforeTest
	public void beforeTests() {
		System.out.println("run before test");
	}
	
	@AfterTest
	public void aftertest() {
		System.out.println("run after test");
	}
	
	@AfterSuite
	
	public void aftersuites() {
		System.out.println("run before methods");
	}
	
	@BeforeClass
	public void beforeclass() {
		System.out.println("run after suites");
	}
	
	@AfterClass
	public void afterclass() {
		System.out.println("run after class");
	}
	@Test
	public void TestCase1() {
		System.out.println("run testcase1");
	}
	
	@Test
	public void TestCase2() {
		System.out.println("run testcase2");
	}
}

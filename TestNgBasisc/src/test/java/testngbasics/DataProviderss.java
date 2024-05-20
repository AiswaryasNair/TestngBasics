package testngbasics;

import org.testng.annotations.DataProvider;

public class DataProviderss {

	@DataProvider(name="Amazonproductlist")
	public Object[][] Amazonproductlist()
	{
		return new Object [][] {{"shoes"},{"watch"},{"phone"},{"hairband"},{"frames"}};
	}
	
	@DataProvider(name="Facebooklogin")
	public Object[][] Facebookloginmethod()
	{
		return new Object [][] {{"username1","pswd1"},{"username2","pswd2"}};
	}
	
	@DataProvider(name="TableData")
	public Object[][] tableDataMethod()
	{
		return new Object [][] {{"Airi Satou"},{"Brenden Wagner"},{"Cedric Kelly"},{"Bruno Nash"}};
	}
	
	@DataProvider(name="Form")
	public Object[][] formDataMethod()
	{
		return new Object [][] {{"Aiswarya","Ravi","ais","xyz","Kerala","78900"},{"Brenden","Wagner","RRR","abcd","tamilnadu","90877"}};
	}
}

package testCases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.FlipkartSearch;
import testBase.BaseClass;

public class TC001_FlipkartSearch extends BaseClass{
	
	@Test()

	public void flipkart_search() 
	{
		
		FlipkartSearch ams=new FlipkartSearch(driver);
		ams.search("Lipstick");
		ams.searchclick();
//		ams.addcart();
//		ams.validation("NANCY AJRAM X 12 Color Book Lip Gloss Set Liquid Lipstick Set");
	}

}

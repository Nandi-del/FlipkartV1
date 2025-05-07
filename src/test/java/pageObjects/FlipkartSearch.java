package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class FlipkartSearch extends BasePage {
	
	public FlipkartSearch(WebDriver driver)
	{
		super(driver);
		
	}
@FindBy(xpath="//input[@class='Pke_EE']")
WebElement search;
@FindBy(xpath="//a[contains(@title,'NANCY AJRAM X 12 Color')]")
WebElement search_click;
//@FindBy(xpath="//li[@class='col col-6-12 ']") //li[@class='col col-6-12 ']//button
//WebElement btn_addtocart;
//@FindBy(xpath="//div[@class='gE4Hlh']//a")
//WebElement test;

public void search(String st)
{
	search.sendKeys(st);
	Actions a=new Actions(driver);
	a.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
}
public void searchclick()
{
	search_click.click();
}
//public void addcart() throws Exception
//{
//	Thread.sleep(4000);
//	btn_addtocart.click();
//}
//public void validation(String s)
//{
//	String s1=test.getText();
//	if(s1.equals(s))
//	{
//		Assert.assertTrue(true);
//	}
//	else
//		Assert.assertFalse(false);
//}

}

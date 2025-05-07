package testBase;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
public WebDriver driver;
Properties p;

@BeforeClass
@Parameters({"browser","os"})
public void setUp(String s, String os) throws Exception
{
	FileInputStream fis=new FileInputStream("E:\\Selenium_np\\FlipkartV1\\src\\test\\resources\\Basic_Prop.properties");
	p=new Properties();
	p.load(fis);
	
	if((p.getProperty("exe_env")).equalsIgnoreCase("local"))
	{
	switch(s)
	{
		case "chrome": driver=new ChromeDriver();
								break;
		case "edge": driver=new EdgeDriver();
						break;
		default: System.out.println("Wrong browser name");
			return;
		
	}
	}
	else if(p.getProperty("exe_env").equalsIgnoreCase("remote"))
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		
		//os
			dc.setPlatform(Platform.WIN10);
		
		//browser
		switch(s)
		{
		case "chrome": dc.setBrowserName("chrome");
					break;
		case "edge": dc.setBrowserName("MicrosoftEdge");
					break;
		default: System.out.println("browser name is invalid");
				return;
		
		}
		driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);
	}
	
	//driver.manage().deleteAllCookies();
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	driver.get("https://www.flipkart.com/");
	driver.manage().window().maximize();
}
@AfterClass
public void close()
{
	driver.quit();
}

}

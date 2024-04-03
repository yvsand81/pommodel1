package regression;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class setup {


	WebDriver driver;
	Properties prop = new Properties();
	
	@BeforeClass
	public void Initalization() throws IOException, InterruptedException
	{
FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\Properties\\config.properties");
		
		prop.load(fis);
				
		driver = new ChromeDriver(); // rtp

		driver.get(prop.getProperty("QA_Url"));

		driver.manage().window().maximize(); // Maximize the browser

		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@title='Allow all cookies']")).click();

		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	}
	
	@AfterClass
	public void CleanUp()
	{
		driver.quit();
	}


}



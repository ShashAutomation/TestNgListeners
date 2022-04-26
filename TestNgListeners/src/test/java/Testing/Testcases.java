package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class Testcases {
	@Listeners(TestNgListener.Listenerdemo.class)
	public class TestCases {
	WebDriver driver;
	@BeforeMethod
	public void launchChrome()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\lib\\Chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com/");
	}
	@Test(priority=1)
	public void googleTitleTest()
	{
		
		
			
			String title=driver.getTitle();
			System.out.println(title);
			Assert.assertEquals(title, "Google");
			
		}
	@Test(priority=2)
	public void displayTest()
	{
		WebElement b=driver.findElement(By.linkText("Signin"));
		b.isDisplayed();
		String n=b.getText();
		System.out.println(n);
		if(n.equalsIgnoreCase("Sign in"))
		{
			System.out.println("is displayed");
		}
		else
		{
			System.out.println("not displayed");
		}
	}
	@Test(priority=3,dependsOnMethods="displayTest")
	public void enalbleTest()
	{
		driver.navigate().to("https://www.instagram.com/?hl=en");
		boolean b =driver.findElement(By.xpath("//button[@class='sqdOP  L3NKy   y3zKF     ']")).isEnabled();
		Assert.assertTrue(b);
	}
	@Test(priority=4,successPercentage=40)
	public void facebokTitleTest()
	{
		driver.navigate().to("https://www.facebook.com/");
		System.out.println(driver.getTitle());
		
	}
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
}
}
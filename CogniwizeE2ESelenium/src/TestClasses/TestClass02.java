package TestClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestClass02 {
	
	WebDriver driver = null;
  @Test
  public void googleTitle() throws InterruptedException {
	  
	  System.setProperty("webdriver.chrome.driver",
				"./Driver/chromedriver.exe");
		driver = new ChromeDriver(); // Launch the chrome browser
	  driver.get("https://www.google.com/"); //open url
		Thread.sleep(2000); 
		
		//verify title
		String expTitle = "Google";
		String actTitle = driver.getTitle();
		System.out.println("expTitle "+expTitle);
		System.out.println("actTitle "+actTitle);
		if(expTitle.equals(actTitle))
		{
			System.out.println("Testcase pass");
		}
		else
		{
			System.out.println("Testcase fail");
		}
		driver.close();//close browser
  }
}

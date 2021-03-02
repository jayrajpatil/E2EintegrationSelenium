package TestClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewTest {
	
	WebDriver driver = null;
  @Test
  public void f() {
	  
	  System.setProperty("webdriver.chrome.driver",
				"./Driver/chromedriver.exe");
		driver = new ChromeDriver(); // Launch the chrome browser
		
		driver.close();
  }
}

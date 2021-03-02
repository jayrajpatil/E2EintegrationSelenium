package TestClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestClass01 {

	WebDriver driver = null;

	@Test
	public void addEmpOHRM() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // Implicit wait

		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");

		// login to orhm
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin"); // relative xpath
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("admin123");

		driver.findElement(By.xpath("//input[@class='button' and @name='Submit']")).click();
		Thread.sleep(2000);
		// Check if login is successful
		Boolean flag = driver.getPageSource().contains("Dashboard");
		if (flag) {
			System.out.println("Login successful");
		} else {
			System.out.println("Login failed");
		}

		// PIM
		driver.findElement(By.linkText("PIM")).click();
		Thread.sleep(2000); // just to observe
		driver.findElement(By.linkText("Add Employee")).click();
		Thread.sleep(2000); // just to observe

		// Add emp
		driver.findElement(By.id("firstName")).sendKeys("abc1");
		driver.findElement(By.id("lastName")).sendKeys("l");
		driver.findElement(By.id("chkLogin")).click();
		driver.findElement(By.id("user_name")).sendKeys("abc11111");
		driver.findElement(By.id("user_password")).sendKeys("abc11111");
		driver.findElement(By.id("re_password")).sendKeys("abc11111");
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(2000); // just to observe

		// Checkpoint-1 Add employee ----Check the presence of element
		int size = driver.findElements(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/h1")).size();
		if (size > 0) {
			System.out.println("Test case pass. Personal details element is present. Employee added successfully.");

			// Checkpoint-2 Check if employee name is correct - check text

			String actText = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/div/h1")).getText();
			String expText = "abc1 l";
			if (actText.equals(expText)) {
				System.out.println("Test case-2 pass. Employee name is correct.");
			} else {
				System.out.println("Test case-2 failed. Employee name is not correct.");
			}

		} else {
			System.out.println(
					"Test case fail. Personal details element is NOT present. Employee has not been added successfully.");
		}

		Thread.sleep(1000);

		// Logout
		driver.findElement(By.xpath("//*[@id='welcome']")).click();

		Thread.sleep(2000);

		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(2000);
		driver.close();

	}
}

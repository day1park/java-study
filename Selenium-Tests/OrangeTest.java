import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class OrangeTest {

	@Test
	public void orangetest() throws InterruptedException, AWTException, IOException {
		
		// change these variables every time you run the test
		String username1 = "testername";
		String jobtitle1 = "testerjob";
		String screenshot1 = "testershot.jpg";
		String screenshot2 = "testershot2.jpg";
		

		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\1745772\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Robot robot = new Robot();
		
		//sign in
		driver.findElement(By.xpath("//*[@id='txtUsername']")).click();
		Thread.sleep(2500);
		driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys("Admin");
		Thread.sleep(2500);
		driver.findElement(By.xpath("//*[@id='txtPassword']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("admin123");
		Thread.sleep(2500);
		driver.findElement(By.xpath("//*[@id='btnLogin']")).click();
		Thread.sleep(2500);
		
		//navigate to admin to create user
		driver.findElement(By.xpath("//*[@id='menu_admin_viewAdminModule']")).click();
		Thread.sleep(2500);
		driver.findElement(By.xpath("//*[@id='btnAdd']")).click();
		Thread.sleep(1500);
		Select role = new Select(driver.findElement(By.name("systemUser[userType]")));
		Thread.sleep(1000);
		role.selectByVisibleText("Admin");
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id='systemUser_employeeName_empName']")).sendKeys("fiona");
		Thread.sleep(1500);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1500);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1500);
		
		driver.findElement(By.xpath("//*[@id='systemUser_userName']")).sendKeys(username1);
		Thread.sleep(1500);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id='systemUser_password']")).sendKeys("this.isAStr0ng1!!!");
		Thread.sleep(1500);
		robot.keyPress(KeyEvent.VK_TAB);
		driver.findElement(By.xpath("//*[@id='systemUser_confirmPassword']")).sendKeys("this.isAStr0ng1!!!");
		Thread.sleep(2500);
		driver.findElement(By.xpath("//*[@id='btnSave']")).click();
		Thread.sleep(3000);
		
//		//select user to delete
		WebElement name = driver.findElement(By.xpath("//*[@id='resultTable']/tbody"));
		Thread.sleep(2000);
		List<WebElement> columns = name.findElements(By.tagName("tr"));
		for (WebElement cell : columns) {
			System.out.println(cell.getText());
			if (cell.getText().equals(username1 + " Admin Fiona Grace Enabled")) {
				System.out.println(cell.getText());
				cell.findElement(By.name("chkSelectRow[]")).click();
				Thread.sleep(2000);
				break;
			}
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='btnDelete']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='dialogDeleteBtn']")).click();
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		java.io.File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
		java.io.File destFile = new java.io.File("C:\\Users\\1745772\\Desktop\\"+screenshot1);
		FileUtils.copyFile(scrFile, destFile);
		Thread.sleep(3000);

		//search for deleted user
		driver.findElement(By.xpath("//*[@id='searchSystemUser_userName']")).click();
		Thread.sleep(2500);
		driver.findElement(By.xpath("//*[@id='searchSystemUser_userName']")).sendKeys(username1);
		Thread.sleep(2500);
		driver.findElement(By.xpath("//*[@id='searchBtn']")).click();
		Thread.sleep(2500);

		// create job title
		driver.findElement(By.xpath("//*[@id='menu_admin_viewAdminModule']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id='menu_admin_Job']")).click();
		Thread.sleep(2500);
		driver.findElement(By.xpath("//*[@id='menu_admin_viewJobTitleList']")).click();
		Thread.sleep(2500);
		driver.findElement(By.xpath("//*[@id='btnAdd']")).click();
		Thread.sleep(2500);
		driver.findElement(By.xpath("//*[@id='jobTitle_jobTitle']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='jobTitle_jobTitle']")).sendKeys(jobtitle1);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		driver.findElement(By.xpath("//*[@id='jobTitle_jobDescription']")).sendKeys("firebending is a skill");
		
		StringSelection filePath = new StringSelection("C:\\Users\\1745772\\Desktop\\"+screenshot1);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3500);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3500);
		driver.findElement(By.xpath("//*[@id='btnSave']")).click();
		Thread.sleep(2500);

		// edit job title
		driver.findElement(By.partialLinkText(jobtitle1)).click();
		Thread.sleep(2500);
		driver.findElement(By.xpath("//*[@id='btnSave']")).click();
		Thread.sleep(2500);
		driver.findElement(By.xpath("//*[@id='jobTitle_note']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id='jobTitle_note']")).sendKeys("galaxy note 10");
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id='btnSave']")).click();
		Thread.sleep(2000);
		TakesScreenshot scrShot2 = ((TakesScreenshot)driver);
		java.io.File scrFile2 = scrShot2.getScreenshotAs(OutputType.FILE);
		java.io.File destFile2 = new java.io.File("C:\\Users\\1745772\\Desktop\\"+screenshot2);
		FileUtils.copyFile(scrFile2, destFile2);
		Thread.sleep(3000);


		driver.close();
		
	}
}

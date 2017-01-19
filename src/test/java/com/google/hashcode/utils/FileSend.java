package test;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileSend {
	
	private static String login = "jersi28";
	private static String password = "****";
	public static WebDriver driver;
	
	 public static void main( String[] args ){  
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http:/google.com");
		driver.findElement(By.id("gb_70")).click();
		driver.findElement(By.id("Email")).sendKeys(login);
		driver.findElement(By.id("next")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.id("Passwd")).sendKeys(password);
		driver.findElement(By.id("signIn")).click();
		driver.get("https://hashcodejudge.withgoogle.com/#/rounds/6553823069863936/submissions/");
		Point coordinates = driver.findElement(By.xpath("//button[@ng-click='submissionsCtrl.showNewSubmissionForm = true']")).getLocation();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		try {
			Robot robot = new Robot();
			robot.mouseMove(coordinates.getX(),coordinates.getY()+120);
			robot.mousePress(1);
			// todo: teach Robot press right buttons or find other way to outwit angular ....
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		driver.close();  
//		driver.quit();
	}
}

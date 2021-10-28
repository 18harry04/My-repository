import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Endtoendtesting 
{

	public static void main(String[] args) throws InterruptedException 
	{
		String brandtoselect = "Samsung galaxy s7"; //Give the brand name
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\harsh\\OneDrive\\Desktop\\UDEMY\\chromedriver.exe"); // add local path
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.demoblaze.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.id("login2")).click();
		driver.findElement(By.id("loginusername")).sendKeys("Harshith");
		driver.findElement(By.id("loginpassword")).sendKeys("Australia@2020");
		driver.findElement(By.xpath("//button[@onclick = 'logIn()']")).click();

		List<WebElement> productnames =  driver.findElements(By.xpath("//div[@class = 'card h-100']/div/h4/a")); //fetch all brandnames

		for(int i =0; i < productnames.size(); i++)
		{

		String name = productnames.get(i).getText();
		if(name.equals(brandtoselect))

		{
		System.out.println(name);
		Thread.sleep(10000);
		driver.findElements(By.xpath("//h4[@class = 'card-title']/a")).get(i).click();
		driver.findElement(By.xpath("//a[@class = 'btn btn-success btn-lg']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.alertIsPresent());

		driver.switchTo().alert().accept();
		driver.findElement(By.id("cartur")).click();
		}

	    }
	}
}



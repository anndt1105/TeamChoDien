import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestChap12_Alert {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//find and set driver
		System.setProperty("webdriver.chrome.driver","E:\\Thuy\\Auto\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
//		System.setProperty("webdriver.gecko.driver", "E:\\Thuy\\Auto\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		
		String baseURL="https://www.webtoolnavi.com/demo/sweetalert2/";
		
		driver.get(baseURL);
		
		//find button Try Me
		WebElement btnTryMe = driver.findElement(By.xpath("//*[@id=\"chaining-modals\"]/button"));
		btnTryMe.click();
		
		driver.switchTo().window(driver.getWindowHandle()).findElement(By.xpath("/html/body/div[2]/div[2]/button[1]")).click();
		//Step 1
		//driver.findElement(By.xpath("/html/body/div[2]/div[2]/button[1]")).click();
		//Step 2
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/button[1]")).click();
		//Step 3
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/button[1]")).click();
		
	}

}

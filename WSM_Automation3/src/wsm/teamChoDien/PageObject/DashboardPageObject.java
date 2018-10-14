package wsm.teamChoDien.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPageObject {
	private static WebElement element = null;
	
	//Find Element of Personal Request 
	//Find button Personal request
	public static WebElement btn_personalRequest(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"sidebar-scroll\"]/div/ul/li[4]/a/span"));
		return element;
	}
	//Find button Overtime
	public static WebElement btn_overtime(WebDriver driver) {
		element = driver.findElement(By.linkText("Overtime"));
		return element;
	}

}

package wsm.teamChoDien.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChangePasswordPageObject {
	
	private static WebElement element = null;
	
	// Find element for title email
		public static WebElement lb_ChangePassword(WebDriver driver) {
			element = driver.findElement(By.xpath("//label[@class='login-title']"));
			return element;
		}
}

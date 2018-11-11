package wsm.teamChoDien.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RequestOvertimePageObject {
	
	private static WebElement element = null;

	// Finding element TITLE of Request Overtime button
	public static WebElement lb_title(WebDriver driver) {	
		element = driver.findElement(By.xpath("//h1[text()='Request overtime']"));
		return element;
	}

}

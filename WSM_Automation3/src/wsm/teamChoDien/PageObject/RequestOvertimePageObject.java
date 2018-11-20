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

	// Finding element TITLE of Request Overtime button
	public static WebElement btn_deleteRequest(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[5]/div[1]/div[2]/div/table/tbody/tr/td[11]/a[2]"));
		return element;
	}

}

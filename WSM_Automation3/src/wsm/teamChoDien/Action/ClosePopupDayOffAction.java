package wsm.teamChoDien.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import wsm.teamChoDien.PageObject.DashboardPageObject;

public class ClosePopupDayOffAction {
	public static void closePopup(WebDriver driver) {
		DashboardPageObject.puCloseDayOff(driver).click();
	}
}

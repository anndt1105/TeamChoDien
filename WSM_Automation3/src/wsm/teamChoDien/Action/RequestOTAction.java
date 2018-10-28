package wsm.teamChoDien.Action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import wsm.teamChoDien.PageObject.LoginPageObjects;
import wsm.teamChoDien.PageObject.PersonalRequestsOTPageObject;

public class RequestOTAction {
public static void requestOT(WebDriver driver,String branch, String group, String project, String fromDate, String toDate, String reason) throws InterruptedException {
		
		// Input data into branch field
		Select branchSelete = new Select(PersonalRequestsOTPageObject.txb_branch(driver));
		branchSelete.selectByValue(branch);
		
		// Input data into group field
		Select groupSelete = new Select(PersonalRequestsOTPageObject.txb_group(driver));
		groupSelete.selectByValue(group);
		
		// Input data into project field
		PersonalRequestsOTPageObject.txb_project(driver).sendKeys(project);;
		
		// Input data into From date field
		PersonalRequestsOTPageObject.txb_from(driver).sendKeys(fromDate);
		
		// Input data into To date field
		PersonalRequestsOTPageObject.txb_to(driver).sendKeys(toDate);
		
		// Input data into Reason field
		PersonalRequestsOTPageObject.txb_reason(driver).sendKeys(reason);
		
		// Click button Login
		LoginPageObjects.btn_Login(driver).click();
	}

public static void requestOTGroup(WebDriver driver,String branch, String group, String OTGroup, String project, String fromDate, String toDate, String reason) throws InterruptedException {
	
	// Input data into branch field
	Select branchSelete = new Select(PersonalRequestsOTPageObject.txb_branch(driver));
	branchSelete.selectByVisibleText(branch);
	
	// Input data into group field
	Select groupSelete = new Select(PersonalRequestsOTPageObject.txb_group(driver));
	groupSelete.selectByVisibleText(group);
	
	//Selected checkbox OT group
	PersonalRequestsOTPageObject.chb_OTGroup(driver).click();
	
	//Selected group OT
	Select OTGroupSelete = new Select(PersonalRequestsOTPageObject.txb_group(driver));
	OTGroupSelete.selectByVisibleText(OTGroup);
	
	// Input data into project field
	PersonalRequestsOTPageObject.txb_project(driver).sendKeys(project);;
	
	// Input data into From date field
	PersonalRequestsOTPageObject.txb_from(driver).sendKeys(fromDate);
	
	// Input data into To date field
	PersonalRequestsOTPageObject.txb_to(driver).sendKeys(toDate);
	
	// Input data into Reason field
	PersonalRequestsOTPageObject.txb_reason(driver).sendKeys(reason);
	
	// Click button Login
	LoginPageObjects.btn_Login(driver).click();
}

}

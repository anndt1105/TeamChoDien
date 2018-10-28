package wsm.teamChoDien.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import wsm.teamChoDien.Action.ClosePopupDayOffAction;
import wsm.teamChoDien.Action.LoginAction;
import wsm.teamChoDien.Action.RequestOTAction;
import wsm.teamChoDien.Action.TransitionPageAction;
import wsm.teamChoDien.PageObject.DashboardPageObject;
import wsm.teamChoDien.Utility.ConstantVariable;

public class PersonalRequestUnsuccessfulyTest extends CommonTest{
	
	//PER_REQ_OT_018
	@Test
	public void invalid_requestInThePast() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup Day off
		ClosePopupDayOffAction.closePopup(driver);
		
		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Doing Login action with valid User name and password
		//RequestOTAction.requestOT(driver, "", "", "", "", "", "");
		
		//Get message
		String[] message=DashboardPageObject.mess_loginSuccess(driver).getText().split("\n");
		
		// Verify Result message successfully
		Assert.assertEquals(message[message.length-1], ConstantVariable.LOGIN_SUCCESSFULY_MESSAGE);
	}
}

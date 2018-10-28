package wsm.teamChoDien.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.testng.Assert;
import org.testng.annotations.Test;

import wsm.teamChoDien.Action.ClosePopupDayOffAction;
import wsm.teamChoDien.Action.LoginAction;
import wsm.teamChoDien.Action.RequestOTAction;
import wsm.teamChoDien.Action.TransitionPageAction;
import wsm.teamChoDien.PageObject.DashboardPageObject;
import wsm.teamChoDien.PageObject.PersonalRequestsOTPageObject;
import wsm.teamChoDien.Utility.ConstantVariable;

public class PersonalRequestTest extends CommonTest{
	
	//PER_REQ_OT_018
	@Test
	public void invalid_requestInThePast() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup Day off
		//ClosePopupDayOffAction.closePopup(driver);
		
		
		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Input request OT
		ConstantVariable.REQUEST_OT_YEAR_MONTH =LocalDate.now().getYear()+"/"+(LocalDate.now().getMonthValue()-1);
		ConstantVariable.REQUEST_OT_DATE="/"+LocalDate.now().getDayOfMonth();
		String requestDateFrom= ConstantVariable.REQUEST_OT_YEAR_MONTH+ConstantVariable.REQUEST_OT_DATE+" 18:00";
		String requestDateTo= ConstantVariable.REQUEST_OT_YEAR_MONTH+ConstantVariable.REQUEST_OT_DATE+" 21:00";
		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID, ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo, ConstantVariable.RESON_OT);
		
		// Click save request
		PersonalRequestsOTPageObject.btn_saveRequest(driver).click();
		
		//Get message
		System.out.println("===="+PersonalRequestsOTPageObject.mess_requestOTUnsuccessfully(driver).getText());
		
		System.out.println("===="+ConstantVariable.REQUEST_OT_DATE_IN_PAST_MESS);
		
		// Verify Result message successfully
		Assert.assertEquals(PersonalRequestsOTPageObject.mess_requestOTUnsuccessfully(driver).getText(),ConstantVariable.REQUEST_OT_DATE_IN_PAST_MESS);
	}
}

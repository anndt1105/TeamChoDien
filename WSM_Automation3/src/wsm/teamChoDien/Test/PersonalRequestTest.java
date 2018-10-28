package wsm.teamChoDien.Test;

import static org.testng.Assert.assertEquals;

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

public class PersonalRequestTest extends CommonTest {

	// PER_REQ_OT_018
	@Test
	public void invalid_requestInThePast() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Input request OT
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/"
				+ (LocalDate.now().getMonthValue() - 1);
		ConstantVariable.REQUEST_OT_DATE = "/" + LocalDate.now().getDayOfMonth();
		String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 18:00";
		String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 21:00";

		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo, ConstantVariable.RESON_OT);

		// Get message
		boolean messDisplay = PersonalRequestsOTPageObject.mess_requestOTUnsuccessfully(driver).isDisplayed();

		// Verify Result message
		if (messDisplay = true) {
			Assert.assertEquals(PersonalRequestsOTPageObject.mess_requestOTUnsuccessfully(driver).getText(),
					ConstantVariable.REQUEST_OT_DATE_IN_PAST_MESS);
		} else {
			Assert.fail("Error message does not display");
		}
	}

	// PER_REQ_OT_019
	@Test
	public void invalid_requestProjectBlank() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Input request OT
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/" + LocalDate.now().getMonthValue();
		ConstantVariable.REQUEST_OT_DATE = "/" + LocalDate.now().getDayOfMonth();
		String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 18:00";
		String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 21:00";

		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID, " ",
				requestDateFrom, requestDateTo, ConstantVariable.RESON_OT);

		// Get message
		boolean messDisplay = PersonalRequestsOTPageObject.mess_requestOTUnsuccessfully(driver).isDisplayed();

		// Verify Result message successfully
		if (messDisplay = true) {
			Assert.assertEquals(PersonalRequestsOTPageObject.mess_requestOTUnsuccessfully(driver).getText(),
					ConstantVariable.PROJECT_BLANK_MESS);
		} else {
			Assert.fail("Error message does not display");
		}
	}

	// PER_REQ_OT_020
	@Test
	public void invalid_requestFromDateBlank() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Input request OT
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/" + LocalDate.now().getMonthValue();
		ConstantVariable.REQUEST_OT_DATE = "/" + LocalDate.now().getDayOfMonth();
		String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 21:00";

		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.PROJECT_VALID, " ", requestDateTo, ConstantVariable.RESON_OT);

		// Get message
		boolean messDisplay = PersonalRequestsOTPageObject.mess_fromDATEBlank(driver).isDisplayed();

		// Verify Result message successfully
		if (messDisplay = true) {
			Assert.assertEquals(PersonalRequestsOTPageObject.mess_fromDATEBlank(driver).getText(),
					ConstantVariable.FROM_DATE_BLANK_MESS);
		} else {
			Assert.fail("Error message does not display");
		}
	}

	// PER_REQ_OT_021
	@Test
	public void invalid_requestToDateBlank() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Input request OT
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/" + LocalDate.now().getMonthValue();
		ConstantVariable.REQUEST_OT_DATE = "/" + LocalDate.now().getDayOfMonth();
		String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 18:00";

		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.PROJECT_VALID, requestDateFrom, "", ConstantVariable.RESON_OT);

		// Get message
		boolean messDisplay = PersonalRequestsOTPageObject.mess_toDATEBlank(driver).isDisplayed();

		// Verify Result message successfully
		if (messDisplay = true) {
			Assert.assertEquals(PersonalRequestsOTPageObject.mess_toDATEBlank(driver).getText(),
					ConstantVariable.TO_DATE_BLANK_MESS);
		} else {
			Assert.fail("Error message does not display");
		}
	}

	// PER_REQ_OT_022
	@Test
	public void invalid_requestReasonBlank() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Input request OT
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/"
				+ (LocalDate.now().getMonthValue() - 1);
		ConstantVariable.REQUEST_OT_DATE = "/" + LocalDate.now().getDayOfMonth();
		String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 18:00";
		String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 21:00";

		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo, "");

		// Get message
		boolean messDisplay = PersonalRequestsOTPageObject.mess_reasonBlank(driver).isDisplayed();

		// Verify Result message
		if (messDisplay = true) {
			Assert.assertEquals(PersonalRequestsOTPageObject.mess_reasonBlank(driver).getText(),
					ConstantVariable.REASON_BLANK_MESS);
		} else {
			Assert.fail("Error message does not display");
		}
	}

	// PER_REQ_OT_023
	@Test
	public void invalid_duplicateRequest() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Create request OT in the first time
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/" + (LocalDate.now().getMonthValue());
		ConstantVariable.REQUEST_OT_DATE = "/" + LocalDate.now().getDayOfMonth();
		String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 18:00";
		String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 21:00";
		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo, ConstantVariable.RESON_OT);

		// Create request OT in the second time
		TransitionPageAction.gotoRequestOTPage(driver);
		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo, ConstantVariable.RESON_OT);
		// Get message

		boolean messDisplay = PersonalRequestsOTPageObject.mess_requestOTUnsuccessfully(driver).isDisplayed();

		// Verify Result message
		if (messDisplay = true) {
			Assert.assertEquals(PersonalRequestsOTPageObject.mess_requestOTUnsuccessfully(driver).getText(),
					ConstantVariable.DUPLICATE_REQUEST_MESS);
		} else {
			Assert.fail("Error message does not display");
		}
	}
}

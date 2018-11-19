package wsm.teamChoDien.Test;

import static org.testng.Assert.assertEquals;

import java.time.LocalDate;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import wsm.teamChoDien.Action.LoginAction;
import wsm.teamChoDien.Action.RequestOTAction;
import wsm.teamChoDien.Action.TransitionPageAction;
import wsm.teamChoDien.PageObject.PersonalRequestsOTPageObject;
import wsm.teamChoDien.PageObject.RequestOvertimePageObject;
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
				ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo, ConstantVariable.REASON_OT);

		// Get message
		System.out.println("====" + PersonalRequestsOTPageObject.mess_requestOTUnsuccessfully(driver).getText());

		System.out.println("====" + ConstantVariable.REQUEST_OT_DATE_IN_PAST_MESS);

		// Verify Result message successfully
		Assert.assertEquals(PersonalRequestsOTPageObject.mess_requestOTUnsuccessfully(driver).getText(),
				ConstantVariable.REQUEST_OT_DATE_IN_PAST_MESS);
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
				requestDateFrom, requestDateTo, ConstantVariable.REASON_OT);

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
				ConstantVariable.PROJECT_VALID, " ", requestDateTo, ConstantVariable.REASON_OT);

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
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/" + (LocalDate.now().getMonthValue());
		ConstantVariable.REQUEST_OT_DATE = "/" + LocalDate.now().getDayOfMonth();
		String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 18:00";

		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.PROJECT_VALID, requestDateFrom, "", ConstantVariable.REASON_OT);

		// Get message
		boolean messDisplay = PersonalRequestsOTPageObject.mess_toDATEBlank(driver).isDisplayed();

		// Verify Result message successfully
		if (messDisplay = true) {
			Assert.assertEquals(PersonalRequestsOTPageObject.mess_toDATEBlank(driver).getText(),
					ConstantVariable.TO_DATE_BLANK_MESS);
		} else {
			Assert.fail("Error message does not display");
		}

		/*
		 * String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH +
		 * ConstantVariable.REQUEST_OT_DATE + " 21:00";
		 * RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID,
		 * ConstantVariable.GROUP_VALID, ConstantVariable.PROJECT_VALID,
		 * requestDateFrom, requestDateTo, ConstantVariable.REASON_OT);
		 * 
		 * WebDriverWait wait = new WebDriverWait(driver, 20);
		 * wait.until(ExpectedConditions.visibilityOf(
		 * PersonalRequestsOTPageObject.mess_requestOTSuccessfully(driver)));
		 * 
		 * 
		 * 
		 * // Get message String[] actual_message =
		 * PersonalRequestsOTPageObject.mess_requestOTSuccessfully(driver).
		 * getText().split("\n");
		 * 
		 * // Verify Result message successfully
		 * Assert.assertEquals(actual_message[actual_message.length - 1],
		 * ConstantVariable.CREATE_REQUEST_OT_SUCCESSFULY_MESSAGE);
		 */
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
				ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo, ConstantVariable.REASON_OT);

		// Create request OT in the second time
		TransitionPageAction.gotoRequestOTPage(driver);
		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo, ConstantVariable.REASON_OT);

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

	// PER_REQ_OT_011
	@Test
	public void valid_NotCheckedOTGroup() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Input request OT
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/" + (LocalDate.now().getMonthValue());
		ConstantVariable.REQUEST_OT_DATE = "/" + LocalDate.now().getDayOfMonth();
		String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 18:00";
		String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 21:00";
		RequestOTAction.requestOTGroup(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.OT_GROUP_VALID, ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo,
				ConstantVariable.REASON_OT);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.mess_requestOTSuccessfully(driver)));

		// Get message
		String[] actual_message = PersonalRequestsOTPageObject.mess_requestOTSuccessfully(driver).getText().split("\n");

		// Verify Result message successfully
		Assert.assertEquals(actual_message[actual_message.length - 1],
				ConstantVariable.CREATE_REQUEST_OT_SUCCESSFULY_MESSAGE);
	}

	// PER_REQ_OT_012
	@Test
	public void valid_CheckedOTGroup() throws Exception {
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
		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo, ConstantVariable.REASON_OT);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.mess_requestOTSuccessfully(driver)));

		// Get message
		String[] actual_message = PersonalRequestsOTPageObject.mess_requestOTSuccessfully(driver).getText().split("\n");

		// Verify Result message successfully
		Assert.assertEquals(actual_message[actual_message.length - 1],
				ConstantVariable.CREATE_REQUEST_OT_SUCCESSFULY_MESSAGE);
	}

	// PER_REQ_OT_013
	@Test
	public void valid_CurrentMonth() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Input request OT
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/" + (LocalDate.now().getMonthValue());
		ConstantVariable.REQUEST_OT_DATE = "/" + LocalDate.now().getDayOfMonth();
		String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 18:00";
		String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 21:00";
		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo, ConstantVariable.REASON_OT);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.mess_requestOTSuccessfully(driver)));

		// Get message
		String[] actual_message = PersonalRequestsOTPageObject.mess_requestOTSuccessfully(driver).getText().split("\n");

		// Verify Result message successfully
		Assert.assertEquals(actual_message[actual_message.length - 1],
				ConstantVariable.CREATE_REQUEST_OT_SUCCESSFULY_MESSAGE);
	}

	// PER_REQ_OT_014
	@Test
	public void valid_FutureMonth() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Input request OT
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/"
				+ (LocalDate.now().getMonthValue() + 1);
		ConstantVariable.REQUEST_OT_DATE = "/" + LocalDate.now().getDayOfMonth();
		String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 18:00";
		String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 21:00";
		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo, ConstantVariable.REASON_OT);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.mess_requestOTSuccessfully(driver)));

		// Get message
		String[] actual_message = PersonalRequestsOTPageObject.mess_requestOTSuccessfully(driver).getText().split("\n");

		// Verify Result message successfully
		Assert.assertEquals(actual_message[actual_message.length - 1],
				ConstantVariable.CREATE_REQUEST_OT_SUCCESSFULY_MESSAGE);
	}

	// PER_REQ_OT_015
	@Test
	public void valid_RequestOTScreenDisplay() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Input request OT
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/" + (LocalDate.now().getMonthValue());
		ConstantVariable.REQUEST_OT_DATE = "/" + LocalDate.now().getDayOfMonth();
		String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 18:00";
		String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 21:00";
		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo, ConstantVariable.REASON_OT);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(RequestOvertimePageObject.lb_title(driver)));

		// Verify that Request OT screen is displayed
		String actual_title = RequestOvertimePageObject.lb_title(driver).getText();
		String expected_title = ConstantVariable.REQUEST_OT_SCREEN_TITLE;
		Assert.assertEquals(actual_title, expected_title);
	}

	// PER_REQ_OT_005
	@Test
	public void checkboxDefault() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Verify that “Do you OT for other group?” checkbox is unselected by
		// default
		Assert.assertFalse(PersonalRequestsOTPageObject.chb_OTGroup(driver).isSelected());
	}

	// PER_REQ_OT_006
	// Check data staff Name
	@Test
	public void staffNameCorrect() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		TransitionPageAction.gotoRequestOTPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.txb_staffName(driver)));

		// Verify that "Staff name" data is correct
		Assert.assertEquals(PersonalRequestsOTPageObject.txb_staffName(driver).getAttribute("value"),
				ConstantVariable.STAFF_NAME);
	}

	// Check can't edit staff Name
	@Test
	public void staffNameUneditable() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		TransitionPageAction.gotoRequestOTPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.txb_staffName(driver)));

		// Verify that "Staff name" field is uneditable
		Assert.assertFalse(PersonalRequestsOTPageObject.txb_staffName(driver).isEnabled());
	}

	// PER_REQ_OT_007
	// Check data staff code
	@Test
	public void staffCodeCorrect() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		TransitionPageAction.gotoRequestOTPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.txb_staffCode(driver)));

		// Verify that "Staff code" data is correct
		Assert.assertEquals(PersonalRequestsOTPageObject.txb_staffCode(driver).getAttribute("value"),
				ConstantVariable.STAFF_CODE);
	}

	// Check can't edit staff code
	@Test
	public void staffCodeUneditable() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		TransitionPageAction.gotoRequestOTPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.txb_staffCode(driver)));

		// Verify that "Staff code" field is uneditable
		Assert.assertFalse(PersonalRequestsOTPageObject.txb_staffCode(driver).isEnabled());
	}

	// PER_REQ_OT_008
	// Check data Branch
	@Test
	public void checkBranch() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		TransitionPageAction.gotoRequestOTPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.txb_branch(driver)));

		// Verify that "Branch" data is correct
		Assert.assertEquals(PersonalRequestsOTPageObject.txb_branch(driver).getAttribute("value"),
				ConstantVariable.BRANCH_VALID);
	}

	// Check can't edit Branch
	@Test
	public void checkBranchUneditable() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		TransitionPageAction.gotoRequestOTPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.txb_branch(driver)));

		// Verify that "Branch" data is correct
		Assert.assertFalse(PersonalRequestsOTPageObject.txb_branch(driver).isEnabled());
	}

	// PER_REQ_OT_009
	@Test
	public void clickOTForOtherGroupCheckbox() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		TransitionPageAction.gotoRequestOTPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.chb_OTGroup(driver)));

		// Click on Do you OT for other group checkbox
		PersonalRequestsOTPageObject.chb_OTGroup(driver).click();

		// Verify the displaying of Group other drop down
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.drd_OTGroup(driver)));
		Assert.assertTrue(PersonalRequestsOTPageObject.drd_OTGroup(driver).isDisplayed());
	}

	// PER_REQ_OT_010
	// @Test
	public void checkGroup() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Verify that "Group" dropdown list displays with correct data when
		// clicking on "Group" dropdown list
		Assert.assertEquals(PersonalRequestsOTPageObject.txb_group(driver).getAttribute("value"),
				ConstantVariable.GROUP_VALID);
	}

}

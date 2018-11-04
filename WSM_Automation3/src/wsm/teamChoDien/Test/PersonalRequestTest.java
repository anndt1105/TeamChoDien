package wsm.teamChoDien.Test;

import java.awt.RenderingHints.Key;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import wsm.teamChoDien.Action.ClosePopupDayOffAction;
import wsm.teamChoDien.Action.LoginAction;
import wsm.teamChoDien.Action.RequestOTAction;
import wsm.teamChoDien.Action.TransitionPageAction;
import wsm.teamChoDien.PageObject.DashboardPageObject;
import wsm.teamChoDien.PageObject.LoginPageObjects;
import wsm.teamChoDien.PageObject.PersonalRequestsOTPageObject;
import wsm.teamChoDien.Utility.ConstantVariable;

public class PersonalRequestTest extends CommonTest {

	// PER_REQ_OT_018
	// @Test
	public void invalid_requestInThePast() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup Day off
		// ClosePopupDayOffAction.closePopup(driver);

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

		// Click save request
		PersonalRequestsOTPageObject.btn_saveRequest(driver).click();

		// Get message
		System.out.println("====" + PersonalRequestsOTPageObject.mess_requestOTUnsuccessfully(driver).getText());

		System.out.println("====" + ConstantVariable.REQUEST_OT_DATE_IN_PAST_MESS);

		// Verify Result message successfully
		Assert.assertEquals(PersonalRequestsOTPageObject.mess_requestOTUnsuccessfully(driver).getText(),
				ConstantVariable.REQUEST_OT_DATE_IN_PAST_MESS);
	}

	// PER_REQ_OT_005
	// @Test
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
	// @Test
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
	// @Test
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
	// @Test
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
	// @Test
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
	// @Test
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
	// @Test
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
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.txb_OTGroupOther(driver)));
		Assert.assertTrue(PersonalRequestsOTPageObject.txb_OTGroupOther(driver).isDisplayed());
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

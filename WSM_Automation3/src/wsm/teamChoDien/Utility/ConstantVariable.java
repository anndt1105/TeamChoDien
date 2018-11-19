package wsm.teamChoDien.Utility;

public class ConstantVariable {
	
	//BASE URL
	public static final String URL = "https://edev.framgia.vn/";
 
	//LOGIN PAGE
    public static final String USERNAME = "nguyen.duc.truong.an@framgia.com.edev";
    public static final String USERNAME_NOT_EXIST = "abc@framgia.com";
    public static final String USERNAME_INVALID = "nguyen.duc.truong.an";
    public static final String PASSWORD = "12345678";
    public static final String INVALID_PASSWORD = "123456";
    public static final String LOGIN_FAILED_MESSAGE = "Invalid email or password.";
    public static final String LOGIN_SUCCESSFULY_MESSAGE = "Signed in successfully.";
    public static final String TAB_TITLE = "Your timesheet | Working space";
    public static final String USERNAME_BLANK_MESSAGE = "Email is required";
    public static final String PASSWORD_BLANK_MESSAGE = "Password is required";
    public static final String USERNAME_INVALID_MESSAGE = "Please enter a valid email address";
    public static final String USERNAME_NOT_EXIST_MESSAGE = "Email not found";
    
    //LOGOUT
    public static final String LOGOUT_SUCCESSFULY_MESSAGE = "Signed out successfully.";
    
    //FORGOT PASSWORD
    public static final String SEND_SUCCESSFULL_MESSAGE =
    		"You will receive an email with instructions on how to reset your password in a few minutes.";
    public static final String FORGOT_PASSWORD_BLANK_MESSAGE = "Password is required";
	public static final String YOP_MAIL_URL = "http://www.yopmail.com/en/anndt";
	//public static final String USERNAME = "anndt@yopmail.com";
	public static final String USERNAME_NOT_EXIT = "doan.ngoc.vu123@framgia.com";
	public static final String FORGOTPASSWORD_TITLE = "FORGOT PASSWORD";
	public static final String CREATE_REQUEST_OT_SUCCESSFULY_MESSAGE = "Request overtime create successfully!";
	public static final String REQUEST_OT_SCREEN_TITLE = "Request overtime";
	public static final String MAIL_TITLE = "[WSM] Reset password instructions";
	public static final String CHANGE_PASSWORD_SCREEN_TITLE = "CHANGE PASSWORD";
  public static final String MESSAGE_PASSWORD_REQUIRED = "Password is required";
	public static final String MESSAGE_PASSWORD_INVALID_LESS_6 = "Please enter at least 6 characters";
	public static final String MESSAGE_PASSWORD_INVALID_OVER_129 = "Please enter max 128 characters";
	public static final String MESSAGE_CONFIRMPASSWORD_NOT_MAP = "Please enter the same value again.";
	public static final String PASSWORD_129 = "120216215610561561560156405120216215610561561560156405120216215610561561560156405120216215610561561560156405120216215610561012102";
    
    //PERSONAL REQUEST
	// Branch 4=Da Nang Office
	public static final String BRANCH_VALID = "4";
	
	// Group 212=Software Development Division 3/Section 2/Group 2/Tbd
	public static final String GROUP_VALID = "212";
	
	// OTGroup 1=Software Development Division 1
	public static final String OT_GROUP_VALID = "1";

    public static final String PROJECT_VALID = "Beautiful Company";
    public static final String REASON_OT = "Because I love my Customer";
    
    // Request OT date
    public static String REQUEST_OT_YEAR_MONTH = "";
    public static String REQUEST_OT_DATE = "";
    
    //Message validate create unsuccessfully
    public static final String PROJECT_BLANK_MESS = "Project name can not be blank";
    public static final String FROM_DATE_BLANK_MESS = "From time not be blank";
    public static final String TO_DATE_BLANK_MESS = "End time not be blank";
    public static final String REASON_BLANK_MESS = "Reason not be blank";
    public static final String DUPLICATE_REQUEST_MESS = "Request has been taken with other request";
    
    //Message create unsuccessfully
    public static final String REQUEST_OT_DATE_IN_PAST_MESS = "Timekeeping data of " +REQUEST_OT_DATE+" is not available, you can not access for this month!";
    
    //FORGOT PASSWORD
    public static final String NEW_PASSWORD_LABEL = "New password";
    public static final String CONFIRM_NEW_PASSWORD_LABEL = "Password confirmation";
    
    //Personal request
    public static final String STAFF_NAME = "Nguyen Duc Truong An";
	public static final String STAFF_CODE = "B120627";
    
    
}

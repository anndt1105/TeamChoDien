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
    public static final String PASSWORD_BLANK_MESSAGE = "Password is required";
    
    //PERSONAL REQUEST
    //Branch 4=Da Nang Office
    public static final String BRANCH_VALID = "4";
    //Group 370=Div_test fgas/Div test _ sec 1/Group 1/Team 2/Team member 123
    public static final String GROUP_VALID = "370";
    public static final String PROJECT_VALID = "Beautiful Company";
    public static final String RESON_OT = "Because I love my Customer";
    // Request OT date
    public static String REQUEST_OT_YEAR_MONTH = "";
    public static String REQUEST_OT_DATE = "";
    //Message create unsuccessuly
    public static final String REQUEST_OT_DATE_IN_PAST_MESS = "Timekeeping data of " +REQUEST_OT_DATE+" is not available, you can not access for this month!";

}

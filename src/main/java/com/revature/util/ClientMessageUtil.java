package com.revature.util;

public class ClientMessageUtil {

	public static final ClientMessage SUCCESSFULLY_TREATED = new ClientMessage("Patient successfully treated!");

	public static final ClientMessage TREATMENT_FAILED = new ClientMessage("Patient treatment failed.");

	public static final ClientMessage SUCCESSFUL_UPDATE = new ClientMessage(
			"Successfully updated your account information.");

	public static final ClientMessage FAILED_UPDATE = new ClientMessage("User update failed");

	public static final ClientMessage ORDER_PLACED = new ClientMessage("Order has been placed successfully.");

	public static final ClientMessage ORDER_FAILED = new ClientMessage("Order failed, please try again.");

	public static final ClientMessage NURSE_ASSIGNED = new ClientMessage("Successfully assigned nurse to patient.");

	public static final ClientMessage NURSE_FAILED = new ClientMessage("Assignment to patient has failed.");

	public static final ClientMessage USER_REMOVED = new ClientMessage("User successfully deleted.");

	public static final ClientMessage USER_FAILED = new ClientMessage("User removal has failed.");

	public static final ClientMessage USER_LOGIN = new ClientMessage("User successfully logged in.");
	
	public static final ClientMessage USER_REGISTERED = new ClientMessage("User has been successfully registered!");
	
	public static final ClientMessage USER_NOT_REGISTERED = new ClientMessage("User registration has failed.");

	public static final ClientMessage LOGIN_FAILED = new ClientMessage(
			"Login failed, username or password is incorrect.");
	
	public static final ClientMessage RECORD_REMOVED = new ClientMessage("Patient record has been removed successfully.");
	
	public static final ClientMessage RECORD_FAILED = new ClientMessage("Patient record removal has failed.");
	
	public static final ClientMessage PATIENT_REGISTERED = new ClientMessage(
							"Patient has been admitted to the Pokemon Center! Please wait for their return");
	
	public static final ClientMessage PATIENT_FAILED = new ClientMessage("Patient failed to be admitted.");
}

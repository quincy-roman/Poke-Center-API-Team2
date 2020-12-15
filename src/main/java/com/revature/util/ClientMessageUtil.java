package com.revature.util;

public class ClientMessageUtil {
	
	public static final ClientMessage SUCCESSFULLY_TREATED = new ClientMessage("Patient successfully treated!");
	
	public static final ClientMessage TREATMENT_FAILED = new ClientMessage("Patient treatment failed.");
	
	public static final ClientMessage SUCCESSFUL_UPDATE = new ClientMessage("Successfully updated your account information.");
	
	public static final ClientMessage FAILED_UPDATE = new ClientMessage("User update failed");
	
	public static final ClientMessage ORDER_PLACED = new ClientMessage("Order has been placed successfully.");
	
	public static final ClientMessage ORDER_FAILED = new ClientMessage("Order failed, please try again.");

}

package com.revature.util;

public class ClientMessage {

	private String message;

	public ClientMessage() {
	}

	public ClientMessage(String message) {
		super();
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

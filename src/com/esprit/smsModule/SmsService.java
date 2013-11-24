package com.esprit.smsModule;

public interface SmsService {
	
	public void sendMessage(String to,String message);
	public String getVersion();

}

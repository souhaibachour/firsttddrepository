package com.esprit.car;

import java.util.Arrays;
import java.util.List;

import com.esprit.smsModule.SmsService;

public class Car {
	
	SmsService smsService;
	boolean started = false;

	public void turnKey(String keyDirection) {

		List<String> possiblesValues=Arrays.asList("right","left");
		if(!possiblesValues.contains(keyDirection)){
			System.out.println(smsService.getVersion());
			smsService.sendMessage("52575902", "Erreur M Souhaib");
			throw new IllegalArgumentException();
		}
		
		if (keyDirection.equals("right")) {
			started = true;
			
		}
		else{
			started = false;
			
		 }
		 
		 
	}

	public boolean isStarted() {
		// TODO Auto-generated method stub
		return started;
	}

}

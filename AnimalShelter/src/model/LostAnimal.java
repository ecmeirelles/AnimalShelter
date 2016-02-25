package model;

import java.util.Date;

public class LostAnimal extends Category {
	private String lostLocation;
	
	public LostAnimal(Date date, Person emergencyContact, String lostLocation) {
		super(date, emergencyContact);
		
		this.lostLocation = lostLocation;
	}

	public String getLostLocation() {
		return lostLocation;
	}

	public void setLostLocation(String lostLocation) {
		this.lostLocation = lostLocation;
	}
}

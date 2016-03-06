package model;

import java.time.LocalDate;

public class LostAnimal extends Category {
	private String lostLocation;

	public LostAnimal(LocalDate date, Person emergencyContact) {
		super(date, emergencyContact);
	}

	public String getLostLocation() {
		return lostLocation;
	}

	public void setLostLocation(String lostLocation) {
		this.lostLocation = lostLocation;
	}
}

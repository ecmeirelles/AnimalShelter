package model;

import java.util.Date;

public class FoundAnimal extends Category {
	private String foundLocation;

	public FoundAnimal(Date date, Person emergencyContact, String foundLocation) {
		super(date, emergencyContact);
		
		this.foundLocation = foundLocation;
	}

	public String getFoundLocation() {
		return foundLocation;
	}

	public void setFoundLocation(String foundLocation) {
		this.foundLocation = foundLocation;
	}
}

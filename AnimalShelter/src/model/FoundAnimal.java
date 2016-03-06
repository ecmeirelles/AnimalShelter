package model;

import java.time.LocalDate;

public class FoundAnimal extends Category {
	private String foundLocation;

	public FoundAnimal(LocalDate date, Person emergencyContact, String foundLocation) {
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

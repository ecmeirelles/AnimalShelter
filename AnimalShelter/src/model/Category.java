package model;

import java.time.LocalDate;

public class Category {
	private LocalDate date;
	private Person emergencyContact;
	
	public Category() {
		
	}
	
	public Category(LocalDate date, Person emergencyContact) {
		this.date = date;
		this.emergencyContact = emergencyContact;
	}

	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate localDate) {
		this.date = localDate;
	}
	public Person getEmergencyContact() {
		return emergencyContact;
	}
	public void setEmergencyContact(Person emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
	
	
}

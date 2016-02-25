package model;

import java.util.Date;

public class Category {
	private Date date;
	private Person emergencyContact;
	
	public Category(Date date, Person emergencyContact) {
		this.date = date;
		this.emergencyContact = emergencyContact;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Person getEmergencyContact() {
		return emergencyContact;
	}
	public void setEmergencyContact(Person emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
	
	
}

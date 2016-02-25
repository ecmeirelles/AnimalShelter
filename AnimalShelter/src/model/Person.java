package model;

public class Person {
	private String personName;
	private String personAddress;
	private String personPhone;
	private String personEmail;
	
	public Person(String personName, String personAddress, String personPhone, String personEmail) {
		this.personName = personName;
		this.personAddress = personAddress;
		this.personPhone = personPhone;
		this.personEmail = personEmail;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonAddress() {
		return personAddress;
	}

	public void setPersonAddress(String personAddress) {
		this.personAddress = personAddress;
	}

	public String getPersonPhone() {
		return personPhone;
	}

	public void setPersonPhone(String personPhone) {
		this.personPhone = personPhone;
	}

	public String getPersonEmail() {
		return personEmail;
	}

	public void setPersonEmail(String personEmail) {
		this.personEmail = personEmail;
	}
}

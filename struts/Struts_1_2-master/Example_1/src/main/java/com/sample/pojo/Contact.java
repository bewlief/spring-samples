package com.sample.pojo;

public class Contact {
	private String name;
	private String city;
	private int contact;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	public Contact(String name,int contact, String city) {
		super();
		this.name = name;
		this.city = city;
		this.contact = contact;
	}

}

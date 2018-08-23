package test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="room")
public class RoomModel {
	
	@Id
	@Column(name="id")
	int id;
	
	@Column(name="rooms")
	int rooms;
	
	@Column(name="bedrooms")
	int bedrooms;
	
	@Column(name="occupied")
	int occupied;
	
	@Column(name="email")
	String email;
	
	@Column(name="rent")
	int rent;
	
	@Column(name="size")
	String size;
	
	@Column(name="security")
	int security;
	
	@Column(name="max_roommate")
	int max_roommate;
	
	@Column(name="internet")
	String internet;
	
	@Column(name="bills")
	String bills;
	
	@Column(name="add1")
	String add1;
	
	@Column(name="add2")
	String add2;
	
	@Column(name="town")
	String town;
	
	@Column(name="county")
	String county;
	
	@Column(name="postcode")
	int postcode;
	
	@Column(name="title")
	String title;
	
	@Column(name="description")
	String description;
	
	@Column(name="property_type")
	String propertyType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	public int getBedrooms() {
		return bedrooms;
	}

	public void setBedrooms(int bedrooms) {
		this.bedrooms = bedrooms;
	}

	public int getOccupied() {
		return occupied;
	}

	public void setOccupied(int occupied) {
		this.occupied = occupied;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRent() {
		return rent;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getSecurity() {
		return security;
	}

	public void setSecurity(int security) {
		this.security = security;
	}

	public int getMax_roommate() {
		return max_roommate;
	}

	public void setMax_roommate(int max_roommate) {
		this.max_roommate = max_roommate;
	}

	public String getInternet() {
		return internet;
	}

	public void setInternet(String internet) {
		this.internet = internet;
	}

	public String getBills() {
		return bills;
	}

	public void setBills(String bills) {
		this.bills = bills;
	}

	public String getAdd1() {
		return add1;
	}

	public void setAdd1(String add1) {
		this.add1 = add1;
	}

	public String getAdd2() {
		return add2;
	}

	public void setAdd2(String add2) {
		this.add2 = add2;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public int getPostcode() {
		return postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	@Override
	public String toString() {
		return "RoomModel [id=" + id + ", rooms=" + rooms + ", bedrooms=" + bedrooms + ", occupied=" + occupied
				+ ", email=" + email + ", rent=" + rent + ", size=" + size + ", security=" + security
				+ ", max_roommate=" + max_roommate + ", internet=" + internet + ", bills=" + bills + ", add1=" + add1
				+ ", add2=" + add2 + ", town=" + town + ", county=" + county + ", postcode=" + postcode + ", title="
				+ title + ", description=" + description + ", propertyType=" + propertyType + "]";
	}
	
	
	

}

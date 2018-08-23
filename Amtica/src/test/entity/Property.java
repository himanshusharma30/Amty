package test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="property")
public class Property {
	
	@Id
	@Column
	String property_name;
	
	
	public Property() {
		
	}

	public Property(String property_name) {
		super();
		this.property_name = property_name;
	}

	public String getProperty_name() {
		return property_name;
	}

	public void setProperty_name(String property_name) {
		this.property_name = property_name;
	}

	@Override
	public String toString() {
		return "Property [property_name=" + property_name + "]";
	}
	
	

}

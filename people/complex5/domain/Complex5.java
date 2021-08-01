package complex5.domain;

/**
 * User object
 * 
 * @author changxin bai
 * 
 */
public class Complex5 {
	/*
	 * Correspond to the user table
	 */
	
	private String city;
	private String HospitalName; 
	private String name;
	private int ID;
	private String DateOfBirth;
	
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String getHospitalName() {
		return HospitalName;
	}

	public void setHospitalName(String HospitalName) {
		this.HospitalName = HospitalName;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}
		
	public String getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(String DateOfBirth) {
		this.DateOfBirth = DateOfBirth;
	}

	
	@Override
	public String toString() {
		return "People Age Greater Than AvgAge[ city=" + city + ", HospitalName=" + HospitalName 
				+ ", name=" + name + ", ID=" + ID + ", DateOfBirth=" + DateOfBirth +"]";
	}
}

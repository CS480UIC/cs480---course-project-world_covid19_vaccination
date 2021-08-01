package people.domain;

/**
 * User object
 * 
 * @author changxin bai
 * 
 */
public class People {
	/*
	 * Correspond to the user table
	 */
	
	private int number;
	private String HospitalName;
	private int ID; 
	private String name;
	private int age;
	private String DateOfBirth;
	

	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public String getHospitalName() {
		return HospitalName;
	}

	public void setHospitalName(String HospitalName) {
		this.HospitalName = HospitalName;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(String DateOfBirth) {
		this.DateOfBirth = DateOfBirth;
	}

	
	@Override
	public String toString() {
		return "People[ number=" + number + ", HospitalName=" + HospitalName +
				", ID=" + ID + ", name=" + name + ", age=" 
				+ age + ", DateOfBirth=" + DateOfBirth + "]";
	}
}

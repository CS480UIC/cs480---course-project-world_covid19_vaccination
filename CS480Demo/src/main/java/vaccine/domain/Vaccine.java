package vaccine.domain;

/**
 * User object
 * 
 * @author changxin bai
 * 
 */
public class Vaccine {
	/*
	 * Correspond to the user table
	 */
	
	private String name; 
	private String type;
	private String company;
	private double ProtectionRate;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	
	public double getProtectionRate() {
		return ProtectionRate;
	}

	public void setProtectionRate(double ProtectionRate) {
		this.ProtectionRate = ProtectionRate;
	}

	
	@Override
	public String toString() {
		return "Vaccine[ name=" + name + ", type" + type +
				", company=" + company + ", ProtectionRate=" + ProtectionRate + "]";
	}
}

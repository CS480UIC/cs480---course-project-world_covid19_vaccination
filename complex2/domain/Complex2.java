package complex2.domain;

/**
 * User object
 * 
 * @author changxin bai
 * 
 */
public class Complex2 {
	/*
	 * Correspond to the user table
	 */
	
	private String HospitalName;
	private String VaccineName; 
	private String type;
	private String company;
	private double ProtectionRate;
	private int VaccinatedPeople;
	
	
	public String getHospitalName() {
		return HospitalName;
	}

	public void setHospitalName(String HospitalName) {
		this.HospitalName = HospitalName;
	}
	
	public String getVaccineName() {
		return VaccineName;
	}

	public void setVaccineName(String VaccineName) {
		this.VaccineName = VaccineName;
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
	
	public int getVaccinatedPeople() {
		return VaccinatedPeople;
	}

	public void setVaccinatedPeople(int VaccinatedPeople) {
		this.VaccinatedPeople = VaccinatedPeople;
	}

	
	@Override
	public String toString() {
		return "Hosipital Vaccine Info[ HospitalName=" + HospitalName + ", VaccineName=" + VaccineName 
				+ ", type=" + type + ", company=" + company + ", ProtectionRate=" + ProtectionRate
				+ ", VaccinatedPeople=" + VaccinatedPeople +"]";
	}
}

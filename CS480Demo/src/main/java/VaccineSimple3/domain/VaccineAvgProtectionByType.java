package VaccineSimple3.domain;

/**
 * User object
 * 
 * @author changxin bai
 * 
 */
public class VaccineAvgProtectionByType {
	/*
	 * Correspond to the user table
	 */
	
	private double AvgProtectionRate; 
	private String type;

	public double getAvgProtectionRate() {
		return AvgProtectionRate;
	}

	public void setAvgProtectionRate(double AvgProtectionRate) {
		this.AvgProtectionRate = AvgProtectionRate;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	@Override
	public String toString() {
		return "AvgProtectionByType[ Avgerage Protection Rate=" + AvgProtectionRate + ", type" + type + "]";
	}
}

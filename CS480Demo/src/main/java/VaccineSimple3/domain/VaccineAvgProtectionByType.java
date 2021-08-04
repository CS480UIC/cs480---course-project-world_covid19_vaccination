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
	
	private String type;
	private double AvgProtectionRate; 
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public double getAvgProtectionRate() {
		return AvgProtectionRate;
	}

	public void setAvgProtectionRate(double AvgProtectionRate) {
		this.AvgProtectionRate = AvgProtectionRate;
	}

	
	@Override
	public String toString() {
		return "AvgProtectionByType[ type=" + type + ", avgerage_protection_rate=" + AvgProtectionRate + "]";
	}
}

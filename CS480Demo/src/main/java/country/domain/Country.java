package country.domain;

/**
 * User object
 * 
 * @author changxin bai
 * 
 */
public class Country {
	/*
	 * Correspond to the user table
	 */
	
	private String CountryName; 
	private String CountryAbbreviation;
	private String VaccineType;

	
	public String getCountryName() {
		return CountryName;
	}

	public void setCountryName(String CountryName) {
		this.CountryName = CountryName;
	}
	

	public String getCountryAbbreviation() {
		return CountryAbbreviation;
	}

	public void setCountryAbbreviation(String CountryAbbreviation) {
		this.CountryAbbreviation = CountryAbbreviation;
	}
	

	public String getVaccineType() {
		return VaccineType;
	}

	public void setVaccineType(String VaccineType) {
		this.VaccineType = VaccineType;
	}

	
	@Override
	public String toString() {
		return "Country[ CountryName=" + CountryName + ", CountryAbbreviation=" + CountryAbbreviation +
				", VaccineType=" + VaccineType + "]";
	}
}

package complex3.domain;

/**
 * User object
 * 
 * @author changxin bai
 * 
 */
public class Complex3 {
	/*
	 * Correspond to the user table
	 */
	
	private String CountryName;
	private String SumOfVaccinatedPeople;	
	
	public String getCountryName() {
		return CountryName;
	}

	public void setCountryName(String CountryName) {
		this.CountryName = CountryName;
	}
	
	public String getSumOfVaccinatedPeople() {
		return SumOfVaccinatedPeople;
	}

	public void setSumOfVaccinatedPeople(String SumOfVaccinatedPeople) {
		this.SumOfVaccinatedPeople = SumOfVaccinatedPeople;
	}

	
	@Override
	public String toString() {
		return "Sum Of Vaccinated People > 150000[ CountryName=" + CountryName + ", SumOfVaccinatedPeople=" + SumOfVaccinatedPeople +"]";
	}
}

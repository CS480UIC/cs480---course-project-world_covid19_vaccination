package complex1.domain;

/**
 * User object
 * 
 * @author changxin bai
 * 
 */
public class Complex1 {
	/*
	 * Correspond to the user table
	 */
	
	private String CountryAbbreviation;
	private int CountryPopulation; 
	
	
	public String getCountryAbbreviation() {
		return CountryAbbreviation;
	}

	public void setCountryAbbreviation(String CountryAbbreviation) {
		this.CountryAbbreviation = CountryAbbreviation;
	}
	
	public int getCountryPopulation() {
		return CountryPopulation;
	}

	public void setCountryPopulation(int CountryPopulation) {
		this.CountryPopulation = CountryPopulation;
	}

	
	@Override
	public String toString() {
		return "Country Population[ CountryAbbreviation=" + CountryAbbreviation + ", CountryPopulation=" + CountryPopulation + "]";
	}
}

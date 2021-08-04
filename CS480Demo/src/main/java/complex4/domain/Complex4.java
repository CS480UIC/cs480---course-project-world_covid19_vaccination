package complex4.domain;

/**
 * User object
 * 
 * @author changxin bai
 * 
 */
public class Complex4 {
	/*
	 * Correspond to the user table
	 */
	
	private String CountryName;
	private String StateName; 
	private int population;
	
	
	public String getCountryName() {
		return CountryName;
	}

	public void setCountryName(String CountryName) {
		this.CountryName = CountryName;
	}
	
	public String getStateName() {
		return StateName;
	}

	public void setStateName(String StateName) {
		this.StateName = StateName;
	}
	
	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	
	@Override
	public String toString() {
		return "State Population Greater Than Country AvgPopulation[ CountryName=" + CountryName + ", StateName=" + StateName 
				+ ", population=" + population + "]";
	}
}

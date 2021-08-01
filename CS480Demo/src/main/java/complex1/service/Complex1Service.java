package complex1.service;

import java.util.List;

import complex1.dao.Complex1Dao;
import complex1.domain.Complex1;

/**
 * logic functions such as register, login
 * @author changxin bai
 *
 */
public class Complex1Service {
	private Complex1Dao complex1Dao = new Complex1Dao();
	
	/**
	 * register a user
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */

	
	public List<Object> countryPopulation() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return complex1Dao.countryPopulation();
		
	}
	
}

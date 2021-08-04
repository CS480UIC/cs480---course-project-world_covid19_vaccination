package complex4.service;

import java.util.List;

import complex4.dao.Complex4Dao;
import complex4.domain.Complex4;

/**
 * logic functions such as register, login
 * @author changxin bai
 *
 */
public class Complex4Service {
	private Complex4Dao complex4Dao = new Complex4Dao();
	
	/**
	 * register a user
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */

	
	public List<Object> statePopulationGreaterThanAvgPopulation() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return complex4Dao.statePopulationGreaterThanAvgPopulation();
		
	}
	
}

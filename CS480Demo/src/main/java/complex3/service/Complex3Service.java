package complex3.service;

import java.util.List;

import complex3.dao.Complex3Dao;
import complex3.domain.Complex3;

/**
 * logic functions such as register, login
 * @author changxin bai
 *
 */
public class Complex3Service {
	private Complex3Dao complex3Dao = new Complex3Dao();
	
	/**
	 * register a user
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */

	
	public List<Object> sumOfVaccinatedPeopleGreaterThan150000() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return complex3Dao.sumOfVaccinatedPeopleGreaterThan150000();
		
	}
	
}

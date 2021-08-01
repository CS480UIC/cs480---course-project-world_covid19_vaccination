package complex5.service;

import java.util.List;

import complex5.dao.Complex5Dao;
import complex5.domain.Complex5;

/**
 * logic functions such as register, login
 * @author changxin bai
 *
 */
public class Complex5Service {
	private Complex5Dao complex5Dao = new Complex5Dao();
	
	/**
	 * register a user
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */

	
	public List<Object> peopleAgeGreaterThanAvgAge() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return complex5Dao.peopleAgeGreaterThanAvgAge();
		
	}
	
}

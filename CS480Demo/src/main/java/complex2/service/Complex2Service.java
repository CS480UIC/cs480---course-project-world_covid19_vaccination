package complex2.service;

import java.util.List;

import complex2.dao.Complex2Dao;
import complex2.domain.Complex2;

/**
 * logic functions such as register, login
 * @author changxin bai
 *
 */
public class Complex2Service {
	private Complex2Dao complex2Dao = new Complex2Dao();
	
	/**
	 * register a user
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */

	
	public List<Object> hospitalVaccineInfo() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return complex2Dao.hospitalVaccineInfo();
		
	}
	
}

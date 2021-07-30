package VaccineSimple3.service;

import java.util.List;

import VaccineSimple3.dao.VaccineSimple3Dao;
import VaccineSimple3.domain.VaccineAvgProtectionByType;

/**
 * logic functions such as register, login
 * @author changxin bai
 *
 */
public class VaccineSimple3Service {
	private VaccineSimple3Dao VaccineSimple3Dao = new VaccineSimple3Dao();
	
	/**
	 * register a user
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */

	
	public List<Object> avgProtectionByType() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return VaccineSimple3Dao.avgProtectionByType();
		
	}
	
}

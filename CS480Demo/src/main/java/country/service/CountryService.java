package country.service;

import java.util.List;

import country.dao.CountryDao;
import country.domain.Country;

/**
 * logic functions such as register, login
 * @author changxin bai
 *
 */
public class CountryService {
	private CountryDao countryDao = new CountryDao();
	
	/**
	 * register a user
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void insert(Country form) throws CountryException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the user name
//		People people = peopleDao.findByName(form.getName());
//		if(people.getName()!=null && people.getName().equals(form.getName())) throw new PeopleException("The people name already exists!");
		countryDao.add(form);
	}
	
	
public void delete() throws CountryException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the user name
//		People people = peopleDao.findByName(form.getName());
//		if(people.getName()==null && !(people.getName().equals(form.getName()))) throw new PeopleException("The people name does not exist!");
		countryDao.delete();
	}

public void update(Country form) throws CountryException, ClassNotFoundException, InstantiationException, IllegalAccessException{
	
	countryDao.update(form);
}
	
	
	/**
	 * Login function
	 * @param form
	 * @return
	 * @throws UserException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void read() throws CountryException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		countryDao.read();
		
	}
	
	public List<Object> orderByAbbreviation() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return countryDao.orderByAbbreviation();
		
	}
	
	
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return countryDao.findall();
		
	}
}

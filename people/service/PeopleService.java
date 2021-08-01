package people.service;

import java.util.List;

import people.dao.PeopleDao;
import people.domain.People;
import user.domain.User;
import user.service.UserException;

/**
 * logic functions such as register, login
 * @author changxin bai
 *
 */
public class PeopleService {
	private PeopleDao peopleDao = new PeopleDao();
	
	/**
	 * register a user
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void insert(People form) throws PeopleException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the user name
//		People people = peopleDao.findByName(form.getName());
//		if(people.getName()!=null && people.getName().equals(form.getName())) throw new PeopleException("The people name already exists!");
		peopleDao.add(form);
	}
	
	
public void delete(int age) throws PeopleException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the user name
//		People people = peopleDao.findByName(form.getName());
//		if(people.getName()==null && !(people.getName().equals(form.getName()))) throw new PeopleException("The people name does not exist!");
		peopleDao.delete(age);
	}

public void update(People form) throws PeopleException, ClassNotFoundException, InstantiationException, IllegalAccessException{
	
	peopleDao.update(form);
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
	public void read() throws PeopleException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		peopleDao.read();
		
	}
	
	
	public List<Object> findByHospital(String hospital) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return peopleDao.findByHospitalName(hospital);
		
	}
	
	
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return peopleDao.findall();
		
	}
}

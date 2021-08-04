package vaccine.service;

import java.util.List;

import vaccine.dao.VaccineDao;
import vaccine.domain.Vaccine;
import vaccine.domain.Vaccine;

/**
 * logic functions such as register, login
 * @author changxin bai
 *
 */
public class VaccineService {
	private VaccineDao vaccineDao = new VaccineDao();
	
	/**
	 * register a user
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void insert(Vaccine form) throws VaccineException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the user name
//		People people = peopleDao.findByName(form.getName());
//		if(people.getName()!=null && people.getName().equals(form.getName())) throw new PeopleException("The people name already exists!");
		vaccineDao.add(form);
	}
	
	
public void delete(double protectionRate) throws VaccineException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the user name
//		People people = peopleDao.findByName(form.getName());
//		if(people.getName()==null && !(people.getName().equals(form.getName()))) throw new PeopleException("The people name does not exist!");
		vaccineDao.delete(protectionRate);
	}

public void update(Vaccine form) throws VaccineException, ClassNotFoundException, InstantiationException, IllegalAccessException{
	
	vaccineDao.update(form);
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
	public void read() throws VaccineException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		vaccineDao.read();
		
	}
	
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return vaccineDao.findall();
		
	}
}

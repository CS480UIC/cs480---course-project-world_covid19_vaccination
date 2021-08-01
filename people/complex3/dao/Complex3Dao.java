 package complex3.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import java.util.ArrayList;
import java.util.List;

import complex3.domain.Complex3;


/**
 * DDL functions performed in database
 * @author changxin bai
 *
 */
public class Complex3Dao {

/**
* get the search result with number
* @param peoplename
* @return
* @throws ClassNotFoundException
* @throws IllegalAccessException
* @throws InstantiationException
*/
	
public List<Object> sumOfVaccinatedPeopleGreaterThan150000() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
	List<Object> list = new ArrayList<>();
	try {
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		Connection connect = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/world_covid19_vaccination?"
						+ "user=root&password=123456");

		String sql = "select state.country_name, sum(vaccinated_people) as sum_of_vaccinated_people\r\n"
				+ "from state\r\n"
				+ "inner join hospital\r\n"
				+ "on state.state_name = hospital.state_name\r\n"
				+ "group by country_name\r\n"
				+ "having sum_of_vaccinated_people > 150000;";
		PreparedStatement preparestatement = connect.prepareStatement(sql);
		ResultSet resultSet = preparestatement.executeQuery();

		while(resultSet.next()){
			Complex3 complex3 = new Complex3();
			complex3.setCountryName(resultSet.getString("country_name"));
			complex3.setSumOfVaccinatedPeople(resultSet.getString("sum_of_vaccinated_people"));
			list.add(complex3);
		}

	} catch(SQLException e) {
		throw new RuntimeException(e);
	}
	return list;
}

}

 package complex4.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import java.util.ArrayList;
import java.util.List;

import complex4.domain.Complex4;


/**
 * DDL functions performed in database
 * @author changxin bai
 *
 */
public class Complex4Dao {

/**
* get the search result with number
* @param peoplename
* @return
* @throws ClassNotFoundException
* @throws IllegalAccessException
* @throws InstantiationException
*/
	
public List<Object> statePopulationGreaterThanAvgPopulation() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
	List<Object> list = new ArrayList<>();
	try {
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		Connection connect = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/world_covid19_vaccination?"
						+ "user=root&password=123456");

		String sql = "select country_name, state_name, population\r\n"
				+ "from state S\r\n"
				+ "where population > (select avg(population)\r\n"
				+ "from state\r\n"
				+ "where country_name = S.country_name)\r\n"
				+ "order by country_name;";

		PreparedStatement preparestatement = connect.prepareStatement(sql);
		ResultSet resultSet = preparestatement.executeQuery();

		while(resultSet.next()){
			Complex4 complex4 = new Complex4();
			complex4.setCountryName(resultSet.getString("country_name"));
			complex4.setStateName(resultSet.getString("state_name"));
			complex4.setPopulation(resultSet.getInt("population"));
			list.add(complex4);
		}

	} catch(SQLException e) {
		throw new RuntimeException(e);
	}
	return list;
}

}

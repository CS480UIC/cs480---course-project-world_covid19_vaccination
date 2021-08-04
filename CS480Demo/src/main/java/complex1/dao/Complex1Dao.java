 package complex1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import java.util.ArrayList;
import java.util.List;

import complex1.domain.Complex1;


/**
 * DDL functions performed in database
 * @author changxin bai
 *
 */
public class Complex1Dao {

/**
* get the search result with number
* @param peoplename
* @return
* @throws ClassNotFoundException
* @throws IllegalAccessException
* @throws InstantiationException
*/
	
public List<Object> countryPopulation() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
	List<Object> list = new ArrayList<>();
	try {
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		Connection connect = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/world_covid19_vaccination?"
						+ "user=root&password=123456");

		String sql = "select country_abbreviation, sum(population) as 'country_population'\r\n"
				+ "from country \r\n"
				+ "inner join state\r\n"
				+ "on country.country_name = state.country_name\r\n"
				+ "group by state.country_name\r\n"
				+ "order by country_population desc;";
		PreparedStatement preparestatement = connect.prepareStatement(sql);
		ResultSet resultSet = preparestatement.executeQuery();

		while(resultSet.next()){
			Complex1 complex1 = new Complex1();
			complex1.setCountryAbbreviation(resultSet.getString("country_abbreviation"));
			complex1.setCountryPopulation(resultSet.getInt("country_population"));
			list.add(complex1);
		}

	} catch(SQLException e) {
		throw new RuntimeException(e);
	}
	return list;
}

}

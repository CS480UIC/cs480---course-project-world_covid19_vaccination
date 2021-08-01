 package complex5.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import java.util.ArrayList;
import java.util.List;

import complex5.domain.Complex5;


/**
 * DDL functions performed in database
 * @author changxin bai
 *
 */
public class Complex5Dao {

/**
* get the search result with number
* @param peoplename
* @return
* @throws ClassNotFoundException
* @throws IllegalAccessException
* @throws InstantiationException
*/
	
public List<Object> peopleAgeGreaterThanAvgAge() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
	List<Object> list = new ArrayList<>();
	try {
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		Connection connect = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/world_covid19_vaccination?"
						+ "user=root&password=123456");

		String sql = "select city, P.hospital_name, name, ID, date_of_birth\r\n"
				+ "from people P\r\n"
				+ "inner join hospital\r\n"
				+ "on P.hospital_name = hospital.hospital_name\r\n"
				+ "where age > (select avg(age)\r\n"
				+ "from people\r\n"
				+ "where hospital_name = P.hospital_name)\r\n"
				+ "order by hospital_name asc, name asc;";
		PreparedStatement preparestatement = connect.prepareStatement(sql);
		ResultSet resultSet = preparestatement.executeQuery();

		while(resultSet.next()){
			Complex5 complex5 = new Complex5();
			complex5.setCity(resultSet.getString("city"));
			complex5.setHospitalName(resultSet.getString("hospital_name"));
			complex5.setName(resultSet.getString("name"));
			complex5.setID(resultSet.getInt("ID"));
			complex5.setDateOfBirth(resultSet.getString("date_of_birth"));
			list.add(complex5);
		}

	} catch(SQLException e) {
		throw new RuntimeException(e);
	}
	return list;
}

}
